package com.pal.intern.domain;

import java.sql.Date;

public class Task {

    private int taskId;
    private String taskName;
    private String description;
    private Date targetDate;
    private int status;
    private String remark;
    private int taskDateDefined;

    public Task() {
    }

    public int getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getDescription() {
        return description;
    }

    public int getStatus() {
        return status;
    }

    public String getRemark() {
        return remark;
    }

    public int getTaskDateDefined() {
        return taskDateDefined;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setTaskDateDefined(int taskDateDefined) {
        this.taskDateDefined = taskDateDefined;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    @Override
    public String toString() {
        return "Task{" + "taskId=" + taskId + ", taskName=" + taskName + ", description=" + description + ", targetDate=" + targetDate + ", status=" + status + ", remark=" + remark + ", taskDateDefined=" + taskDateDefined + '}';
    }


}
