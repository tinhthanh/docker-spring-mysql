package com.pal.intern.service.impl;

import com.pal.intern.config.redmine.IssueStatus;
import com.pal.intern.domain.ConvertProvider;
import com.pal.intern.domain.IssueMapper;
import com.pal.intern.repository.IssuesRepository;
import com.pal.intern.service.IssueService;
import com.taskadapter.redmineapi.RedmineException;
import com.taskadapter.redmineapi.bean.Issue;
import com.taskadapter.redmineapi.bean.JournalDetail;
import com.taskadapter.redmineapi.internal.ResultsWrapper;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

@Service
public class IssueServiceImpl implements IssueService {

    @Autowired
    private IssuesRepository issuesRepository;

    @Override
    public IssueMapper getIssueById(int id) throws RedmineException {
        Issue issue = this.issuesRepository.getIssueById(id);
        IssueMapper result = ConvertProvider.from(issue);
        return result;

    }

    @Override
    public Map<String, Object> getListIssuesByProjectId(int projectId, int offset, int limit) throws RedmineException {
        ResultsWrapper<Issue> rw = this.issuesRepository.getListIssuesByProjectId(projectId, offset, limit);
        List<IssueMapper> issueMappers = new LinkedList<>();
        List<Issue> issues = rw.getResults();
        issues.forEach(i -> {
            issueMappers.add(ConvertProvider.from(i));
        });
        Map<String, Object> result = new HashMap<>();

        result.put("listOfIssues", issueMappers);
        result.put("offset", rw.getOffsetOnServer());
        result.put("totalCount", rw.getLimitOnServer());
        result.put("totalCount", rw.getTotalFoundOnServer());

        return result;
    }

    @Override
    public Map<String, Object> getAllIssues(int offset, int limit) throws RedmineException {

        ResultsWrapper<Issue> rw = this.issuesRepository.getAllIssues(offset, limit);
        List<IssueMapper> issueMappers = new LinkedList<>();
        List<Issue> issues = rw.getResults();
        issues.forEach(i -> {
            issueMappers.add(ConvertProvider.from(i));
        });
        Map<String, Object> result = new HashMap<>();
        result.put("listOfIssues", issueMappers);
        result.put("offset", rw.getOffsetOnServer());
        result.put("totalCount", rw.getLimitOnServer());
        result.put("totalCount", rw.getTotalFoundOnServer());

        return result;

    }

    @Override
    public Map<String, Object> getIssuesWithParam(MultiValueMap<String,Object> params) throws RedmineException {

        if (!params.containsKey("status_id")) {
            params.add("status_id", "*");
        }
        ResultsWrapper<Issue> rw = this.issuesRepository.getIssuesWithParam(params);
        List<IssueMapper> issueMappers = new LinkedList<>();
        List<Issue> issues = rw.getResults();
        issues.forEach(i -> {
            issueMappers.add(ConvertProvider.from(i));
        });
        Map<String, Object> result = new HashMap<>();
        result.put("listOfIssues", issueMappers);
        result.put("offset", rw.getOffsetOnServer());
        result.put("totalCount", rw.getLimitOnServer());
        result.put("totalCount", rw.getTotalFoundOnServer());

        return result;
    }

    @Override
    public boolean checkJournalDetailChangeStatus(List<JournalDetail> jd, List<Integer> oldStatus, List<Integer> newStatus) {
        boolean checkIssueStatusChange;
        checkIssueStatusChange = jd.stream().anyMatch(j -> {
            return j.getName().equals("status_id") && oldStatus.contains(Integer.valueOf(j.getOldValue())) && newStatus.contains(Integer.valueOf(j.getNewValue()));
        });
        return checkIssueStatusChange;
    }

    @Override
    public List<Issue> getIssueIncludeJournalWithUpdateOnToDay() throws RedmineException {

        return this.issuesRepository.getIssueIncludeJournal(this.issuesRepository.getListIssuesWithUpdateOnToDay());
    }

    @Override
    public boolean checkJournalDetailChangeStatus(List<JournalDetail> jd) {
        List<Integer> oldStatus = Arrays.asList(IssueStatus.NEW.getValue());
        List<Integer> newStatus = Arrays.asList(IssueStatus.DONE.getValue(), IssueStatus.RESOLVED.getValue(), IssueStatus.IN_PROCESS.getValue());
        return this.checkJournalDetailChangeStatus(jd, oldStatus, newStatus);
    }

    @Override
    public List<Issue> IssueIncludeJournalWithUpdateOn(LocalDateTime localDateTime, String comparePattern) throws RedmineException {
        return this.issuesRepository.getIssueIncludeJournal(this.issuesRepository.IssueIncludeJournalWithUpdateOn(localDateTime, comparePattern));
    }

}
