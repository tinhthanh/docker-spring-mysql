package com.pal.intern.service;

import com.pal.intern.domain.IssueMapper;
import com.taskadapter.redmineapi.RedmineException;
import com.taskadapter.redmineapi.bean.Issue;
import com.taskadapter.redmineapi.bean.JournalDetail;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import org.springframework.util.MultiValueMap;

public interface IssueService {

    public IssueMapper getIssueById(int id) throws RedmineException;

    public Map<String, Object> getListIssuesByProjectId(int projectId, int offset, int limit) throws RedmineException;

    public Map<String, Object> getAllIssues(int offset, int limit) throws RedmineException;

    public Map<String, Object> getIssuesWithParam(MultiValueMap<String,Object> params) throws RedmineException;

    public boolean checkJournalDetailChangeStatus(List<JournalDetail> jd, List<Integer> oldStatus, List<Integer> newStatus);

    public boolean checkJournalDetailChangeStatus(List<JournalDetail> jd);

    public List<Issue> getIssueIncludeJournalWithUpdateOnToDay() throws RedmineException;

    public List<Issue> IssueIncludeJournalWithUpdateOn(LocalDateTime localDateTime,String comparePattern) throws RedmineException;

}
