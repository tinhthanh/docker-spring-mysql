package com.pal.intern.repository.impl;

import com.pal.intern.domain.Role;
import com.pal.intern.mapper.RoleRowMapper;
import com.pal.intern.mapper.RoleQueryStaments;
import com.pal.intern.repository.RoleRepostory;
import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RoleRepositoryImpl implements RoleRepostory {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Role> getListRolesByUserId(int userId) {
        String sql = RoleQueryStaments.QUERY_GET_LIST_ROLE_BY_USER_ID;
        Object[] params = {userId};
        List<Role> result = Collections.emptyList();
        try {
            result = this.jdbcTemplate.query(sql, params, new RoleRowMapper());
        } catch (DataAccessException e) {
            LOGGER.error("Error when call method getListRolesByUserId() with param " + userId, e);
        }

        return result;
    }

}
