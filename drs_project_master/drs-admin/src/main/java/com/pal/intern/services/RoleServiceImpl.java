package com.pal.intern.services;

import com.pal.intern.dao.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao roleDao;

    @Override
    public boolean addRoleUser(int userId, int roleId) {
        return this.roleDao.addRoleUser(userId, roleId);
    }

    @Override
    public boolean deleteRoleUser(int userId, int roleId) {
        return this.roleDao.deleteRoleUser(userId, roleId);
    }

}
