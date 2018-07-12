package com.pal.intern.domain;

import java.time.LocalDateTime;
import java.util.Set;

public class User {

    private int userId;
    private String userName;
    private String password;
    private String fullName;
    private String email;
    private int status;
    private Set<Role> permission;
    private LocalDateTime lastPasswordchange;

    public User(int userId, String userName, String password, String fullName, String email, int status, Set<Role> permission, LocalDateTime lastPasswordchange) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
        this.status = status;
        this.permission = permission;
        this.lastPasswordchange = lastPasswordchange;
    }

    public User() {
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public int getStatus() {
        return status;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Set<Role> getPermission() {
        return permission;
    }

    public void setPermission(Set<Role> permission) {
        this.permission = permission;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getLastPasswordchange() {
        return lastPasswordchange;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLastPasswordchange(LocalDateTime lastPasswordchange) {
        this.lastPasswordchange = lastPasswordchange;
    }

    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", userName=" + userName + ", password=" + password + ", fullName=" + fullName + ", email=" + email + ", status=" + status + ", permission=" + permission + ", lastPasswordchange=" + lastPasswordchange + '}';
    }

}
