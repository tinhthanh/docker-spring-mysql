package com.pal.intern.service;

import com.pal.intern.domain.User;
import java.util.Map;
import java.util.Optional;

public interface UserService {

    public Optional<User> getUserByUserName(String userName);

    public Optional<User> getUserByUserId(int userId);

    public Map<String, Object> getUserInfo(int userId);
    
    public Optional<User> getUserByEmail(String email);
}
