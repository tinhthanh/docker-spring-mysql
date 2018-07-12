package com.pal.intern.dao;

import com.pal.intern.mapper.RoleServiceQueryStaments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("roleDao")
public class RoleDaoImpl implements RoleDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public boolean addRoleUser(int userId, int roleId) {
        try {
            jdbcTemplate.update(RoleServiceQueryStaments.QUERY_ADD_ROLE_USER, new Object[]{userId, roleId}
            );
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public boolean deleteRoleUser(int userId, int roleId) {
        try {
            jdbcTemplate.update(RoleServiceQueryStaments.QUERY_DELETE_ROLE_USER, new Object[]{userId, roleId}
            );
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
