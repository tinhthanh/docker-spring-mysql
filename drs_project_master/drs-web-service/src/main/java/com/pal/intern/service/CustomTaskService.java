package com.pal.intern.service;

import com.pal.intern.domain.CustomTask;
import java.util.Map;
import java.util.Optional;

public interface CustomTaskService {

    public Map<String, Object> getCustomTaskWithPaging(int userID, int page, int pageSize);

    public int createCustomTask(CustomTask model);

    public Optional<CustomTask> getCustomTaskByID(int id);

    public boolean isCustomTaskOwner(int customTaskID, int userID);

    public boolean deleteCustomTask(int customTaskID);

    public boolean isDeleted(int customTaskID);

    public Optional<CustomTask> updateCustomTask(CustomTask model);

    public int updateCustomTaskOneField(CustomTask model);
}
