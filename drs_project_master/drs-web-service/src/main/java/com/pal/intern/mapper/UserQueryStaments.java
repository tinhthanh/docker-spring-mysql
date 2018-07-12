package com.pal.intern.mapper;

public class UserQueryStaments {

    /*
    column name
     */
    public static final String USER_ID_COL = "user_id";
    public static final String USER_NAME_COL = "user_name";
    public static final String EMAIL_COL = "email";
    public static final String USER_PASSWORD_COL = "password";
    public static final String USER_FULL_NAME_COL = "full_name";
    public static final String USER_STATUS_COL = "status";
    public static final String LAST_PASSWORD_CHANGE_COL = "last_password_change";

    /*
    Query staments
     */
    public static final String UP_GET_USER_BY_USER_NAME = "CALL up_DRSGetUserByUserName(?)";
    public static final String UP_GET_USER_BY_USER_ID = "CALL up_DRSGetUserById(?)";
    public static final String UP_GET_USER_INFO = "CALL up_DRSGetUserInfo(?)";
    
    public static final String UP_GET_USER_BY_EMAIL ="CALL up_DRSGetUserByEmail(?)";
    

}
