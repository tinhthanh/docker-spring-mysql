package com.pal.intern.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pal.intern.bean.User;
import com.pal.intern.dao.UserDao;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    public void addUser(User user) {
        userDao.addUser(user);
    }

    public void editUser(User user, int personId) {
        userDao.editUser(user, personId);
    }

    public void deleteUser(int userId) {
        userDao.deleteUser(userId);
    }

    public User find(int userId) {
        return userDao.find(userId);
    }

    public List< User> findAll() {
        return userDao.findAll();
    }

    @Override
    public List<User> findAllWithRole(int offset, int limit) {
        return this.userDao.findAllWithRole(offset, limit);
    }

    @Override
    public int totalUserCount() {
        return this.userDao.totalUserCount();
    }

}
