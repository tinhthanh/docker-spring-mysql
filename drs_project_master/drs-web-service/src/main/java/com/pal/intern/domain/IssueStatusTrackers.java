
package com.pal.intern.domain;

import java.util.Date;


public class IssueStatusTrackers {

    private int issueTrackerId;
    private String userName;
    private int issueId;
    private Date updateTime;

    public IssueStatusTrackers(int issueTrackerId, String userName, int issueId, Date updateTime) {
        this.issueTrackerId = issueTrackerId;
        this.userName = userName;
        this.issueId = issueId;
        this.updateTime = updateTime;
    }

    public IssueStatusTrackers() {
    }
    
    

    public int getIssueTrackerId() {
        return issueTrackerId;
    }

    public String getUserName() {
        return userName;
    }

    public int getIssueId() {
        return issueId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setIssueTrackerId(int issueTrackerId) {
        this.issueTrackerId = issueTrackerId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setIssueId(int issueId) {
        this.issueId = issueId;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "IssueStatusTrackers{" + "issueTrackerId=" + issueTrackerId + ", userName=" + userName + ", issueId=" + issueId + ", updateTime=" + updateTime + '}';
    }
    
    
}
