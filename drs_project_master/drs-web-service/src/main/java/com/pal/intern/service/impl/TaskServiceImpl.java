package com.pal.intern.service.impl;

import com.pal.intern.domain.Task;
import com.pal.intern.domain.TaskCreation;
import com.pal.intern.mapper.TaskQueryStaments;
import com.pal.intern.repository.TaskRepository;
import com.pal.intern.service.TaskService;
import java.sql.Date;
import java.time.ZoneId;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public int saveTask(String taskName, String description, Date targetDate, int taskStatus, String remark, int taskDateDefined, int reportId) {
        return this.taskRepository.saveTask(taskName, description, targetDate, taskStatus, remark, taskDateDefined, reportId);
    }

    @Override
    public List<Task> getListTaskByReportId(int reportId) {
        return this.taskRepository.getListTaskByReportId(reportId);
    }

    @Override
    public int deleteTaskWithTaskId(int taskId) {
        return this.taskRepository.updateTaskWithAttribute(TaskQueryStaments.TASK_DELETE_STATUS_COL, 0, taskId);
    }

    @Override
    public Map<String, Object> getTaskWithTaskId(int taskId) {
        return this.taskRepository.getTaskWithTaskId(taskId);
    }

    @Override
    public boolean isTaskDeleted(int taskId) {
        Map<String, Object> taskById = this.taskRepository.getTaskWithTaskId(taskId);
        if (taskById != null && !taskById.isEmpty()) {
            return Boolean.getBoolean(taskById.get(TaskQueryStaments.TASK_DELETE_STATUS_COL).toString());
        }
        return false;
    }

    @Override
    public Map<String, Object> getTaskWithTaskIdAndDeleteStatus(int taskId, int deleteStatus) {
        Map<String, Object> task = this.taskRepository.getTaskWithTaskIdAndDeleteStatus(taskId, deleteStatus);
        Map<String, Object> result = Collections.emptyMap();
        if (task != null) {
            if (!task.isEmpty()) {
                result = new HashMap<>();
                result.put("taskId", task.get(TaskQueryStaments.TASK_ID_COL));
                result.put("taskName", task.get(TaskQueryStaments.TASK_NAME_COL));
                result.put("description", task.get(TaskQueryStaments.TASK_DESCRIPTION_COL));
                result.put("target_date", task.get(TaskQueryStaments.TASK_TARGET_DATE_COL));
                result.put("status", task.get(TaskQueryStaments.TASK_STATUS_COL));
                result.put("remark", task.get(TaskQueryStaments.TASK_REMARK_COL));
                result.put("taskDateDefined", task.get(TaskQueryStaments.TASK_DATE_DEFINED));
                result.put("taskDeleteStatus", task.get(TaskQueryStaments.TASK_DELETE_STATUS_COL));
            }
        }
        return result;
    }

    @Override
    public int updateTask(TaskCreation model) {
        return this.taskRepository.updateTask(model.getTaskName(), model.getDescription(), model.getTargetDate(), model.getTaskStatus(), model.getRemark(), model.getTaskID());
    }

}
