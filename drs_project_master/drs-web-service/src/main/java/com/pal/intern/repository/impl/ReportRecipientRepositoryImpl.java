package com.pal.intern.repository.impl;

import com.pal.intern.domain.ReportRecipient;
import com.pal.intern.mapper.ReportRecipientQueryStaments;
import com.pal.intern.repository.ReportRecipientRepository;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Repository;

@Repository
public class ReportRecipientRepositoryImpl implements ReportRecipientRepository {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int createReportRecipient(String reportRecipentEmail, int reportRecipentAction, int reportId) {
        String sql = ReportRecipientQueryStaments.UP_CREATE_REPORT_RECIPIENT;
        List<SqlParameter> parameters = new ArrayList<>();
        parameters.add(new SqlParameter(Types.VARCHAR));
        parameters.add(new SqlParameter(Types.TINYINT));
        parameters.add(new SqlParameter(Types.INTEGER));
        parameters.add(new SqlOutParameter("reportRecipientId", Types.INTEGER));
        int reportRecipientId = -1;
        try {
            Map<String, Object> resultMap = this.jdbcTemplate.call((Connection con) -> {
                CallableStatement callableStatement = con.prepareCall(sql);
                callableStatement.setString(1, reportRecipentEmail);
                callableStatement.setInt(2, reportRecipentAction);
                callableStatement.setInt(3, reportId);
                callableStatement.registerOutParameter(4, Types.INTEGER);
                return callableStatement;
            }, parameters);
            reportRecipientId = Integer.valueOf(resultMap.get("reportRecipientId").toString());
        } catch (NumberFormatException | DataAccessException e) {
             LOGGER.error("Error when call method createReportRecipient() with param " + Arrays.asList(reportRecipentEmail,reportRecipentAction, reportId), e);
        }
        return reportRecipientId;
    }

    @Override
    public List<ReportRecipient> getListRecipientByReportId(int reportId) {
        List<ReportRecipient> recipients = Collections.emptyList();
        String sql = ReportRecipientQueryStaments.UP_GET_RECIPIENTS_BY_REPORT_ID;
        try {
            recipients = this.jdbcTemplate.query(sql, new Object[]{reportId}, (ResultSet rs, int rowNum) -> {
                ReportRecipient reportRecipient = new ReportRecipient();
                try {
                    reportRecipient.setReportRecipientAction(rs.getInt(ReportRecipientQueryStaments.REPORT_RECIPIENT_ACTION_COL));
                    reportRecipient.setReportRecipientEmail(rs.getString(ReportRecipientQueryStaments.REPORT_RECIPIENT_EMAIL_COL));
                } catch (SQLException e) {
                    LOGGER.error("SQL Exception: Error when call method getListRecipientByReportId() with param " + reportId, e);
                }
                return reportRecipient;
            });

        } catch (DataAccessException e) {
            LOGGER.error("DataAccessException Exception: Error when call method getListRecipientByReportId() with param " + reportId, e);
        }
        return recipients;
    }

}
