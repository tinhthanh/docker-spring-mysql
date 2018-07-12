package com.pal.intern.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class GroupContactCreation {

    @JsonInclude(Include.NON_NULL)
    private String groupContactName;

    public GroupContactCreation() {
    }

    public GroupContactCreation(String groupContactName) {
        this.groupContactName = groupContactName;
    }

    public String getGroupContactName() {
        return groupContactName;
    }

    public void setGroupContactName(String groupContactName) {
        this.groupContactName = groupContactName;
    }

    @Override
    public String toString() {
        return "GroupContactCreation{" + "groupContactName=" + groupContactName + '}';
    }

}
