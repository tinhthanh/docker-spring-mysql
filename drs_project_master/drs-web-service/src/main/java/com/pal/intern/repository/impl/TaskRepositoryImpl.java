package com.pal.intern.repository.impl;

import com.pal.intern.domain.Task;
import com.pal.intern.mapper.TaskQueryStaments;
import com.pal.intern.repository.TaskRepository;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class TaskRepositoryImpl implements TaskRepository {
    
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getName());
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public int saveTask(String taskName, String description, Date targetDate, int taskStatus, String remark, int taskDateDefined, int reportId) {
        String sql = TaskQueryStaments.UP_CREATE_TASK;
        List<SqlParameter> paramList = new ArrayList<>();
        paramList.add(new SqlParameter(Types.VARCHAR));
        paramList.add(new SqlParameter(Types.VARCHAR));
        paramList.add(new SqlParameter(Types.DATE));
        paramList.add(new SqlParameter(Types.INTEGER));
        paramList.add(new SqlParameter(Types.VARCHAR));
        paramList.add(new SqlParameter(Types.INTEGER));
        paramList.add(new SqlParameter(Types.INTEGER));
        paramList.add(new SqlInOutParameter("taskId", Types.INTEGER));
        int taskId = -1;
        try {
            Map<String, Object> resultMap = this.jdbcTemplate.call((Connection con) -> {
                CallableStatement callableStatement = con.prepareCall(sql);
                callableStatement.setString(1, taskName);
                callableStatement.setString(2, description);
                callableStatement.setDate(3, targetDate);
                callableStatement.setInt(4, taskStatus);
                callableStatement.setString(5, remark);
                callableStatement.setInt(6, reportId);
                callableStatement.setInt(7, taskDateDefined);
                callableStatement.registerOutParameter(8, Types.INTEGER);
                return callableStatement;
            }, paramList);
            taskId = Integer.valueOf(resultMap.get("taskId").toString());
        } catch (NumberFormatException | DataAccessException e) {
            LOGGER.error("Error when call method saveTask() with param " + Arrays.asList(taskName, description, targetDate, taskStatus, remark, taskDateDefined, reportId), e);
        }
        return taskId;
    }
    
    @Override
    public List<Task> getListTaskByReportId(int reportId) {
        List<Task> result = Collections.emptyList();
        
        try {
            result = this.jdbcTemplate.query(TaskQueryStaments.UP_GET_LIST_TASK_BY_REPORT_ID, new Object[]{reportId}, (ResultSet rs, int rowNum) -> {
                Task task = new Task();
                
                task.setTaskId(rs.getInt(TaskQueryStaments.TASK_ID_COL));
                task.setTaskName(rs.getString(TaskQueryStaments.TASK_NAME_COL));
                task.setDescription(rs.getString(TaskQueryStaments.TASK_DESCRIPTION_COL));
                if (rs.getTimestamp(TaskQueryStaments.TASK_TARGET_DATE_COL) != null) {
//                    task.setTarget_date(rs.getTimestamp(TaskQueryStaments.TASK_TARGET_DATE_COL).toLocalDateTime().toLocalDate());
                    task.setTargetDate(rs.getDate(TaskQueryStaments.TASK_TARGET_DATE_COL));
                }
                task.setStatus(rs.getInt(TaskQueryStaments.TASK_STATUS_COL));
                task.setRemark(rs.getString(TaskQueryStaments.TASK_REMARK_COL));
                task.setTaskDateDefined(rs.getInt(TaskQueryStaments.TASK_DATE_DEFINED));
                return task;
            });
            
        } catch (DataAccessException e) {
            LOGGER.error("Error when call method getListTaskByReportId() with param " + reportId, e);
        }
        
        return result;
        
    }
    
    @Override
    @Transactional
    public int updateTaskWithAttribute(String columnName, Object value, int taskId) {
        String sql = TaskQueryStaments.UP_UPDATE_TASK_BY_ATRIBUTE;
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
                callableStatement.setString(1, TaskQueryStaments.TASK_TABLE_NAME);
                callableStatement.setString(2, columnName);
                callableStatement.setString(3, value.toString());
                callableStatement.setString(4, TaskQueryStaments.TASK_ID_COL);
                callableStatement.setInt(5, taskId);
                callableStatement.registerOutParameter(6, Types.INTEGER);
                callableStatement.registerOutParameter(7, Types.VARCHAR);
                return callableStatement;
                
            }, parameters);
            numRowsEffected = Integer.valueOf(resultMap.get("numRowsEffected").toString());
            LOGGER.info(resultMap.get("query").toString());
        } catch (DataAccessException e) {
            LOGGER.error("Error when call method updateTaskWithAttribute() with param " + Arrays.asList(columnName, value, taskId), e);
        }
        return numRowsEffected;
        
    }
    
    @Override
    public boolean isTaskOwner(int taskId, int userId) {
        boolean isTaskOwner = false;
        String sql = TaskQueryStaments.UP_IS_TASK_OWNER;
        try {
            Integer resultQuery = this.jdbcTemplate.queryForObject(sql, new Object[]{taskId, userId}, Integer.class);
            isTaskOwner = (resultQuery != null && resultQuery > 0);
        } catch (DataAccessException e) {
            LOGGER.error("Error when call method isTaskOwner() with param " + Arrays.asList(taskId, userId), e);
        }
        return isTaskOwner;
    }
    
    @Override
    public Map<String, Object> getTaskWithTaskId(int taskId) {
        Map<String, Object> result = Collections.emptyMap();
        String sql = TaskQueryStaments.UP_GET_TASK_BY_ID;
        try {
            result = this.jdbcTemplate.queryForMap(sql, taskId);
            
        } catch (DataAccessException e) {
            LOGGER.error("Error when call method getTaskWithTaskId() with param " + taskId, e);
        }
        return result;
    }
    
    @Override
    public Map<String, Object> getTaskWithTaskIdAndDeleteStatus(int taskId, int deleteStatus) {
        Map<String, Object> result = Collections.emptyMap();
        String sql = TaskQueryStaments.UP_GET_TASK_BY_ID_AND_STATUS;
        try {
            result = this.jdbcTemplate.queryForMap(sql, taskId, deleteStatus);
        } catch (DataAccessException e) {
            LOGGER.error("Error when call method getTaskWithTaskIdAndDeleteStatus() with param " + Arrays.asList(taskId, deleteStatus), e);
        }
        return result;
        
    }
    
    @Override
    @Transactional
    public int updateTask(String taskName, String description, Date targetDate, int status, String remark, int taskId) {
        int numberEffected = 0;
        String sql = TaskQueryStaments.UP_UPDATE_TASK;
        try {
            numberEffected = jdbcTemplate.update(sql, taskName, description, targetDate, status, remark, taskId);
        } catch (DataAccessException e) {
            LOGGER.error("Error  when call method  updateTask with param " + Arrays.asList(taskName, description, targetDate, status, remark, taskId), e);
        }
        return numberEffected;
    }
    
}
