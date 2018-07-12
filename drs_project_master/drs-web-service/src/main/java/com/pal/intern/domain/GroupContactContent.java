package com.pal.intern.domain;

public class GroupContactContent {

    private int id;
    private String contactEmail;
    private int contactAction;
    private int contactContentStatus;

    public GroupContactContent() {
    }

    public GroupContactContent(int id, String contactEmail, int contactAction, int contactContentStatus) {
        this.id = id;
        this.contactEmail = contactEmail;
        this.contactAction = contactAction;
        this.contactContentStatus = contactContentStatus;
    }

    public int getId() {
        return id;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public int getContactAction() {
        return contactAction;
    }

    public int getContactContentStatus() {
        return contactContentStatus;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public void setContactAction(int contactAction) {
        this.contactAction = contactAction;
    }

    public void setContactContentStatus(int contactContentStatus) {
        this.contactContentStatus = contactContentStatus;
    }

    @Override
    public String toString() {
        return "GroupContactContent{" + "id=" + id + ", contactEmail=" + contactEmail + ", contactAction=" + contactAction + ", contactContentStatus=" + contactContentStatus + '}';
    }

}
