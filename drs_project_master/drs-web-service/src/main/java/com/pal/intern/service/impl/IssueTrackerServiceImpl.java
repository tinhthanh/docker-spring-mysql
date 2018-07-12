package com.pal.intern.service.impl;

import com.pal.intern.domain.IssueMapper;
import com.pal.intern.domain.IssueStatusTracker;
import com.pal.intern.domain.IssueStatusTrackers;
import com.pal.intern.domain.User;
import com.pal.intern.model.ChatMessage;
import com.pal.intern.model.NotifyContent;
import com.pal.intern.repository.IssueTrackerRepository;
import com.pal.intern.service.IssueService;
import com.pal.intern.service.IssueTrackerService;
import com.pal.intern.service.UserRedmineService;
import com.pal.intern.services.NotifyService;
import com.taskadapter.redmineapi.RedmineException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedCaseInsensitiveMap;

@Service
public class IssueTrackerServiceImpl implements IssueTrackerService {

    private final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(this.getClass().getName());
    @Autowired
    private IssueTrackerRepository issueTrackerRepository;

    @Autowired
    private UserRedmineService userRedmineService;

    @Autowired
    private com.pal.intern.service.UserService userService;

    @Autowired
    private IssueService issueService;
    @Autowired
    private SimpMessagingTemplate template;

    @Override
    public List<Integer> createIssueTracker(List<IssueStatusTracker> listIssueTracker) {
        List<Integer> result = new LinkedList<>();
        if (listIssueTracker != null && !listIssueTracker.isEmpty()) {
            listIssueTracker.forEach(i -> {
                String userEmail = this.userRedmineService.getUserEmailByUserId(i.getRedmineUserId());
                if (userEmail != null) {
                    Optional<User> user = this.userService.getUserByEmail(userEmail);
                    if (user.isPresent()) {
                        int issueTrackerId = this.issueTrackerRepository.insertIssueTrackerId(user.get().getUserName(), i.getIssueId(), i.getTimeUpdate());
                        if (issueTrackerId > 0) {

                            NotifyContent notify = new NotifyContent();
                            notify.setStatus(1);
                            notify.setTitle("Redmine change..");
                            notify.setUserSend("system");
                            notify.setBody("");
                            notify.setDateTo(new Date().getTime());
                            template.convertAndSend("/listen-change-res/change", new ChatMessage(notify, user.get().getUserName()));
                            LOGGER.info(user.get().getUserName());
                        }
                        result.add(issueTrackerId);
                    }
                }
            });
        }
        return result;
    }

    @Override
    public Map<String, Object> getIssueStatusTrackerWithPaging(String userName, LocalDate timeUpdate, int page, int pageSize) {
        return this.issueTrackerRepository.getIssueStatusTrackerWithPaging(userName, timeUpdate, page, pageSize);

    }

    @Override
    public Map<String, Object> getIssueByTrackerWithPaging(String userName, LocalDate timeUpdate, int page, int pageSize) {
        Map<String, Object> issueQuery = this.issueTrackerRepository.getIssueStatusTrackerWithPaging(userName, timeUpdate, page, pageSize);
        Map<String, Object> result = new HashMap<>();
        if (issueQuery != null && !issueQuery.isEmpty()) {
            Integer totalRecords = Integer.valueOf(issueQuery.get("totalRecords").toString());
            List<LinkedCaseInsensitiveMap> listOfResult = (List<LinkedCaseInsensitiveMap>) issueQuery.get("listOfResults");
            result.put("totalRecords", totalRecords);
            if (totalRecords > 0) {
                listOfResult.forEach(l -> {
                    try {
                        IssueMapper issueMapper = this.issueService.getIssueById((Integer) l.get("issueId"));
                        l.put("issueInfo", issueMapper);
                    } catch (RedmineException ex) {
                        LOGGER.error("error with excute getIssueById() with paramater" + Arrays.asList(l.get("issueId")), ex);

                    }
                });
                result.put("listOfResults", listOfResult);
            }

        }

        return result;
    }

    @Override
    public List<IssueMapper> getIssueByStatusTracker(String userName, LocalDate timeUpdate) {
        List<IssueStatusTrackers> issueStatusTrackerses = this.issueTrackerRepository.getAllIssueStatusTrackerByUserNameAndTimeUpdate(userName, timeUpdate);
        List<IssueMapper> result = new LinkedList<>();
        if (issueStatusTrackerses != null) {
            issueStatusTrackerses.forEach(i -> {
                try {
                    IssueMapper issueMapper = this.issueService.getIssueById(i.getIssueId());
                    result.add(issueMapper);
                } catch (RedmineException ex) {
                    LOGGER.error("error with excute getIssueById() with paramater" + Arrays.asList(i.getIssueId()), ex);

                }
            });

        }

        return result;
    }

}
