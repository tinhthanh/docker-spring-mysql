package com.pal.intern.mapper;

import com.pal.intern.domain.Report;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import org.springframework.jdbc.core.RowMapper;

public class ReportMapper implements RowMapper<Report> {
    
    @Override
    public Report mapRow(ResultSet rs, int rowNum) throws SQLException {
        Report report = new Report();
        report.setReportId(rs.getInt(ReportQueryStaments.REPORT_ID_COL));
        report.setReportSubject(rs.getString(ReportQueryStaments.REPORT_SUBJECT_COL));
        report.setReportType(rs.getInt(ReportQueryStaments.REPORT_TYPE_COL));
        report.setReportDataEtc(rs.getString(ReportQueryStaments.REPORT_DATA_ETC_COL));
        report.setActionTime(getLocalDateTime(rs.getTimestamp(ReportQueryStaments.REPORT_ACTION_TIME_COL)));
        return report;
    }
    
    private static LocalDateTime getLocalDateTime(Timestamp timestamp) {
        if (timestamp != null) {
            return timestamp.toLocalDateTime();
        }
        return null;
    }
}
