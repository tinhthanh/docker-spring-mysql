package com.pal.intern.config.jwt;

import javax.validation.constraints.NotNull;

public class UserAuth {

    @NotNull(message = "user name can not be null")
    private String userName;
    @NotNull(message = "password can not be null")
    private String password;

    public UserAuth() {
    }

    public UserAuth(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserAuth{" + "userName=" + userName + ", password=" + password + '}';
    }

}
