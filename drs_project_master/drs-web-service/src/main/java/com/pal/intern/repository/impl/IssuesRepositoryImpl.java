package com.pal.intern.repository.impl;

import com.pal.intern.config.app.TimeProvider;
import com.pal.intern.config.redmine.RedmineProviderFactory;
import com.pal.intern.repository.IssuesRepository;
import com.taskadapter.redmineapi.Include;
import com.taskadapter.redmineapi.IssueManager;
import com.taskadapter.redmineapi.Params;
import com.taskadapter.redmineapi.RedmineException;
import com.taskadapter.redmineapi.bean.Issue;
import com.taskadapter.redmineapi.internal.ResultsWrapper;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Repository
public class IssuesRepositoryImpl implements IssuesRepository {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private RedmineProviderFactory redmineProviderFactory;

    @Autowired
    private TimeProvider timeProvider;

    @Override
    public Issue getIssueById(int id) throws RedmineException {
        IssueManager issueManager = redmineProviderFactory.getRedmineManager().getIssueManager();
        Issue issue = issueManager.getIssueById(id, Include.watchers);
        return issue;
    }

    @Override
    public ResultsWrapper<Issue> getListIssuesByProjectId(int projectId, int offset, int limit) throws RedmineException {
        IssueManager issueManager = redmineProviderFactory.getRedmineManager().getIssueManager();
        Map<String, String> parameters = new HashMap<>();
        parameters.put("project_id", String.valueOf(projectId));
        parameters.put("offset", String.valueOf(offset));
        parameters.put("limit", String.valueOf(limit));
        parameters.put("status_id", "*");
        return issueManager.getIssues(parameters);
    }

    @Override
    public ResultsWrapper<Issue> getAllIssues(int offset, int limit) throws RedmineException {
        IssueManager issueManager = redmineProviderFactory.getRedmineManager().getIssueManager();
        Map<String, String> parameters = new HashMap<>();
        parameters.put("offset", String.valueOf(offset));
        parameters.put("limit", String.valueOf(limit));
        parameters.put("status_id", "*");
        return issueManager.getIssues(parameters);
    }

    @Override
    public ResultsWrapper<Issue> getIssuesWithParam(MultiValueMap<String, Object> params) throws RedmineException {
        IssueManager issueManager = redmineProviderFactory.getRedmineManager().getIssueManager();
        Params p = new Params();
        params.forEach((k,l) -> {
            l.forEach(v->{
            p.add(k, String.valueOf(v));
            });
        });
        return issueManager.getIssues(p);

    }

    @Override
    public ResultsWrapper<Issue> getListIssuesWithUpdateOnToDay() throws RedmineException {
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("f[]", "updated_on");
        params.add("op[updated_on]", "~");
        params.add("v[updated_on][]", timeProvider.getToDay());
        return this.getIssuesWithParam(params);
    }

    @Override
    public List<Issue> getIssueIncludeJournal(ResultsWrapper<Issue> rw) throws RedmineException {
        List<Issue> issues = Collections.emptyList();
        IssueManager issueManager = redmineProviderFactory.getRedmineManager().getIssueManager();
        if (rw != null && rw.hasSomeResults()) {
            issues = new LinkedList<>();
            List<Issue> resultList = rw.getResults();
            for (Issue issue : resultList) {
                issues.add(issueManager.getIssueById(issue.getId(), Include.journals, Include.relations, Include.attachments, Include.changesets, Include.watchers));

            }

        }
        return issues;
    }

    @Override
    public ResultsWrapper<Issue> IssueIncludeJournalWithUpdateOn(LocalDateTime localDateTime, String comparePattern) throws RedmineException {
        IssueManager issueManager = redmineProviderFactory.getRedmineManager().getIssueManager();
        Params params = new Params();
        StringBuilder filterValue = new StringBuilder();
        String LocalDatimeNow = timeProvider.getLocalDateTimeWithZuluFormat(localDateTime);
        filterValue.append(comparePattern);
        filterValue.append(LocalDatimeNow);
        LOGGER.info(filterValue.toString());
        params.add("updated_on", filterValue.toString());
        return issueManager.getIssues(params);
    }

}
