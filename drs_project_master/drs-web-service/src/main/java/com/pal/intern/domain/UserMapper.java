package com.pal.intern.domain;

import java.util.Date;
import java.util.List;

public class UserMapper {

    private Integer id;
    private String login;
    private String firstName;
    private String lastName;
    private String mail;
    private Date createOn;
    private Date lastLoginOn;
    private List<DomainMapper> memberships;
    private List<DomainMapper> groups;

    public UserMapper() {
    }

    public Integer getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMail() {
        return mail;
    }

    public Date getCreateOn() {
        return createOn;
    }

    public Date getLastLoginOn() {
        return lastLoginOn;
    }

    public List<DomainMapper> getMemberships() {
        return memberships;
    }

    public List<DomainMapper> getGroups() {
        return groups;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setCreateOn(Date createOn) {
        this.createOn = createOn;
    }

    public void setLastLoginOn(Date lastLoginOn) {
        this.lastLoginOn = lastLoginOn;
    }

    public void setMemberships(List<DomainMapper> memberships) {
        this.memberships = memberships;
    }

    public void setGroups(List<DomainMapper> groups) {
        this.groups = groups;
    }

}
