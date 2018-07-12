package com.pal.intern.repository;

import com.taskadapter.redmineapi.RedmineException;
import com.taskadapter.redmineapi.bean.User;
import java.util.List;
import java.util.Optional;

public interface UserRedmineRepository {

    public List<User> getAllUserRedmine() throws RedmineException;

    public Optional<User> getUserById(int userId);

}
