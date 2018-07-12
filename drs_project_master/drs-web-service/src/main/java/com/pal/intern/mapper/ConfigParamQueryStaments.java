package com.pal.intern.mapper;


public class ConfigParamQueryStaments {

    /*
    column name
     */
    public static final String CONFIG_KEY_COL = "config_key";
    public static final String CONFIG_VALUE_COL = "config_value";
    public static final String CONFIG_DESCRIPTION_COL = "config_description";
    public static final String LAST_TIME_EDIT_COL = "last_time_edit";

    /*
    Query staments
     */
    public static final String QUERY_GET_ALL_CONFIG_PARAM = "CALL up_DRSGetAllConfigParam()";
}
