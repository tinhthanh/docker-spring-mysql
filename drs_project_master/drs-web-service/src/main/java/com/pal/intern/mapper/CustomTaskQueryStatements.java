package com.pal.intern.mapper;

public class CustomTaskQueryStatements {

    /*field*/

    public static final String CUSTOM_TASK_TABLE_NAME = "drs_custom_task";
    public static final String CUSTOM_TASK_ID_COL = "custom_task_id";
    public static final String CUSTOM_TASK_NAME_COL = "task_name";
    public static final String CUSTOM_TASK_DESCRIPTION_COL = "description";
    public static final String CUSTOM_TASK_TARGET_DATE_COL = "target_date";
    public static final String CUSTOM_TASK_TASK_STATUS_COL = "task_status";
    public static final String CUSTOM_TASK_REMARK_COL = "user_id";

    /*query*/
    public static final String UP_GET_CUSTOM_TASK_BY_USERID_WITH_PAGING = "CALL up_DSRGetCustomTaskByUserIdWithPaging(?,?,?,?)";
    public static final String UP_REPORT_BY_USER_ID_AND_STATUS = "CALL up_DSRPagingPerQuery(?,?,?,?)";
    public static final String UP_CREATE_CUSTOM_TASK = "call up_DRSCreateCustomTask(?,?,?,?,?,?)";
    public static final String QUERY_GET_CUSTOM_TASK_BY_ID = "CALL up_DRSGetCustomTaskByID(?)";
    public static final String QUERY_CHECK_CUSTOM_TASK_OWNER = "CALL up_DRSCheckOwnerCustomTask(?,?)";
    public static final String UP_DELETE_CUSTOM_TASK = "CALL up_DRSDeleteCustomTask(?)";
    public static final String QUERY_CHECK_CUSTOM_TASK_DELETED = "CALL up_DRSCheckCustomTaskDeleted(?)";
    public static final String UP_UPDATE_CUSTOM_TASK = "CALL up_DRSUpdateCustomTask(?,?,?,?,?,?)";
    public static final String UP_UPDATE_CUSTOM_TASK_BY_ATTRIBUTE = "{call up_DSRUpdateTable(?,?,?,?,?,?,?)}";
}
