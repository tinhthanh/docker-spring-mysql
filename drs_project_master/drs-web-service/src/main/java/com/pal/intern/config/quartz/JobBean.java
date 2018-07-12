package com.pal.intern.config.quartz;

import com.pal.intern.domain.IssueStatusTracker;
import com.pal.intern.service.IssueService;
import com.pal.intern.service.IssueTrackerService;
import com.taskadapter.redmineapi.RedmineException;
import com.taskadapter.redmineapi.bean.Issue;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("jobBean")
public class JobBean {

    @Autowired
    private CacheService cacheService;

    @Autowired
    private IssueService issueService;

    @Autowired
    private IssueTrackerService issueTrackerService;

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getName());

    public void loadDataTocache() {
        cacheService.getAllConfigParam();

    }

    public void evictCacheForParamConfig() {
        LOGGER.info("evict cache for param config");
        cacheService.evictCacheForGetAllConfigParam();
    }

    public void getIssueChangeStatus() {
        LocalDateTime lastTimeCheck;
        CacheManager cm = CacheManager.getInstance();
        Cache cache = cm.getCache("last_time_check_issue");

        // list issue to check
        List<Issue> issues = Collections.emptyList();

        List<IssueStatusTracker> listIssueTracker = new LinkedList<>();
        if (cache.get("last_time_check_issue") == null) {
            LOGGER.info("last_time_check_issue null");
            lastTimeCheck = LocalDateTime.of(LocalDate.now(), LocalTime.MIDNIGHT);
            try {
                issues = issueService.getIssueIncludeJournalWithUpdateOnToDay();
            } catch (RedmineException ex) {
                LOGGER.error(ex.getMessage());
            }

        } else {
            LOGGER.info("last_time_check_issue not null");
            lastTimeCheck = (LocalDateTime) cache.get("last_time_check_issue").getObjectValue();

            LocalDateTime midNight = LocalDateTime.of(LocalDate.now(), LocalTime.MIDNIGHT);
            if (lastTimeCheck.isBefore(midNight)) {
                lastTimeCheck = midNight;
            }

            try {
                issues = issueService.IssueIncludeJournalWithUpdateOn(lastTimeCheck, ">=");
            } catch (RedmineException ex) {
                LOGGER.error(ex.getMessage());
            }

        }
        LOGGER.info(lastTimeCheck.toString());

        if (issues != null) {
            LOGGER.info("[check list issue] " + issues.toString());
            final LocalDateTime ltc = lastTimeCheck;

            issues.forEach(i -> {
                i.getJournals().forEach(j -> {
                    LocalDateTime createOnLdt = LocalDateTime.ofInstant(j.getCreatedOn().toInstant(), ZoneId.systemDefault());
                    // check journal (status change valid) and journal is create after last time check
                    if (issueService.checkJournalDetailChangeStatus(j.getDetails()) && ltc.isBefore(createOnLdt)) {
                        listIssueTracker.add(new IssueStatusTracker(j.getUser().getId(), i.getId(), j.getCreatedOn()));

                    }
                });
            });
        }
        // save data to database
        List<Integer> issueTrackerId = issueTrackerService.createIssueTracker(listIssueTracker);

        // update last time check to cache
        if (cache.get("last_time_check_issue") == null) {
            cache.put(new Element("last_time_check_issue", LocalDateTime.now()));
            LOGGER.info(((LocalDateTime) cache.get("last_time_check_issue").getObjectValue()).toString());
        } else {
            cache.replace(new Element("last_time_check_issue", LocalDateTime.now()));
            LOGGER.info(((LocalDateTime) cache.get("last_time_check_issue").getObjectValue()).toString());
        }
        LOGGER.info(listIssueTracker.toString() + "[redmine userId-issue change]");
        LOGGER.info(issueTrackerId.toString() + "[list issue tracker after save]");

    }
}
