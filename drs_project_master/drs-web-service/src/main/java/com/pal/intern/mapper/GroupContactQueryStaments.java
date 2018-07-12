package com.pal.intern.mapper;

public class GroupContactQueryStaments {

    /*
    column name
     */
    public static final String GROUP_CONTACT_TABLE_NAME = "drs_group_contact";
    public static final String GROUP_CONTACT_ID_COL = "group_contact_id";
    public static final String GROUP_CONTACT_NAME_COL = "group_contact_name";
    public static final String USER_ID_COL = "user_id";
    public static final String GROUP_CONTACT_STATUS_COL = "group_contact_status";
    /*
    Query staments
     */
    public static final String UP_IS_GROUP_CONTACT_OWNER = "CALL up_DRSIsGcOwner(?,?)";

    public static final String UP_GET_GC_BY_ID_AND_STATUS = "CALL up_DRSGetGcByIdAndStatus(?,?)";

    public static final String UP_GET_ALL_GC_BY_USER_ID_STATUS = "CALL up_DRSGetAllGcByUserIdAndStatus(?, ?, ?, ?, ?)";

    public static final String UP_CREATE_GC = "{CALL up_DSRCreateGroupContact(?, ?, ?)}";

    public static final String UP_UPDATE_GC_BY_ATTRIBUTE = "{CALL up_DSRUpdateTable(?,?,?,?,?,?,?)}";

    public static final String UP_GC_PAGING = "CALL up_DSRPagingPerQuery(?, ?, ?,?)";
}
