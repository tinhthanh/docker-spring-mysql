package com.pal.intern.repository;

import com.taskadapter.redmineapi.RedmineException;
import com.taskadapter.redmineapi.bean.Issue;
import com.taskadapter.redmineapi.internal.ResultsWrapper;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.util.MultiValueMap;

/**
 *
 * @author tyler.intern
 */
public interface IssuesRepository {

    public Issue getIssueById(int id) throws RedmineException;

    public ResultsWrapper<Issue> getListIssuesByProjectId(int projectId, int offset, int limit) throws RedmineException;

    public ResultsWrapper<Issue> getAllIssues(int offset, int limit) throws RedmineException;

    public ResultsWrapper<Issue> getIssuesWithParam(MultiValueMap<String,Object> params) throws RedmineException;

    public ResultsWrapper<Issue> getListIssuesWithUpdateOnToDay() throws RedmineException;

    public ResultsWrapper<Issue> IssueIncludeJournalWithUpdateOn(LocalDateTime localDateTime,String comparePattern) throws RedmineException;

    public List<Issue> getIssueIncludeJournal(ResultsWrapper<Issue> rw) throws RedmineException;

}
