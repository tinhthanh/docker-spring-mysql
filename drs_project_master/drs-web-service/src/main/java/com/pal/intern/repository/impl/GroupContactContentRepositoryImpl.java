package com.pal.intern.repository.impl;

import com.pal.intern.domain.GroupContactContent;
import com.pal.intern.mapper.GroupContactContentQueryStaments;
import com.pal.intern.repository.GroupContactContentRepository;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Repository;

@Repository
public class GroupContactContentRepositoryImpl implements GroupContactContentRepository {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getName());
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<GroupContactContent> getGroupContactContentByGroupContactId(int groupContactId, int status) {
        String sql = GroupContactContentQueryStaments.UP_GET_GCC_BY_GC_ID_AND_STATUS;
        List<GroupContactContent> result = Collections.emptyList();
        try {
            RowMapper<GroupContactContent> rowMapper = (ResultSet rs, int rowNum) -> {
                GroupContactContent gcc = new GroupContactContent();
                gcc.setId(rs.getInt(GroupContactContentQueryStaments.GROUP_CONTACT_CONTENT_ID_COL));
                gcc.setContactEmail(rs.getString(GroupContactContentQueryStaments.RECIPIENT_EMAIL_COL));
                gcc.setContactAction(rs.getInt(GroupContactContentQueryStaments.RECIPIENT_ACTION_COL));
                gcc.setContactContentStatus(rs.getInt(GroupContactContentQueryStaments.GROUP_CONTACT_CONTENT_STATUS_COL));
                return gcc;
            };
            result = this.jdbcTemplate.query(sql, new Object[]{groupContactId, status}, rowMapper);

        } catch (DataAccessException e) {
            LOGGER.error("Error when call method getGroupContactContentByGroupContactId() with param " + Arrays.asList(groupContactId,status), e);
        }
        return result;
    }

    @Override
    public int createGroupContactContent(String contactEmail, int contactAction, int groupContactId) {
        int newGroupContactContent = -1;
        String sql = GroupContactContentQueryStaments.UP_CREATE_GCC;
        List<SqlParameter> parameters = new ArrayList<>();
        parameters.add(new SqlParameter(Types.VARCHAR));
        parameters.add(new SqlParameter(Types.INTEGER));
        parameters.add(new SqlParameter(Types.INTEGER));
        parameters.add(new SqlOutParameter("newGroupContactContent", Types.INTEGER));
        try {
            Map<String, Object> resultMap = this.jdbcTemplate.call((Connection con) -> {
                CallableStatement callableStatement = con.prepareCall(sql);
                callableStatement.setString(1, contactEmail);
                callableStatement.setInt(2, contactAction);
                callableStatement.setInt(3, groupContactId);
                callableStatement.registerOutParameter(4, Types.INTEGER);
                return callableStatement;
            }, parameters);

            newGroupContactContent = Integer.valueOf(resultMap.get("newGroupContactContent").toString());
        } catch (DataAccessException e) {
           LOGGER.error("Error when call method createGroupContactContent() with param " + Arrays.asList(contactEmail,contactAction, groupContactId), e);
        }

        return newGroupContactContent;
    }

    @Override
    public Optional<GroupContactContent> getGroupContactContentById(int groupContactContentId, int status) {
        String sql = GroupContactContentQueryStaments.UP_GET_GCC_BY_ID;
        Optional<GroupContactContent> result = Optional.empty();
        try {
            RowMapper<GroupContactContent> rowMapper = (ResultSet rs, int rowNum) -> {
                GroupContactContent gcc = new GroupContactContent();
                gcc.setId(rs.getInt(GroupContactContentQueryStaments.GROUP_CONTACT_CONTENT_ID_COL));
                gcc.setContactEmail(rs.getString(GroupContactContentQueryStaments.RECIPIENT_EMAIL_COL));
                gcc.setContactAction(rs.getInt(GroupContactContentQueryStaments.RECIPIENT_ACTION_COL));
                gcc.setContactContentStatus(rs.getInt(GroupContactContentQueryStaments.GROUP_CONTACT_CONTENT_STATUS_COL));
                return gcc;
            };
            GroupContactContent groupContactContent = this.jdbcTemplate.queryForObject(sql, new Object[]{groupContactContentId, status}, rowMapper);
            result = Optional.ofNullable(groupContactContent);
        } catch (DataAccessException e) {
            LOGGER.error("Error when call method getGroupContactContentById() with param " + Arrays.asList(groupContactContentId,status), e);
        }
        return result;
    }

    @Override
    public int updateGroupContactContent(String contactEmail, int contactAction) {

        return 0;
    }

    @Override
    public int updateGroupContactContentByAttribute(String columnName, Object value, int groupContactId) {
        String sql = GroupContactContentQueryStaments.UP_UPDATE_GCC_BY_ATTRIBUTE;
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
                callableStatement.setString(1, GroupContactContentQueryStaments.GROUP_CONTACT_CONTENT_TABLE_NAME);
                callableStatement.setString(2, columnName);
                callableStatement.setString(3, value.toString());
                callableStatement.setString(4, GroupContactContentQueryStaments.GROUP_CONTACT_CONTENT_ID_COL);
                callableStatement.setInt(5, groupContactId);
                callableStatement.registerOutParameter(6, Types.INTEGER);
                callableStatement.registerOutParameter(7, Types.VARCHAR);
                return callableStatement;

            }, parameters);
            numRowsEffected = Integer.valueOf(resultMap.get("numRowsEffected").toString());
            LOGGER.info(resultMap.get("query").toString());
        } catch (DataAccessException e) {
            LOGGER.error("Error when call method updateGroupContactContentByAttribute() with param " + Arrays.asList(columnName,value, groupContactId), e);
        }
        return numRowsEffected;
    }

    @Override
    public Optional<GroupContactContent> getGroupContactContentByIdWithAllStatus(int groupContactContentId) {
        String sql = GroupContactContentQueryStaments.UP_GET_GCC_BY_ID_WITH_ALL_STATUS;
        Optional<GroupContactContent> result = Optional.empty();
        try {
            RowMapper<GroupContactContent> rowMapper = (ResultSet rs, int rowNum) -> {
                GroupContactContent gcc = new GroupContactContent();
                gcc.setId(rs.getInt(GroupContactContentQueryStaments.GROUP_CONTACT_CONTENT_ID_COL));
                gcc.setContactEmail(rs.getString(GroupContactContentQueryStaments.RECIPIENT_EMAIL_COL));
                gcc.setContactAction(rs.getInt(GroupContactContentQueryStaments.RECIPIENT_ACTION_COL));
                gcc.setContactContentStatus(rs.getInt(GroupContactContentQueryStaments.GROUP_CONTACT_CONTENT_STATUS_COL));
                return gcc;
            };
            GroupContactContent groupContactContent = this.jdbcTemplate.queryForObject(sql, new Object[]{groupContactContentId}, rowMapper);
            result = Optional.ofNullable(groupContactContent);
        } catch (DataAccessException e) {
            LOGGER.error("Error when call method getGroupContactContentByIdWithAllStatus() with param " + groupContactContentId, e);
        }
        return result;
    }

    @Override
    public boolean isGroupContactContentOwner(int groupContactContentId, int userId, int groupContactStatus, int contactContentStatus) {
        boolean isGroupContactContentOwner = false;
        String sql = GroupContactContentQueryStaments.UP_CHECK_IS_OWNER_GCC;
        try {
            Integer result = this.jdbcTemplate.queryForObject(sql, new Object[]{groupContactContentId, userId, groupContactStatus, contactContentStatus}, Integer.class);
            isGroupContactContentOwner = (result != null) && result > 0;
        } catch (DataAccessException e) {
            LOGGER.error("Error when call method isGroupContactContentOwner() with param " + Arrays.asList(groupContactContentId,userId, groupContactStatus,contactContentStatus), e);
        }
        return isGroupContactContentOwner;
    }

    @Override
    public boolean isGroupContactContentOwner(int groupContactContentId, int userId) {
        boolean isGroupContactContentOwner = false;
        String sql = GroupContactContentQueryStaments.UP_CHECK_IS_OWNER_GCC_ALL_STATUS;
        try {
            Integer result = this.jdbcTemplate.queryForObject(sql, new Object[]{groupContactContentId, userId}, Integer.class);
            isGroupContactContentOwner = (result != null) && result > 0;
        } catch (DataAccessException e) {
             LOGGER.error("Error when call method isGroupContactContentOwner() with param " + Arrays.asList(groupContactContentId,userId), e);
        }
        return isGroupContactContentOwner;
    }

}
