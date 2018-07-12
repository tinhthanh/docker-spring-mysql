package com.pal.intern.domain;

import java.sql.Date;

public class CustomTask {

    private int id;
    private String name;
    private String description;
    private Date targetDate;
    private int taskStatus;
    private String remark;
    private byte customTaskStatus;
    private int userID;

    public CustomTask() {
    }

    public CustomTask(int id, String name, String description, Date targetDate, int taskStatus, String remark, byte customTaskStatus, int userID) {
        this(id, name, description, targetDate, taskStatus, remark);
        this.customTaskStatus = customTaskStatus;
        this.userID = userID;
    }

    public CustomTask(int id, String name, String description, Date targetDate, int taskStatus, String remark) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.targetDate = targetDate;
        this.taskStatus = taskStatus;
        this.remark = remark;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    public int getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(int taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public byte getCustomTaskStatus() {
        return customTaskStatus;
    }

    public void setCustomTaskStatus(byte customTaskStatus) {
        this.customTaskStatus = customTaskStatus;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "CustomTask{" + "id=" + id + ", name=" + name + ", description=" + description + ", targetDate=" + targetDate + ", taskStatus=" + taskStatus + ", remark=" + remark + ", customTaskStatus=" + customTaskStatus + ", userID=" + userID + '}';
    }

}
