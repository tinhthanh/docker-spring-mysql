package com.pal.intern.mapper;

public class IssueTrackerQueryStament {

    public static final String ISSUE_TRACKER_ID_COL = "issue_tracker_id";
    public static final String USER_NAME_COL = "user_name";
    public static final String ISSUE_ID_COL = "issue_id";
    public static final String UPDATE_TIME_COL = "update_time";
    public static final String ISSUE_TRACKER_STATUS_COL = "issue_tracker_status";

    public static final String UP_CREATE_ISSUE_TRACKER = "CALL up_DRSCreateIssueTracker(?,?,?,?)";
    
    public static final String UP_GET_ISSUE_TRACKER="CALL up_DRSGetIssueTrackerByUserNameAndDate(?,?,?,?,?)";
    
    public static final String UP_GET_ALL_ISSUE_TRACKER ="CALL up_DRSGetAllIssueTrackerByUserNameAndDate(?,?)";
}
