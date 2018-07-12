package com.pal.intern.domain;

import java.util.Date;

public class ProjectMapper {

    private Integer id;
    private String name;
    private String identifier;
    private String description;
    private String homepage;
    private Date createOn;
    private Date updateOn;

    public ProjectMapper() {
    }

    public ProjectMapper(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getDescription() {
        return description;
    }

    public String getHomepage() {
        return homepage;
    }

    public Date getCreateOn() {
        return createOn;
    }

    public Date getUpdateOn() {
        return updateOn;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public void setCreateOn(Date createOn) {
        this.createOn = createOn;
    }

    public void setUpdateOn(Date updateOn) {
        this.updateOn = updateOn;
    }

    @Override
    public String toString() {
        return "ProjectMapper{" + "id=" + id + ", name=" + name + ", identifier=" + identifier + ", description=" + description + ", homepage=" + homepage + ", createOn=" + createOn + ", updateOn=" + updateOn + '}';
    }

}
