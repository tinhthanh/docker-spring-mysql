package com.pal.intern.mapper.extractor;

import com.pal.intern.bean.Role;
import com.pal.intern.bean.User;
import com.pal.intern.mapper.RoleServiceQueryStaments;
import com.pal.intern.mapper.UserServiceQueryStaments;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class UserWithRoleExtractor implements ResultSetExtractor<List<User>> {

    @Override
    public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {
        Map<Integer, User> map = new HashMap<Integer, User>();
        User country = null;
        while (rs.next()) {
            int userId = rs.getInt(UserServiceQueryStaments.USER_ID_COL);
            country = map.get(userId);
            if (country == null) {
                country = new User();
                country.setUserId(userId);
                country.setUserName(rs.getString(UserServiceQueryStaments.USER_NAME_COL));
                country.setFullName(rs.getString(UserServiceQueryStaments.USER_FULL_NAME_COL));
                country.setLastPasswordChange(rs.getTimestamp(UserServiceQueryStaments.LAST_PASSWORD_CHANGE_COL).toLocalDateTime());
                country.setStatus(rs.getInt(UserServiceQueryStaments.USER_STATUS_COL));
                country.setRoles(new ArrayList<Role>());
                map.put(userId, country);
            }
            //continue process
            int stateCode = rs.getInt(RoleServiceQueryStaments.ROLE_ID_COL);
            if (stateCode > 0) {
                Role state = new Role();
                state.setRoleId(stateCode);
                state.setRoleName(rs.getString(RoleServiceQueryStaments.ROLE_NAME_COL));
                country.getRoles().add(state);
            }
        }
        return new ArrayList<User>(map.values());
    }

}
