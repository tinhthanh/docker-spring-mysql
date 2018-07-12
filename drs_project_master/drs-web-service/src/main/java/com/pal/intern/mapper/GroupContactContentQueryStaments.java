package com.pal.intern.mapper;

public class GroupContactContentQueryStaments {

    /*
    column name
     */
    public static final String GROUP_CONTACT_CONTENT_TABLE_NAME = "drs_group_contact_content";
    public static final String GROUP_CONTACT_CONTENT_ID_COL = "group_contact_content_id";
    public static final String RECIPIENT_EMAIL_COL = "recipient_email";
    public static final String RECIPIENT_ACTION_COL = "recipient_action";
    public static final String GROUP_CONTACT_ID_COL = "group_contact_id";
    public static final String GROUP_CONTACT_CONTENT_STATUS_COL = "group_contact_content_status";
    /*
    Query staments
     */
    public static final String UP_GET_GCC_BY_GC_ID_AND_STATUS = "CALL up_DRSGetGccByGcIdAndStatus(?,?)";

    public static final String UP_GET_GCC_BY_ID = "CALL up_DRSGetGccByIdAndStatus(?,?)";

    public static final String UP_GET_GCC_BY_ID_WITH_ALL_STATUS = "CALL up_DRSGetGccByIdWithAllStatus(?)";

    public static final String UP_CHECK_IS_OWNER_GCC = "CALL up_DRSIsGccOwner(?,?,?,?)";

    public static final String UP_CHECK_IS_OWNER_GCC_ALL_STATUS = "CALL up_DRSIsGccOwnerWithAllStatus(?,?)";

    public static final String UP_CREATE_GCC = "{CALL up_DSRCreateGroupContactContent(?,?,?,?)}";

    public static final String UP_UPDATE_GCC_BY_ATTRIBUTE = "{call up_DSRUpdateTable(?,?,?,?,?,?,?)}";
}
