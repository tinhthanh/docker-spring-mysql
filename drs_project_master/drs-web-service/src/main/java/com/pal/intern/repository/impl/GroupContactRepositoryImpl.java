package com.pal.intern.repository.impl;

import com.pal.intern.domain.GroupContact;
import com.pal.intern.domain.GroupContactContent;
import com.pal.intern.mapper.GroupContactQueryStaments;
import com.pal.intern.repository.GroupContactContentRepository;
import com.pal.intern.repository.GroupContactRepository;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
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
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Repository;

@Repository
public class GroupContactRepositoryImpl implements GroupContactRepository {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getName());
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private GroupContactContentRepository groupContactContentRepository;

    @Override
    public boolean isGroupContactOwner(int groupContactId, int userId) {
        boolean isGroupContactOwner = false;
        String sql = GroupContactQueryStaments.UP_IS_GROUP_CONTACT_OWNER;
        try {
            Integer resultFromQuery = this.jdbcTemplate.queryForObject(sql, new Object[]{groupContactId, userId}, Integer.class);
            if (resultFromQuery != null && resultFromQuery > 0) {
                isGroupContactOwner = true;
            }
        } catch (DataAccessException e) {
            LOGGER.error("Error when call method isGroupContactOwner() with param " + Arrays.asList(groupContactId, userId), e);
        }
        return isGroupContactOwner;

    }

    @Override
    public Optional<GroupContact> getGroupContactByIdAndStatus(int groupContactId, int groupContactStatus) {
        Optional<GroupContact> result = Optional.empty();
        String sql = GroupContactQueryStaments.UP_GET_GC_BY_ID_AND_STATUS;
        try {
            RowMapper<GroupContact> rowMapper = (ResultSet rs, int rowNum) -> {
                GroupContact groupContact = new GroupContact();
                int groupContactIdRs = rs.getInt(GroupContactQueryStaments.GROUP_CONTACT_ID_COL);

                if (groupContactIdRs > 0) {
                    List<GroupContactContent> groupContactContents = this.groupContactContentRepository.getGroupContactContentByGroupContactId(groupContactId, 1);
                    if (groupContactContents != null) {
                        groupContact.setContactContents(groupContactContents);
                    }
                }
                groupContact.setGroupContactId(groupContactId);
                groupContact.setGroupContactName(rs.getString(GroupContactQueryStaments.GROUP_CONTACT_NAME_COL));
                return groupContact;
            };
            GroupContact gc = this.jdbcTemplate.queryForObject(sql, new Object[]{groupContactId, groupContactStatus}, rowMapper);
            result = Optional.ofNullable(gc);
        } catch (DataAccessException e) {
            LOGGER.error("Error when call method getGroupContactByIdAndStatus() with param " + Arrays.asList(groupContactId, groupContactStatus), e);
        }
        return result;
    }

    @Override
    public int createGroupContact(String groupContactName, int userId) {
        int newGroupContactId = -1;
        String sql = GroupContactQueryStaments.UP_CREATE_GC;
        List<SqlParameter> parameters = new ArrayList<>();
        parameters.add(new SqlParameter(Types.VARCHAR));
        parameters.add(new SqlParameter(Types.INTEGER));
        parameters.add(new SqlOutParameter("newGroupContactId", Types.INTEGER));
        try {
            Map<String, Object> resultMap = this.jdbcTemplate.call((Connection con) -> {
                CallableStatement callableStatement = con.prepareCall(sql);
                callableStatement.setString(1, groupContactName);
                callableStatement.setInt(2, userId);
                callableStatement.registerOutParameter(3, Types.INTEGER);
                return callableStatement;
            }, parameters);

            newGroupContactId = Integer.valueOf(resultMap.get("newGroupContactId").toString());
        } catch (DataAccessException e) {
            LOGGER.error("Error when call method createGroupContact() with param " + Arrays.asList(groupContactName, userId), e);
        }
        return newGroupContactId;
    }

    @Override
    public int updateGroupContactContentByAttribute(String columnName, Object value, int groupContactId) {
        String sql = GroupContactQueryStaments.UP_UPDATE_GC_BY_ATTRIBUTE;
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
                callableStatement.setString(1, GroupContactQueryStaments.GROUP_CONTACT_TABLE_NAME);
                callableStatement.setString(2, columnName);
                callableStatement.setString(3, value.toString());
                callableStatement.setString(4, GroupContactQueryStaments.GROUP_CONTACT_ID_COL);
                callableStatement.setInt(5, groupContactId);
                callableStatement.registerOutParameter(6, Types.INTEGER);
                callableStatement.registerOutParameter(7, Types.VARCHAR);
                return callableStatement;

            }, parameters);
            numRowsEffected = Integer.valueOf(resultMap.get("numRowsEffected").toString());
            LOGGER.info(resultMap.get("query").toString());
        } catch (DataAccessException e) {
            LOGGER.error("Error when call method updateGroupContactContentByAttribute() with param " + Arrays.asList(columnName, value, groupContactId), e);
        }
        return numRowsEffected;
    }

    @Override
    public Map<String, Object> getAllGroupContactByUserIdWithPaging(int userId, int status, int page, int pageSize) {
        Map<String, Object> result = new HashMap<>();
        String sql = GroupContactQueryStaments.UP_GET_ALL_GC_BY_USER_ID_STATUS;
        List<SqlParameter> parameters = new ArrayList<>();
        parameters.add(new SqlParameter(Types.INTEGER));
        parameters.add(new SqlParameter(Types.INTEGER));
        parameters.add(new SqlParameter(Types.INTEGER));
        parameters.add(new SqlParameter(Types.INTEGER));
        parameters.add(new SqlOutParameter("totalRecords", Types.INTEGER));
        try {
            Map<String, Object> resultMap = this.jdbcTemplate.call((Connection con) -> {

                CallableStatement callableStatement = con.prepareCall(sql);
                callableStatement.setInt(1, page);
                callableStatement.setInt(2, pageSize);
                callableStatement.setInt(3, userId);
                callableStatement.setInt(4, status);
                callableStatement.registerOutParameter(5, Types.INTEGER);
                return callableStatement;
            }, parameters);

            result.put("totalRecords", resultMap.get("totalRecords"));
            result.put("listOfReports", resultMap.get("#result-set-1"));

        } catch (DataAccessException e) {
            LOGGER.error("Error when call method getAllGroupContactByUserIdWithPaging() with param " + Arrays.asList(userId, status, page, pageSize), e);
        }
        return result;
    }

    @Override
    public Map<String, Object> getAllGroupContactByUserIdAndStatusWithPaging(int userId, int status, int page, int pageSize) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
