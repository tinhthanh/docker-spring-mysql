package com.pal.intern.mapper;

public class ReportQueryStaments {

    public static final String REPORT_TABLE_NAME = "drs_report";
    public static final String REPORT_ID_COL = "report_id";
    public static final String REPORT_SUBJECT_COL = "report_subject";
    public static final String REPORT_TYPE_COL = "report_type";
    public static final String REPORT_DATA_ETC_COL = "data_etc";
    public static final String REPORT_ACTION_TIME_COL = "action_time";

    /*
     Query staments
     */
    public static final String UP_CREATE_REPORT = "{CALL up_DSRCreateReport(?,?,?,?,?)}";

    public static final String UP_GET_REPORT_BY_ID = "CALL up_DRSGetReportById(?)";

    public static final String UP_REPORT_BY_USER_ID_AND_REPORT_TYPE = "CALL up_DRSGetReportByUserIdAndReportType(?,?)";

    public static final String UP_REPORT_BY_USER_ID_AND_REPORT_TYPE_PAGING = "CALL internship.up_DRSGetReportByUserIdAndReportTypeWithPaging(?,?,?,?,?)";

    public static final String UP_REPORT_BY_USER_AND_ID_REPORT_TYPE = "CALL up_DSRPagingPerQuery(?, ?, ?,?)";

    public static final String QUERY_CHECK_IS_REPORT_OWNER = "CALL up_DRSIsReportOwner(?,?)";

    public static final String UP_UPDATE_REPORT_BY_REPORT_ID = "CALL up_DRSUpdateReport(?,?,?,?)";

    public static final String UP_DELETE_REPORT_BY_REPORT_ID = "CALL up_DRSDeleteReport(?)";

    public static final String UP_UPDATE_REPORT_BY_ATTRIBUTE = "{CALL up_DSRUpdateTable(?,?,?,?,?,?,?)}";
}
