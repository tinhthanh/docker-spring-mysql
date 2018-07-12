package com.pal.intern.service;

import com.pal.intern.domain.ProjectMapper;
import com.taskadapter.redmineapi.RedmineException;
import java.util.List;


public interface ProjectsService {

    public ProjectMapper getProjectById(int projectId) throws RedmineException;

    public List<ProjectMapper> getAllProject() throws RedmineException;
    
    public List<ProjectMapper>searchProjectByName(String keySearch)throws RedmineException;   

}
