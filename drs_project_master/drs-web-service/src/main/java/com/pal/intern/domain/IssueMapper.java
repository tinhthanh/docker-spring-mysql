package com.pal.intern.domain;

import java.util.Date;
import java.util.List;

public class IssueMapper {

    private Integer id;
    private DomainMapper project;
    private DomainMapper tracker;
    private DomainMapper status;
    private DomainMapper priority;
    private DomainMapper author;
    private DomainMapper assignee;
    private List<DomainMapper> listOfWatcher;
    private String subject;
    private String description;
    private Integer doneRatio;
    private Date createdOn;
    private Date updatedOn;
    private Date closedOn;

    public IssueMapper() {
    }

    public Integer getId() {
        return id;
    }

    public DomainMapper getProject() {
        return project;
    }

    public DomainMapper getTracker() {
        return tracker;
    }

    public DomainMapper getStatus() {
        return status;
    }

    public DomainMapper getPriority() {
        return priority;
    }

    public DomainMapper getAuthor() {
        return author;
    }

    public DomainMapper getAssignee() {
        return assignee;
    }

    public String getSubject() {
        return subject;
    }

    public String getDescription() {
        return description;
    }

    public Integer getDoneRatio() {
        return doneRatio;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public Date getClosedOn() {
        return closedOn;
    }

    public List<DomainMapper> getListOfWatcher() {
        return listOfWatcher;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setProject(DomainMapper project) {
        this.project = project;
    }

    public void setTracker(DomainMapper tracker) {
        this.tracker = tracker;
    }

    public void setStatus(DomainMapper status) {
        this.status = status;
    }

    public void setPriority(DomainMapper priority) {
        this.priority = priority;
    }

    public void setAuthor(DomainMapper author) {
        this.author = author;
    }

    public void setAssignee(DomainMapper assignee) {
        this.assignee = assignee;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDoneRatio(Integer doneRatio) {
        this.doneRatio = doneRatio;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public void setClosedOn(Date closedOn) {
        this.closedOn = closedOn;
    }

    public void setListOfWatcher(List<DomainMapper> listOfWatcher) {
        this.listOfWatcher = listOfWatcher;
    }

    @Override
    public String toString() {
        return "IssueMapper{" + "id=" + id + ", project=" + project + ", tracker=" + tracker + ", status=" + status + ", priority=" + priority + ", author=" + author + ", assignee=" + assignee + ", listOfWatcher=" + listOfWatcher + ", subject=" + subject + ", description=" + description + ", doneRatio=" + doneRatio + ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + ", closedOn=" + closedOn + '}';
    }

}
