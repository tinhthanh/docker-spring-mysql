package com.pal.intern.dao;

import java.util.List;

import com.pal.intern.bean.User;

public interface UserDao {

    public void addUser(User user);

    public void editUser(User user, int userId);

    public void deleteUser(int userId);

    public User find(int userId);

    public List< User> findAll();

    public List< User> findAllWithRole(int ofsset, int limit);

    public int totalUserCount();
}
