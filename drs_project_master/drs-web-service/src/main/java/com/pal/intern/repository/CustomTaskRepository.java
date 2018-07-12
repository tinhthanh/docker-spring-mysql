package com.pal.intern.repository;

import com.pal.intern.domain.CustomTask;
import java.util.Map;
import java.util.Optional;

public interface CustomTaskRepository {

    public Map<String, Object> getCustomTaskWithPaging(int userID, int page, int pageSize);

    public int createCustomTask(CustomTask model);

    public Optional<CustomTask> getCustomTaskByID(int id);

    public boolean isCustomTaskOwner(int customTaskID, int userID);

    public boolean deleteCustomTask(int customTaskID);

    public boolean isDeleted(int customTaskID);

    public Optional<CustomTask> updateCustomTaskAllField(CustomTask model);

    public int updateCustomTaskOneField(String key, Object value, int customTaskID);

}
