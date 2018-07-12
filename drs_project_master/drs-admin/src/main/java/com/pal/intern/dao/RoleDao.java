package com.pal.intern.dao;

public interface RoleDao {

    public boolean addRoleUser(int userId, int roleId);

    public boolean deleteRoleUser(int userId, int roleId);
}
