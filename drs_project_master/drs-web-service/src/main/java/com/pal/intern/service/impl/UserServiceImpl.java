package com.pal.intern.service.impl;

import com.pal.intern.domain.Role;
import com.pal.intern.domain.User;
import com.pal.intern.repository.RoleRepostory;
import com.pal.intern.repository.UserRepository;
import com.pal.intern.service.UserService;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepostory roleRepostory;

    @Override
    public Optional<User> getUserByUserName(String userName) {
        Optional<User> user = this.userRepository.getUserByUserName(userName);
        if (user.isPresent()) {
            List<Role> userRole = this.roleRepostory.getListRolesByUserId(user.get().getUserId());
            if (userRole != null) {
                user.get().setPermission(new HashSet<>(userRole));
            }
        }
        return user;
    }

    @Override
    public Optional<User> getUserByUserId(int userId) {
        Optional<User> user = this.userRepository.getUserByUserId(userId);
        if (user.isPresent()) {
            List<Role> userRole = this.roleRepostory.getListRolesByUserId(user.get().getUserId());
            if (userRole != null) {
                user.get().setPermission(new HashSet<>(userRole));
            }
        }
        return user;
    }

    @Override
    public Map<String, Object> getUserInfo(int userId) {
        Map<String, Object> userInfo = this.userRepository.getUserInfo(userId);
        List<Role> userRole = this.roleRepostory.getListRolesByUserId(userId);
        if (userRole != null && userInfo != null) {
            userInfo.put("permission", userRole);
        }
        return userInfo;
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        Optional<User> user = this.userRepository.getUserByEmail(email);
        if (user.isPresent()) {
            List<Role> userRole = this.roleRepostory.getListRolesByUserId(user.get().getUserId());
            if (userRole != null) {
                user.get().setPermission(new HashSet<>(userRole));
            }
        }
        return user;
    }

}
