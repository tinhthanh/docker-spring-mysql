package com.pal.intern.mapper;

import com.pal.intern.domain.Role;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class RoleRowMapper implements RowMapper<Role> {

    @Override
    public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
        Role role = new Role();
        role.setRoleId(rs.getInt(RoleQueryStaments.ROLE_ID_COL));
        role.setRoleName(rs.getString(RoleQueryStaments.ROLE_NAME_COL));
        return role;

    }

}
