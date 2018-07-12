package com.pal.intern.repository;

import com.pal.intern.domain.IssueStatusTrackers;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface IssueTrackerRepository {

    public int insertIssueTrackerId(String userName, int issueId, Date updateTime);

    public Map<String, Object> getIssueStatusTrackerWithPaging(String userName, LocalDate timeUpdate, int page, int pageSize);

    public List<IssueStatusTrackers> getAllIssueStatusTrackerByUserNameAndTimeUpdate(String userName, LocalDate timeUpdate);
}
