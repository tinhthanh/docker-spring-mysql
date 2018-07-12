package com.pal.intern.mapper;

public class PrivilegesQueryStaments {

    public static final String REPORT_PRIVILEGES_ID_COL = "report_privileges_id";
    public static final String USER_ID_COL = "user_id";
    public static final String USER_REPORT_NAME_COL = "user_report_name";
    public static final String USER_REPORT_ID_COL ="user_report_id";
    public static final String START_DATE_COL ="start_date";
    public static final String END_DATE_COL  ="end_date";
    public static final String PRIVILEGES_STATUS_COL ="privileges_status";
    
    /*
    Query staments
     */
    public static final String QUERY_GET_LIST = "SELECT report_privileges_id , user_id , user_report_name , user_report_id , start_date , end_date , privileges_status FROM  drs_report_privileges where user_id  = ? ;";
    public static final String QUERY_ADD_PRIVILEGES = "INSERT INTO drs_report_privileges  (user_id, user_report_name, user_report_id, start_date, end_date, privileges_status ) VALUES ( ?,  ?  , ? , ? , ?  , ? );";
    public static final String QUERY_DELETE_PRIVILEGES = "DELETE FROM drs_report_privileges where report_privileges_id =  ?  ";
    public static final String QUERY_GET_LIST_VIEW_BY_ID = "SELECT report_privileges_id , user_id , user_report_name , user_report_id , start_date , end_date , privileges_status FROM drs_report_privileges where user_id = ? and now()  BETWEEN  start_date and end_date ;";
}
