package com.pal.intern.services;

import com.pal.intern.bean.User;
import java.util.List;

public interface UserService {

    public void addUser(User user);

    public void editUser(User user, int userId);

    public void deleteUser(int userId);

    public User find(int userId);

    public List< User> findAll();

    public List<User> findAllWithRole(int offset, int limit);

    public int totalUserCount();

}
