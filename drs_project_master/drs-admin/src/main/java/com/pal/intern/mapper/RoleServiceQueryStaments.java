package com.pal.intern.mapper;

public class RoleServiceQueryStaments {

    public static final String ROLE_ID_COL = "role_id";
    public static final String ROLE_NAME_COL = "role_name";
    /*
    Query staments
     */
    public static final String QUERY_ADD_ROLE_USER = "INSERT INTO drs_permission ( user_id , role_id ) value ( ? ,  ? )";
    public static final String QUERY_DELETE_ROLE_USER = "DELETE FROM drs_permission  where user_id = ? and role_id = ? ;";
}
