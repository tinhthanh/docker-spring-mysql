package com.pal.intern.domain;

import java.util.Date;

public class IssueStatusTracker {
    
    
    private int redmineUserId;
    private int issueId;
    private Date timeUpdate;
    
    public IssueStatusTracker() {
    }

    public IssueStatusTracker(int redmineUserId, int issueId, Date timeUpdate) {
        this.redmineUserId = redmineUserId;
        this.issueId = issueId;
        this.timeUpdate = timeUpdate;
    }

    public void setRedmineUserId(int redmineUserId) {
        this.redmineUserId = redmineUserId;
    }

    public void setIssueId(int issueId) {
        this.issueId = issueId;
    }

    public void setTimeUpdate(Date timeUpdate) {
        this.timeUpdate = timeUpdate;
    }

    public int getRedmineUserId() {
        return redmineUserId;
    }

    public int getIssueId() {
        return issueId;
    }

    public Date getTimeUpdate() {
        return timeUpdate;
    }

    @Override
    public String toString() {
        return "IssueStatusTracker{" + "redmineUserId=" + redmineUserId + ", issueId=" + issueId + ", timeUpdate=" + timeUpdate + '}';
    }

   
}
