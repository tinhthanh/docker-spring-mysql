package com.pal.intern.repository.impl;

import com.pal.intern.domain.CustomTask;
import com.pal.intern.mapper.CustomTaskQueryStatements;
import com.pal.intern.repository.CustomTaskRepository;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Repository;

@Repository
public class CustomTaskRepositoryImpl implements CustomTaskRepository {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getName());
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Map<String, Object> getCustomTaskWithPaging(int userID, int page, int pageSize) {
        Map<String, Object> result = new HashMap<>();
        String sql = CustomTaskQueryStatements.UP_GET_CUSTOM_TASK_BY_USERID_WITH_PAGING;
        List<SqlParameter> parameters = new ArrayList<>();
        parameters.add(new SqlParameter(Types.INTEGER));
        parameters.add(new SqlParameter(Types.INTEGER));
        parameters.add(new SqlParameter(Types.INTEGER));
        parameters.add(new SqlOutParameter("totalRecords", Types.INTEGER));
        try {

            Map<String, Object> resultMap = this.jdbcTemplate.call((Connection con) -> {
                CallableStatement callableStatement = con.prepareCall(sql);
                callableStatement.setInt(1, userID);
                callableStatement.setInt(2, page);
                callableStatement.setInt(3, pageSize);
                callableStatement.registerOutParameter(4, Types.INTEGER);
                return callableStatement;
            }, parameters);

            result.put("totalRecords", resultMap.get("totalRecords"));
            result.put("listOfReports", resultMap.get("#result-set-1"));

        } catch (DataAccessException e) {
            LOGGER.error("Error when call method getCustomTaskWithPaging() with param " + Arrays.asList(userID, page, pageSize), e);
        }
        return result;
    }

    @Override
    public int createCustomTask(CustomTask model) {
        try {
            return jdbcTemplate.queryForObject(CustomTaskQueryStatements.UP_CREATE_CUSTOM_TASK, new Object[]{model.getName(), model.getDescription(), model.getTargetDate(), model.getTaskStatus(), model.getRemark(), model.getUserID()}, Integer.class);
        } catch (DataAccessException e) {
            LOGGER.error("Error when call method createCustomTask() with param " + Arrays.asList(model), e);
        }
        return -1;
    }

    @Override
    public Optional<CustomTask> getCustomTaskByID(int id) {
        Optional<CustomTask> result = Optional.empty();
        try {
            CustomTask QueryResult = jdbcTemplate.queryForObject(CustomTaskQueryStatements.QUERY_GET_CUSTOM_TASK_BY_ID, new Object[]{id}, (r, i) -> {
                return new CustomTask(r.getInt("custom_task_id"), r.getString("task_name"), r.getString("description"), r.getDate("target_date"), r.getInt("task_status"), r.getString("remark"));
            });
            result = Optional.ofNullable(QueryResult);
        } catch (DataAccessException e) {
            LOGGER.error("Error when call method getCustomTaskByID() with param " + id, e);
        }
        return result;
    }

    @Override
    public boolean isCustomTaskOwner(int customTaskID, int userID) {
        boolean isOwner = false;
        try {
            Integer queryResult = jdbcTemplate.queryForObject(CustomTaskQueryStatements.QUERY_CHECK_CUSTOM_TASK_OWNER, new Object[]{userID, customTaskID}, Integer.class);
            isOwner = (queryResult != null) && queryResult > 0;
        } catch (DataAccessException e) {
            LOGGER.error("Error when call method isCustomTaskOwner() with param " + Arrays.asList(customTaskID, userID), e);
        }
        return isOwner;
    }

    @Override
    public boolean deleteCustomTask(int customTaskID) {
        try {
            jdbcTemplate.update(CustomTaskQueryStatements.UP_DELETE_CUSTOM_TASK, customTaskID);
            return true;
        } catch (DataAccessException e) {
            LOGGER.error("Error when call method deleteCustomTask() with param " + customTaskID, e);
            return false;
        }
    }

    @Override
    public boolean isDeleted(int customTaskID) {
        boolean isDeleted = false;
        try {
            Integer queryResult = jdbcTemplate.queryForObject(CustomTaskQueryStatements.QUERY_CHECK_CUSTOM_TASK_DELETED, new Object[]{customTaskID}, Integer.class);
            isDeleted = (queryResult != null) && queryResult > 0;
        } catch (DataAccessException e) {
            LOGGER.error("Error when call method isDeleted() with param " + customTaskID, e);
        }
        return isDeleted;
    }

    @Override
    public Optional<CustomTask> updateCustomTaskAllField(CustomTask model) {
        Optional<CustomTask> result = Optional.empty();
        try {
            CustomTask customTask = jdbcTemplate.queryForObject(CustomTaskQueryStatements.UP_UPDATE_CUSTOM_TASK, new Object[]{model.getId(), model.getName(), model.getDescription(), model.getTargetDate(), model.getTaskStatus(), model.getRemark()}, (rs, i) -> {
                return new CustomTask(rs.getInt("custom_task_id"), rs.getString("task_name"), rs.getString("description"), rs.getDate("target_date"), rs.getInt("task_status"), rs.getString("remark"));
            });
            result = Optional.ofNullable(customTask);
        } catch (DataAccessException e) {
            LOGGER.error("Error when call method updateCustomTaskAllField() with param " + Arrays.asList(model), e);
        }
        return result;
    }

    @Override
    public int updateCustomTaskOneField(String key, Object value, int customTaskID) {
        String sql = CustomTaskQueryStatements.UP_UPDATE_CUSTOM_TASK_BY_ATTRIBUTE;
        int numRowsEffected = -1;
        List<SqlParameter> parameters = new ArrayList<>();
        parameters.add(new SqlParameter(Types.VARCHAR));
        parameters.add(new SqlParameter(Types.VARCHAR));
        parameters.add(new SqlParameter(Types.VARCHAR));
        parameters.add(new SqlParameter(Types.VARCHAR));
        parameters.add(new SqlParameter(Types.INTEGER));
        parameters.add(new SqlOutParameter("numRowsEffected", Types.INTEGER));
        parameters.add(new SqlOutParameter("query", Types.VARCHAR));
        try {
            Map<String, Object> resultMap = this.jdbcTemplate.call((Connection con) -> {
                CallableStatement callableStatement = con.prepareCall(sql);
                callableStatement.setString(1, CustomTaskQueryStatements.CUSTOM_TASK_TABLE_NAME);
                callableStatement.setString(2, key);
                callableStatement.setString(3, value.toString());
                callableStatement.setString(4, CustomTaskQueryStatements.CUSTOM_TASK_ID_COL);
                callableStatement.setInt(5, customTaskID);
                callableStatement.registerOutParameter(6, Types.INTEGER);
                callableStatement.registerOutParameter(7, Types.VARCHAR);
                return callableStatement;

            }, parameters);
            numRowsEffected = Integer.valueOf(resultMap.get("numRowsEffected").toString());
            LOGGER.info(resultMap.get("query").toString());
        } catch (DataAccessException e) {
            LOGGER.error("Error when call method updateCustomTaskOneField() with param " + Arrays.asList(key, value, customTaskID), e);
        }
        return numRowsEffected;
    }

}
