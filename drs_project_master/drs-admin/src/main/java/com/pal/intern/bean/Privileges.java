package com.pal.intern.bean;

import java.util.Date;

public class Privileges {

    private long reportPrivilegesId;
    private int userId;
    private String userReportName;
    private int userReportId;
    private Date startDate;
    private Date endDate;
    private int privilegesStatus;

    public Privileges() {
    }

    public Privileges(long reportPrivilegesId, int userId, String userReportName, int userReportId, Date startDate, Date endDate, int privilegesStatus) {
        this.reportPrivilegesId = reportPrivilegesId;
        this.userId = userId;
        this.userReportName = userReportName;
        this.userReportId = userReportId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.privilegesStatus = privilegesStatus;
    }

    public long getReportPrivilegesId() {
        return reportPrivilegesId;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserReportName() {
        return userReportName;
    }

    public int getUserReportId() {
        return userReportId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public int getPrivilegesStatus() {
        return privilegesStatus;
    }

    public void setReportPrivilegesId(long reportPrivilegesId) {
        this.reportPrivilegesId = reportPrivilegesId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserReportName(String userReportName) {
        this.userReportName = userReportName;
    }

    public void setUserReportId(int userReportId) {
        this.userReportId = userReportId;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setPrivilegesStatus(int privilegesStatus) {
        this.privilegesStatus = privilegesStatus;
    }

    @Override
    public String toString() {
        return "Privileges{" + "reportPrivilegesId=" + reportPrivilegesId + ", userId=" + userId + ", userReportName=" + userReportName + ", userReportId=" + userReportId + ", startDate=" + startDate + ", endDate=" + endDate + ", privilegesStatus=" + privilegesStatus + '}';
    }

    

}
