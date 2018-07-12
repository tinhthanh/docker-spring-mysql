package com.pal.intern.mapper;

import com.pal.intern.domain.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setUserId(rs.getInt(UserQueryStaments.USER_ID_COL));
        user.setUserName(rs.getString(UserQueryStaments.USER_NAME_COL));
        user.setPassword(rs.getString(UserQueryStaments.USER_PASSWORD_COL));
        user.setEmail(rs.getString(UserQueryStaments.EMAIL_COL));
        user.setFullName(rs.getString(UserQueryStaments.USER_FULL_NAME_COL));
        user.setLastPasswordchange(getLocalDateTime(rs.getTimestamp(UserQueryStaments.LAST_PASSWORD_CHANGE_COL)));
        user.setStatus(rs.getInt(UserQueryStaments.USER_STATUS_COL));
        return user;
    }

    private static LocalDateTime getLocalDateTime(Timestamp timestamp) {
        if (timestamp != null) {
            return timestamp.toLocalDateTime();
        }
        return null;
    }

}
