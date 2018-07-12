package com.pal.intern.service;

import com.pal.intern.domain.Task;
import com.pal.intern.domain.TaskCreation;
import java.sql.Date;
import java.util.List;
import java.util.Map;

public interface TaskService {

    public int saveTask(String taskName, String description, Date targetDate, int taskStatus, String remark, int taskDateDefined, int reportId);

    public List<Task> getListTaskByReportId(int reportId);

    public int deleteTaskWithTaskId(int taskId);

    public Map<String, Object> getTaskWithTaskId(int taskId);

    public Map<String, Object> getTaskWithTaskIdAndDeleteStatus(int taskId, int deleteStatus);

    public boolean isTaskDeleted(int taskId);

    public int updateTask(TaskCreation model);
}
