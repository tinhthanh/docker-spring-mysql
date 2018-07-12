package com.pal.intern.repository.impl;

import com.pal.intern.mapper.UserQueryStaments;
import com.pal.intern.domain.User;
import com.pal.intern.mapper.UserRowMapper;
import com.pal.intern.repository.UserRepository;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Optional<User> getUserByUserName(String userName) {
        Optional<User> result = Optional.empty();
        String sql = UserQueryStaments.UP_GET_USER_BY_USER_NAME;
        Object[] param = {userName};
        try {
            User user = this.jdbcTemplate.queryForObject(sql, param, new UserRowMapper());
            result = Optional.ofNullable(user);
        } catch (DataAccessException e) {
            LOGGER.error("Error when call method getUserByUserName() with param " + userName, e);
        }
        return result;
    }

    @Override
    public Optional<User> getUserByUserId(int userId) {
        Optional<User> result = Optional.empty();
        String sql = UserQueryStaments.UP_GET_USER_BY_USER_ID;
        Object[] param = {userId};
        try {
            User user = this.jdbcTemplate.queryForObject(sql, param, new UserRowMapper());
            result = Optional.ofNullable(user);
        } catch (DataAccessException e) {
            LOGGER.error("Error when call method getUserByUserId() with param " + userId, e);
        }
        return result;
    }

    @Override
    public Map<String, Object> getUserInfo(int userId) {
        Map<String, Object> result = new HashMap<>();
        String sql = UserQueryStaments.UP_GET_USER_INFO;
        Object params[] = {userId};
        try {
            result = this.jdbcTemplate.query(sql, params, (ResultSet rs) -> {

                Map<String, Object> mapRe = new HashMap<>();
                while (rs.next()) {
                    mapRe.put("userId", userId);
                    mapRe.put("userName", rs.getString(UserQueryStaments.USER_NAME_COL));
                    mapRe.put("email", rs.getString(UserQueryStaments.EMAIL_COL));
                    mapRe.put("fullName", rs.getString(UserQueryStaments.USER_FULL_NAME_COL));
                    mapRe.put("lastPasswordChange", rs.getTimestamp(UserQueryStaments.LAST_PASSWORD_CHANGE_COL));
                }
                return mapRe;
            });
        } catch (DataAccessException e) {
            LOGGER.error("Error when call method getUserInfo() with param " + userId, e);
        }

        return result;

    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        Optional<User> result = Optional.empty();
        String sql = UserQueryStaments.UP_GET_USER_BY_EMAIL;
        try {
            User user = this.jdbcTemplate.queryForObject(sql, new Object[]{email}, new UserRowMapper());
            result = Optional.ofNullable(user);
        } catch (DataAccessException e) {
            LOGGER.error("Error when call method getUserByEmail() with param " + email, e);
        }
        return result;

    }

}
