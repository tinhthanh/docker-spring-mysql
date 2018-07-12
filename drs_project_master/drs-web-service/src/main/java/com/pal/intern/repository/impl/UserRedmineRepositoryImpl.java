package com.pal.intern.repository.impl;

import com.pal.intern.config.redmine.RedmineProviderFactory;
import com.pal.intern.repository.UserRedmineRepository;
import com.taskadapter.redmineapi.RedmineException;
import com.taskadapter.redmineapi.UserManager;
import com.taskadapter.redmineapi.bean.User;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRedmineRepositoryImpl implements UserRedmineRepository {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getName());
    
    @Autowired
    private RedmineProviderFactory redmineProviderFactory;

    @Override
    public List<User> getAllUserRedmine() throws RedmineException {
        UserManager userManager = redmineProviderFactory.getRedmineManager().getUserManager();
        return userManager.getUsers();

    }

    @Override
    public Optional<User> getUserById(int userId) {
        Optional<User> result = Optional.empty();
        try {
            UserManager userManager = redmineProviderFactory.getRedmineManager().getUserManager();
            result = Optional.ofNullable(userManager.getUserById(userId));
        } catch (RedmineException e) {
            LOGGER.error("Error when call method getUserById() with param " + Arrays.asList(userId), e);
        }
        return result;
    }

}
