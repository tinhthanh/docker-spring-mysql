

package com.pal.intern.domain;

import java.util.List;

public class GroupContact {
    private int groupContactId;
    private String groupContactName;
    private List<GroupContactContent> contactContents;

    public GroupContact(int groupContactId, String groupContactName, List<GroupContactContent> contactContents) {
        this.groupContactId = groupContactId;
        this.groupContactName = groupContactName;
        this.contactContents = contactContents;
    }

    public GroupContact() {
    }

    public int getGroupContactId() {
        return groupContactId;
    }

    public String getGroupContactName() {
        return groupContactName;
    }

    public List<GroupContactContent> getContactContents() {
        return contactContents;
    }

    public void setGroupContactId(int groupContactId) {
        this.groupContactId = groupContactId;
    }

    public void setGroupContactName(String groupContactName) {
        this.groupContactName = groupContactName;
    }

    public void setContactContents(List<GroupContactContent> contactContents) {
        this.contactContents = contactContents;
    }

    @Override
    public String toString() {
        return "GroupContact{" + "groupContactId=" + groupContactId + ", groupContactName=" + groupContactName + ", contactContents=" + contactContents + '}';
    }
    
    

}
