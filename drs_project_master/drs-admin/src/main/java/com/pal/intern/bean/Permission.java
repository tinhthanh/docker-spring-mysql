package com.pal.intern.bean;

public class Permission {

    private int userId;
    private int roleId;

    public Permission(int userId, int roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    public Permission() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "Permission{" + "userId=" + userId + ", roleId=" + roleId + '}';
    }

}
