package com.pal.intern.domain;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;

public class GroupContactContentCreation {

    @NotNull(message = "contact email can not be null")
    private String contactEmail;

    @Range(min = 1, max = 2, message = "contact action value is not valid")
    private int contactAction;

    private int groupContactId;

    public GroupContactContentCreation() {
    }

    public GroupContactContentCreation(String contactEmail, int contactAction, int groupContactId) {
        this.contactEmail = contactEmail;
        this.contactAction = contactAction;
        this.groupContactId = groupContactId;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public int getContactAction() {
        return contactAction;
    }

    public int getGroupContactId() {
        return groupContactId;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public void setContactAction(int contactAction) {
        this.contactAction = contactAction;
    }

    public void setGroupContactId(int groupContactId) {
        this.groupContactId = groupContactId;
    }

    @Override
    public String toString() {
        return "GroupContactContentCreation{" + "contactEmail=" + contactEmail + ", contactAction=" + contactAction + ", groupContactId=" + groupContactId + '}';
    }

}
