package com.pal.intern.service;

import com.pal.intern.domain.UserMapper;
import com.taskadapter.redmineapi.RedmineException;
import java.util.List;

public interface UserRedmineService {

    public List<UserMapper> getAllUserRedmine() throws RedmineException;
    
    public String getUserEmailByUserId(int userId);
    

}
