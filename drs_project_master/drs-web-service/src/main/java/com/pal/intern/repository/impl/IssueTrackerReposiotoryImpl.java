package com.pal.intern.repository.impl;

import com.pal.intern.domain.IssueStatusTrackers;
import com.pal.intern.mapper.IssueTrackerQueryStament;
import com.pal.intern.repository.IssueTrackerRepository;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.sql.Types;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Repository;

@Repository
public class IssueTrackerReposiotoryImpl implements IssueTrackerRepository {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getName());
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insertIssueTrackerId(String userName, int issueId, Date updateTime) {
        int newIssueTrackerId = -1;
        String sql = IssueTrackerQueryStament.UP_CREATE_ISSUE_TRACKER;
        List<SqlParameter> parameters = new ArrayList<>();
        parameters.add(new SqlParameter(Types.VARCHAR));
        parameters.add(new SqlParameter(Types.INTEGER));
        parameters.add(new SqlParameter(Types.DATE));
        parameters.add(new SqlOutParameter("newIssueTrackerId", Types.INTEGER));
        try {
            Map<String, Object> resultMap = this.jdbcTemplate.call((Connection con) -> {
                CallableStatement callableStatement = con.prepareCall(sql);
                callableStatement.setString(1, userName);
                callableStatement.setInt(2, issueId);
                callableStatement.setString(3, new Timestamp(updateTime.getTime()).toString());
                callableStatement.registerOutParameter(4, Types.INTEGER);
                return callableStatement;
            }, parameters);

            newIssueTrackerId = Integer.valueOf(resultMap.get("newIssueTrackerId").toString());
        } catch (DataAccessException e) {
            LOGGER.error("Error when call method insertIssueTrackerId() with param " + Arrays.asList(userName, issueId, updateTime), e);
        }

        return newIssueTrackerId;
    }

    @Override
    public Map<String, Object> getIssueStatusTrackerWithPaging(String userName, LocalDate timeUpdate, int page, int pageSize) {
        String sql = IssueTrackerQueryStament.UP_GET_ISSUE_TRACKER;

        Map<String, Object> result = new HashMap<>();
        List<SqlParameter> parameters = new ArrayList<>();
        parameters.add(new SqlParameter(Types.VARCHAR));
        parameters.add(new SqlParameter(Types.TIMESTAMP));
        parameters.add(new SqlParameter(Types.INTEGER));
        parameters.add(new SqlParameter(Types.INTEGER));
        parameters.add(new SqlOutParameter("totalRecords", Types.INTEGER));
        try {
            Map<String, Object> resultMap = this.jdbcTemplate.call((Connection con) -> {
                CallableStatement callableStatement = con.prepareCall(sql);
                callableStatement.setString(1, userName);
                callableStatement.setDate(2, java.sql.Date.valueOf(timeUpdate));
                callableStatement.setInt(3, page);
                callableStatement.setInt(4, pageSize);
                callableStatement.registerOutParameter(5, Types.INTEGER);
                return callableStatement;
            }, parameters);
            result.put("totalRecords", resultMap.get("totalRecords"));
            result.put("listOfResults", resultMap.get("#result-set-1"));

        } catch (DataAccessException e) {
            LOGGER.error("Error when call method getIssueStatusTrackerWithPaging() with param " + Arrays.asList(userName, timeUpdate, page, pageSize), e);
        }
        return result;

    }

    @Override
    public List<IssueStatusTrackers> getAllIssueStatusTrackerByUserNameAndTimeUpdate(String userName, LocalDate timeUpdate) {
        List<IssueStatusTrackers> result = Collections.emptyList();
        String sql = IssueTrackerQueryStament.UP_GET_ALL_ISSUE_TRACKER;
        try {
            result = this.jdbcTemplate.query(sql, new Object[]{userName, java.sql.Date.valueOf(timeUpdate).toString()}, (ResultSet rs, int i) -> {
                IssueStatusTrackers issueStatusTrackers = new IssueStatusTrackers();
                issueStatusTrackers.setIssueTrackerId(rs.getInt("issueTrackerId"));
                issueStatusTrackers.setIssueId(rs.getInt("issueId"));
                issueStatusTrackers.setUserName(rs.getString("userName"));
                issueStatusTrackers.setUpdateTime(rs.getDate("updateTime"));
                return issueStatusTrackers;
            });

        } catch (DataAccessException e) {
            LOGGER.error(e.getMessage());
        }
        return result;
    }

}
