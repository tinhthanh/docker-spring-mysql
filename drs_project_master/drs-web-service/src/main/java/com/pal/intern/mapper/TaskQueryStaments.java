package com.pal.intern.mapper;

public class TaskQueryStaments {

    /*
    column name
     */
    public static final String TASK_TABLE_NAME = "drs_task";
    public static final String TASK_ID_COL = "task_id";
    public static final String TASK_NAME_COL = "task_name";
    public static final String TASK_DESCRIPTION_COL = "description";
    public static final String TASK_TARGET_DATE_COL = "target_date";
    public static final String TASK_STATUS_COL = "task_status";
    public static final String TASK_REMARK_COL = "remark";
    public static final String TASK_DATE_DEFINED = "task_date_defined";
    public static final String TASK_DELETE_STATUS_COL = "task_delete_status";

      /*
    Query staments
     */
    public static final String UP_CREATE_TASK = "{CALL up_DSRCreateTask(?, ?, ?, ?, ?, ?,?,?)}";

    public static final String UP_UPDATE_TASK_BY_ATRIBUTE = "{call up_DSRUpdateTable(?,?,?,?,?,?,?)}";

    public static final String UP_GET_LIST_TASK_BY_REPORT_ID = "CALL up_DRSGetListTaskByReportId(?)";

    public static final String UP_IS_TASK_OWNER = "CALL up_DRSIsTaskOwner(?, ?)";

    public static final String UP_GET_TASK_BY_ID = "CALL up_DRSGetTaskWithId(?)";

    public static final String UP_GET_TASK_BY_ID_AND_STATUS = "CALL up_DRSGetTaskWithIdAndStatus(?,?)";

    public static final String UP_UPDATE_TASK = "CALL up_DRSUpdateTask(?,?,?,?,?,?)";

}
