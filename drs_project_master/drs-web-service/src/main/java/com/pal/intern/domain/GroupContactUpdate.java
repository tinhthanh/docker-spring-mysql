package com.pal.intern.domain;

public class GroupContactUpdate {

    private int groupContactId;
    private String groupContactName;

    public GroupContactUpdate() {
    }

    public GroupContactUpdate(int groupContactId, String groupContactName) {
        this.groupContactId = groupContactId;
        this.groupContactName = groupContactName;
    }

    public int getGroupContactId() {
        return groupContactId;
    }

    public String getGroupContactName() {
        return groupContactName;
    }

    public void setGroupContactId(int groupContactId) {
        this.groupContactId = groupContactId;
    }

    public void setGroupContactName(String groupContactName) {
        this.groupContactName = groupContactName;
    }

    @Override
    public String toString() {
        return "GroupContactUpdate{" + "groupContactId=" + groupContactId + ", groupContactName=" + groupContactName + '}';
    }

   
}
