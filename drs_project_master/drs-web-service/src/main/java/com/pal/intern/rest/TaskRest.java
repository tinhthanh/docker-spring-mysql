package com.pal.intern.rest;

import com.pal.intern.config.api.ApiError;
import com.pal.intern.domain.TaskCreation;
import com.pal.intern.service.TaskService;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/tasks")
public class TaskRest {

    private final Log LOGGER = LogFactory.getLog(this.getClass().getName());
    @Autowired
    private TaskService taskService;

    @RequestMapping(value = "/{taskId}", method = RequestMethod.GET)
    @PreAuthorize(value = "isTaskOwner(#taskId)")
    public ResponseEntity<?> getTaskByTaskId(@PathVariable("taskId") int taskId) {
        Map<String, Object> taskResult = this.taskService.getTaskWithTaskIdAndDeleteStatus(taskId, 1);
        return ResponseEntity.ok(taskResult);
    }

    @RequestMapping(value = "/{taskId}", method = RequestMethod.DELETE)
    @PreAuthorize(value = "isTaskOwner(#taskId)")
    public ResponseEntity<?> deleteTask(@PathVariable("taskId") int taskId, HttpServletRequest request) {
        if (taskService.isTaskDeleted(taskId)) {
            ApiError apiError = new ApiError(HttpStatus.GONE, HttpStatus.GONE.value(), ApiError.getFullURL(request), Arrays.asList("resource has gone"));
            return new ResponseEntity<>(apiError, apiError.getStatus());
        } else {
            int numberOfRowEffected = this.taskService.deleteTaskWithTaskId(taskId);
            if (numberOfRowEffected > 0) {
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            }
            ApiError apiError = new ApiError(HttpStatus.CONFLICT, HttpStatus.CONFLICT.value(), ApiError.getFullURL(request), Arrays.asList("delete failed"));
            return new ResponseEntity<>(apiError, apiError.getStatus());
        }
    }

    @RequestMapping(method = RequestMethod.PUT)
    @PreAuthorize(value = "isTaskOwner(#model.taskID)")
    public ResponseEntity<?> ụpdateTask(@RequestBody TaskCreation model) {
        int numRowsUpdate = this.taskService.updateTask(model);
        if (numRowsUpdate > 0) {
            return new ResponseEntity<>(this.taskService.getTaskWithTaskId(model.getTaskID()), HttpStatus.CREATED);
        }
        return ResponseEntity.ok(Collections.emptyList());
    }
}
