package com.pal.intern.mapper;

public class UserServiceQueryStaments {

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
    public static final String QUERY_ADD_USER = "INSERT INTO drs_user( user_name , email , password , full_name , status , last_password_change ) VALUE (  ?,  ? , ? , ? , 1 , now() )";
    public static final String QUERY_UPDATE_USER = "UPDATE drs_user set email = ? , full_name = ? where user_id = ? ;";
    public static final String QUERY_DELETE_USER = "UPDATE drs_user SET status = 2 WHERE user_id =  ? ";
    public static final String QUERY_FIND_USER_BY_ID = "SELECT user_id , user_name, email, password , full_name , status , last_password_change FROM drs_user where user_id = ? ";
    public static final String QUERY_FIND_ALL = "SELECT user_id , user_name, email, password , full_name , status , last_password_change FROM drs_user ";
    public static final String QUERY_GET_USER_AND_ROLE = "select t2.user_id , t2.user_name, t2.email, t2.password , t2.full_name , t2.status , t2.last_password_change , t2.role_id , t2.role_name from (select user_id from drs_user order by user_id LIMIT ? OFFSET ?) t1 \n"
            + " left join ( \n"
            + " SELECT  u.user_id , u.user_name, u.email, u.password , u.full_name , u.status , u.last_password_change , r.role_id , r.role_name\n"
            + "			FROM drs_user u left join drs_permission p  on u.user_id = p.user_id\n"
            + "            left join drs_role r on p.role_id = r.role_id) t2 \n"
            + " on t1.user_id = t2.user_id;";
    public static final String QUERY_GET_TOTAL_USER = "select count(*) from drs_user where status  = 1 ;";

}
