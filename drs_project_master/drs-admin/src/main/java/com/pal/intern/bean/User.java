package com.pal.intern.bean;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class User {

    private int userId;
    private String userName;
    private String email;
    private String password;
    private String fullName;
    private int status;
    private LocalDateTime lastPasswordChange;
    private ArrayList<Role> roles = new ArrayList<>();

    public User(int userId, String userName, String email, String password, String fullName, int status, LocalDateTime lastPasswordChange) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.status = status;
        this.lastPasswordChange = lastPasswordChange;
    }

    public User() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public LocalDateTime getLastPasswordChange() {
        return lastPasswordChange;
    }

    public void setLastPasswordChange(LocalDateTime lastPasswordChange) {
        this.lastPasswordChange = lastPasswordChange;
    }

    public ArrayList<Role> getRoles() {
        return roles;
    }

    public void setRoles(ArrayList<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", userName=" + userName + ", email=" + email + ", password=" + password + ", fullName=" + fullName + ", status=" + status + ", lastPasswordChange=" + lastPasswordChange + ' ' + this.roles.toString() + '}';
    }

}
