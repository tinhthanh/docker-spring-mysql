package com.pal.intern.mapper;

public class RoleQueryStaments {

    public static final String ROLE_ID_COL = "role_id";
    public static final String ROLE_NAME_COL = "role_name";

    /*
    Query staments
     */
    public static final String QUERY_GET_LIST_ROLE_BY_USER_ID = "CALL up_DRSGetListRoleByUserID(?)";

}
