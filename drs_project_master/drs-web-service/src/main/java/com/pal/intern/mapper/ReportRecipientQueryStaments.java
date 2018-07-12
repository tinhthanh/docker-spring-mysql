package com.pal.intern.mapper;

public class ReportRecipientQueryStaments {

    /*
    column name
     */
    public static final String REPORT_RECIPIENT_ID_COL = "report_recipient_id";
    public static final String REPORT_RECIPIENT_EMAIL_COL = "report_recipient_email";
    public static final String REPORT_RECIPIENT_ACTION_COL = "report_recipient_action";

    /*
    Query staments
     */
    public static final String UP_CREATE_REPORT_RECIPIENT = "{CALL up_DSRCreateReportRecipient(?,?,?,?)}";

    public static final String UP_GET_RECIPIENTS_BY_REPORT_ID = "CALL up_DRSGetRecipientsByReportID(?)";
}
