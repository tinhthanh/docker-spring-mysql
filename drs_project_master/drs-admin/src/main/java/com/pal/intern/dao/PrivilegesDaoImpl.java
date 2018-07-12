package com.pal.intern.dao;

import com.pal.intern.bean.Privileges;
import com.pal.intern.bean.post.PrivilegesPost;
import com.pal.intern.mapper.PrivilegesQueryStaments;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class PrivilegesDaoImpl implements PrivilegesDao {

    @Autowired
    JdbcTemplate getJdbcTemplate;

    @Override
    public List<Privileges> findAllPrivileges(int userId) {
        List<Privileges> result = getJdbcTemplate.query(PrivilegesQueryStaments.QUERY_GET_LIST, new Object[]{userId}, (ResultSet rs, int rowNum) -> {
            Privileges privileges = new Privileges();
            privileges.setReportPrivilegesId(rs.getInt(PrivilegesQueryStaments.REPORT_PRIVILEGES_ID_COL));
            privileges.setUserId(rs.getInt(PrivilegesQueryStaments.USER_ID_COL));
            privileges.setUserReportName(rs.getString(PrivilegesQueryStaments.USER_REPORT_NAME_COL));
            privileges.setUserReportId(rs.getInt(PrivilegesQueryStaments.USER_REPORT_ID_COL));
            if (rs.getTimestamp(PrivilegesQueryStaments.START_DATE_COL) != null) {
                LocalDateTime starDateInLocal = rs.getTimestamp(PrivilegesQueryStaments.START_DATE_COL).toLocalDateTime();
                Date date = Timestamp.valueOf(starDateInLocal);
                privileges.setStartDate(date);
            }
            if (rs.getTimestamp(PrivilegesQueryStaments.END_DATE_COL) != null) {
                LocalDateTime endDateInLocal = rs.getTimestamp(PrivilegesQueryStaments.END_DATE_COL).toLocalDateTime();
                Date date = Timestamp.valueOf(endDateInLocal);
                privileges.setEndDate(date);
            }
            return privileges;
        });
        return result;
    }

    @Override
    public boolean deletePrivileges(int purilegesId) {
        try {
            this.getJdbcTemplate.update(PrivilegesQueryStaments.QUERY_DELETE_PRIVILEGES, new Object[]{purilegesId});
            return true;
        } catch (DataAccessException e) {
            return false;
        }
    }

    @Override
    public PrivilegesPost addPrivileges(PrivilegesPost privileges) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        this.getJdbcTemplate.update((Connection cnctn) -> {
            PreparedStatement ps
                    = cnctn.prepareStatement(PrivilegesQueryStaments.QUERY_ADD_PRIVILEGES, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, privileges.getUserId());
            ps.setString(2, privileges.getUserReportName());
            ps.setInt(3, privileges.getUserReportId());

            ps.setTimestamp(4, new Timestamp(privileges.getStartDate().getTime()));
            ps.setTimestamp(5, new Timestamp(privileges.getEndDate().getTime()));
            ps.setInt(6, privileges.getPrivilegesStatus());
            return ps;
        }, keyHolder);
        privileges.setReportPrivilegesId(keyHolder.getKey().longValue());
        return privileges;
    }

    @Override
    public List<Privileges> vierByUser(int userId) {
        List<Privileges> result = getJdbcTemplate.query(PrivilegesQueryStaments.QUERY_GET_LIST_VIEW_BY_ID, new Object[]{userId}, (ResultSet rs, int rowNum) -> {
            Privileges privileges = new Privileges();
            privileges.setReportPrivilegesId(rs.getInt(PrivilegesQueryStaments.REPORT_PRIVILEGES_ID_COL));
            privileges.setUserId(rs.getInt(PrivilegesQueryStaments.USER_ID_COL));
            privileges.setUserReportName(rs.getString(PrivilegesQueryStaments.USER_REPORT_NAME_COL));
            privileges.setUserReportId(rs.getInt(PrivilegesQueryStaments.USER_REPORT_ID_COL));
            if (rs.getTimestamp(PrivilegesQueryStaments.START_DATE_COL) != null) {
                LocalDateTime starDateInLocal = rs.getTimestamp(PrivilegesQueryStaments.START_DATE_COL).toLocalDateTime();
                Date date = Timestamp.valueOf(starDateInLocal);
                privileges.setStartDate(date);
            }
            if (rs.getTimestamp(PrivilegesQueryStaments.END_DATE_COL) != null) {
                LocalDateTime endDateInLocal = rs.getTimestamp(PrivilegesQueryStaments.END_DATE_COL).toLocalDateTime();
                Date date = Timestamp.valueOf(endDateInLocal);
                privileges.setEndDate(date);
            }
            return privileges;
        });
        return result;
    }

}
