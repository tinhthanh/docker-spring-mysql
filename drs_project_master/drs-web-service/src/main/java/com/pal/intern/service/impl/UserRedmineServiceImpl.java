package com.pal.intern.service.impl;

import com.pal.intern.domain.ConvertProvider;
import com.pal.intern.domain.UserMapper;
import com.pal.intern.repository.UserRedmineRepository;
import com.pal.intern.service.UserRedmineService;
import com.taskadapter.redmineapi.RedmineException;
import com.taskadapter.redmineapi.bean.User;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRedmineServiceImpl implements UserRedmineService {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getName());
    @Autowired
    private UserRedmineRepository userRedmineRepository;

    @Override
    public List<UserMapper> getAllUserRedmine() throws RedmineException {
        List<User> listOfUser = this.userRedmineRepository.getAllUserRedmine();
        List<UserMapper> result = new LinkedList<>();
        if (listOfUser != null) {
            listOfUser.forEach(u -> {
                result.add(ConvertProvider.from(u));
            });
        }
        return result;
    }

    @Override
    public String getUserEmailByUserId(int userId) {
        Optional<User> result = Optional.empty();
        String email = null;
        try {
            result = this.userRedmineRepository.getUserById(userId);
        } catch (Exception e) {
            LOGGER.error("Error when call method getUserEmailByUserId() with param " + Arrays.asList(userId), e);
        }
        if (result.isPresent()) {
            email = result.get().getMail();
        }
        return email;
    }

}
