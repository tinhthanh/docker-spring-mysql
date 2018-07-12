package com.pal.intern.repository.impl;

import com.pal.intern.domain.Report;
import com.pal.intern.mapper.ReportMapper;
import com.pal.intern.mapper.ReportQueryStaments;
import com.pal.intern.repository.ReportRepository;
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
import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Repository;

@Repository
public class ReportRepositoryImpl implements ReportRepository {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getName());
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int createReport(String reportSubject, int reportType, String reportDataEtc, int userId) {
        String sql = ReportQueryStaments.UP_CREATE_REPORT;
        List<SqlParameter> paramList = new ArrayList<>();
        paramList.add(new SqlParameter(Types.VARCHAR));
        paramList.add(new SqlParameter(Types.INTEGER));
        paramList.add(new SqlParameter(Types.VARCHAR));
        paramList.add(new SqlParameter(Types.INTEGER));
        paramList.add(new SqlInOutParameter("reportId", Types.INTEGER));
        int reportId = -1;
        try {
            Map<String, Object> resultMap = this.jdbcTemplate.call((Connection con) -> {
                CallableStatement callableStatement = con.prepareCall(sql);
                callableStatement.setString(1, reportSubject);
                callableStatement.setInt(2, reportType);
                callableStatement.setString(3, reportDataEtc);
                callableStatement.setInt(4, userId);
                callableStatement.registerOutParameter(5, Types.INTEGER);
                return callableStatement;
            }, paramList);
            reportId = Integer.valueOf(resultMap.get("reportId").toString());
        } catch (DataAccessException e) {
            LOGGER.error("Error when call method createReport() with param " + Arrays.asList(reportSubject, reportType, reportDataEtc, userId), e);
        }
        return reportId;
    }

    @Override
    public Optional<Report> getReportById(int reportId) {
        Optional<Report> result = Optional.empty();
        String sql = ReportQueryStaments.UP_GET_REPORT_BY_ID;
        Object[] params = {reportId};
        try {
            Report report = this.jdbcTemplate.queryForObject(sql, params, new ReportMapper());
            result = Optional.ofNullable(report);
        } catch (DataAccessException e) {
            LOGGER.error("Error when call method getReportById() with param " + reportId, e);
        }
        return result;
    }

    @Override
    public Map<String, Object> getReportByUserIdAndStatusWithPaging(int userId, int reportType, int page, int pageSize) {
        Map<String, Object> result = new HashMap<>();
        String sql = ReportQueryStaments.UP_REPORT_BY_USER_ID_AND_REPORT_TYPE_PAGING;
        List<SqlParameter> parameters = new ArrayList<>();
        parameters.add(new SqlParameter(Types.INTEGER));
        parameters.add(new SqlParameter(Types.INTEGER));
        parameters.add(new SqlParameter(Types.INTEGER));
        parameters.add(new SqlParameter(Types.INTEGER));
        parameters.add(new SqlOutParameter("totalRecords", Types.INTEGER));
        try {
            Map<String, Object> resultMap = this.jdbcTemplate.call((Connection con) -> {
                CallableStatement callableStatement = con.prepareCall(sql);
                callableStatement.setInt(1, userId);
                callableStatement.setInt(2, reportType);
                callableStatement.setInt(3, page);
                callableStatement.setInt(4, pageSize);
                callableStatement.registerOutParameter(5, Types.INTEGER);
                return callableStatement;
            }, parameters);

            result.put("totalRecords", resultMap.get("totalRecords"));
            result.put("listOfReports", resultMap.get("#result-set-1"));

        } catch (DataAccessException e) {
            LOGGER.error("Error when call method getReportByUserIdAndStatusWithPaging() with param " + Arrays.asList(userId, reportType, page, pageSize), e);
        }
        return result;
    }

    @Override
    public boolean isReportOwner(int reportId, int userId) {
        boolean isReportOwner = false;
        String sql = ReportQueryStaments.QUERY_CHECK_IS_REPORT_OWNER;
        try {
            Integer result = this.jdbcTemplate.queryForObject(sql, new Object[]{userId, reportId}, Integer.class);
            isReportOwner = (result != null) && result > 0;
        } catch (DataAccessException e) {
            LOGGER.error("Error when call method isReportOwner() with param " + Arrays.asList(reportId, userId), e);
        }
        return isReportOwner;
    }

    @Override
    public int updateReportByAttr(String key, Object value, int reportID) {
        String sql = ReportQueryStaments.UP_UPDATE_REPORT_BY_ATTRIBUTE;
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
                callableStatement.setString(1, ReportQueryStaments.REPORT_TABLE_NAME);
                callableStatement.setString(2, key);
                callableStatement.setString(3, value.toString());
                callableStatement.setString(4, ReportQueryStaments.REPORT_ID_COL);
                callableStatement.setInt(5, reportID);
                callableStatement.registerOutParameter(6, Types.INTEGER);
                callableStatement.registerOutParameter(7, Types.VARCHAR);
                return callableStatement;

            }, parameters);
            numRowsEffected = Integer.valueOf(resultMap.get("numRowsEffected").toString());
            LOGGER.info(resultMap.get("query").toString());
        } catch (DataAccessException e) {
            LOGGER.error("Error when call method updateReportByAttr() with param " + Arrays.asList(key, value, reportID), e);
        }
        return numRowsEffected;
    }

    @Override
    public int updateReportByReportId(Report report) {
        String sql = ReportQueryStaments.UP_UPDATE_REPORT_BY_REPORT_ID;
        Integer queryResult = -1;
        try {
            queryResult = jdbcTemplate.queryForObject(sql, new Object[]{
                report.getReportId(),
                report.getReportSubject(),
                report.getReportType(),
                report.getReportDataEtc()},
                    Integer.class);
            LOGGER.info(sql);
        } catch (DataAccessException e) {
            LOGGER.error("Error at method deleteReportByReportId() with param " + report.toString(), e.getMessage());
        }
        return queryResult;
    }

    @Override
    public int deleteReportByReportId(int reportId) {
        String sql = ReportQueryStaments.UP_DELETE_REPORT_BY_REPORT_ID;
        Integer queryResult = -1;
        try {
            queryResult = jdbcTemplate.queryForObject(sql, new Object[]{
                reportId
            }, Integer.class);
            LOGGER.info(sql);
        } catch (DataAccessException e) {
            LOGGER.error("Error at method deleteReportByReportId() with param " + reportId, e.getMessage());
        }
        return queryResult;
    }

}
