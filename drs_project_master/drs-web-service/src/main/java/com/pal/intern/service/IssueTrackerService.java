package com.pal.intern.service;

import com.pal.intern.domain.IssueMapper;
import com.pal.intern.domain.IssueStatusTracker;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface IssueTrackerService {

    public List<Integer> createIssueTracker(List<IssueStatusTracker> listIssueTracker);

    public Map<String, Object> getIssueStatusTrackerWithPaging(String userName, LocalDate timeUpdate, int page, int pageSize);

    public Map<String, Object> getIssueByTrackerWithPaging(String userName, LocalDate timeUpdate, int page, int pageSize);

    public List<IssueMapper> getIssueByStatusTracker(String userName, LocalDate timeUpdate);

}
