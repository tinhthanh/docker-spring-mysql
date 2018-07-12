package com.pal.intern.repository;

import com.pal.intern.domain.Task;
import java.sql.Date;
import java.util.List;
import java.util.Map;

public interface TaskRepository {

    public int saveTask(String taskName, String description, Date targetDate, int taskStatus, String remark, int taskDateDefined, int reportId);

    public List<Task> getListTaskByReportId(int reportId);

    public Map<String, Object> getTaskWithTaskId(int taskId);

    public Map<String, Object> getTaskWithTaskIdAndDeleteStatus(int taskId, int deleteStatus);

    public int updateTaskWithAttribute(String columnName, Object value, int taskId);

    public int updateTask(String taskName, String description, Date targetDate, int status, String remark ,int taskId);

    public boolean isTaskOwner(int taskId, int userId);

}
