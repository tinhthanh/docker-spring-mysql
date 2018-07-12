package com.pal.intern.services;

public interface RoleService {

    public boolean addRoleUser(int userId, int roleId);

    public boolean deleteRoleUser(int userId, int roleId);
}
