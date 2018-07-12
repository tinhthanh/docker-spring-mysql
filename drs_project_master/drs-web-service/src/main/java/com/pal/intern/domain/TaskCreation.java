package com.pal.intern.domain;

import java.sql.Date;

public class TaskCreation {

    private String taskName;
    private String description;
    private Date targetDate;
    private int taskStatus;
    private String remark;
    private int taskDateDefined;
    private int taskID;

    public TaskCreation(String taskName, String description, Date targetDate, int taskStatus, String remark, int taskDateDefined) {
        this.taskName = taskName;
        this.description = description;
        this.targetDate = targetDate;
        this.taskStatus = taskStatus;
        this.remark = remark;
        this.taskDateDefined = taskDateDefined;
    }

    public TaskCreation() {
    }

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getDescription() {
        return description;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public int getTaskStatus() {
        return taskStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    public void setTaskStatus(int taskStatus) {
        this.taskStatus = taskStatus;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getTaskDateDefined() {
        return taskDateDefined;
    }

    public void setTaskDateDefined(int taskDateDefined) {
        this.taskDateDefined = taskDateDefined;
    }

    @Override
    public String toString() {
        return "TaskCreation{" + "taskName=" + taskName + ", description=" + description + ", targetDate=" + targetDate + ", taskStatus=" + taskStatus + ", remark=" + remark + ", taskDateDefined=" + taskDateDefined + ", taskID=" + taskID + '}';
    }

}
