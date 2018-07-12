package com.pal.intern.repository;

import com.pal.intern.domain.User;
import java.util.Map;

import java.util.Optional;

public interface UserRepository {

    public Optional<User> getUserByUserName(String userName);

    public Optional<User> getUserByUserId(int userId);

    /**
     * get user info by user id
     *
     * @param userId
     * @return Map
     */
    public Map<String, Object> getUserInfo(int userId);

    public Optional<User> getUserByEmail(String email);
}
