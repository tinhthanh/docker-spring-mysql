package com.pal.intern.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.pal.intern.bean.User;
import com.pal.intern.mapper.UserServiceQueryStaments;
import com.pal.intern.mapper.extractor.UserWithRoleExtractor;

@Repository
@Qualifier("userDao")
public class UserDaoImpl implements UserDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void addUser(User user) {
        jdbcTemplate.update(UserServiceQueryStaments.QUERY_ADD_USER,
                user.getUserName(), user.getEmail(), user.getPassword(), user.getFullName());
    }

    @Override
    public void editUser(User user, int userId) {
        jdbcTemplate.update(UserServiceQueryStaments.QUERY_UPDATE_USER,
                user.getEmail(), user.getFullName(), userId);
    }

    @Override
    public void deleteUser(int userId) {
        jdbcTemplate.update(UserServiceQueryStaments.QUERY_DELETE_USER, userId);
    }

    @Override
    public User find(int personId) {
        User person = (User) jdbcTemplate.queryForObject(UserServiceQueryStaments.QUERY_FIND_USER_BY_ID,
                new Object[]{personId}, new BeanPropertyRowMapper(User.class));
        return person;
    }

    @Override
    public List< User> findAll() {
        List< User> persons = jdbcTemplate.query(UserServiceQueryStaments.QUERY_FIND_ALL, new BeanPropertyRowMapper(User.class));
        return persons;
    }

    @Override
    public List<User> findAllWithRole(int offset, int limit) {
        return jdbcTemplate.query(UserServiceQueryStaments.QUERY_GET_USER_AND_ROLE, new Object[]{limit, offset},
                new UserWithRoleExtractor());
    }

    @Override
    public int totalUserCount() {
        return this.jdbcTemplate.queryForObject(
                UserServiceQueryStaments.QUERY_GET_TOTAL_USER, Integer.class);
    }
}
