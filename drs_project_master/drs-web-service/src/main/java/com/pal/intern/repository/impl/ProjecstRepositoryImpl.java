package com.pal.intern.repository.impl;

import com.pal.intern.config.redmine.RedmineProviderFactory;
import com.pal.intern.repository.ProjectsRepository;
import com.taskadapter.redmineapi.ProjectManager;
import com.taskadapter.redmineapi.RedmineException;
import com.taskadapter.redmineapi.bean.Project;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProjecstRepositoryImpl implements ProjectsRepository {

    @Autowired
    private RedmineProviderFactory redmineProviderFactory;

    @Override
    public Project getProjectById(int projectId) throws RedmineException {
        ProjectManager projectManager = this.redmineProviderFactory.getRedmineManager().getProjectManager();
        return projectManager.getProjectById(projectId);
    }

    @Override
    public List<Project> getAllProject() throws RedmineException {
        ProjectManager projectManager = this.redmineProviderFactory.getRedmineManager().getProjectManager();
        return projectManager.getProjects();
    }

}
