package com.pal.intern.service.impl;

import com.pal.intern.domain.ConvertProvider;
import com.pal.intern.domain.ProjectMapper;
import com.pal.intern.repository.ProjectsRepository;
import com.pal.intern.service.ProjectsService;
import com.taskadapter.redmineapi.RedmineException;
import com.taskadapter.redmineapi.bean.Project;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjecstServiceImpl implements ProjectsService {

      private final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getName());
    
    @Autowired
    private ProjectsRepository projectsRepository;

    
    @Override
    public ProjectMapper getProjectById(int projectId) throws RedmineException {
        Project project = this.projectsRepository.getProjectById(projectId);
        ProjectMapper projectMapper = ConvertProvider.from(project);
        return projectMapper;
    }

    @Override
    public List<ProjectMapper> getAllProject() throws RedmineException {
        List<Project> projects = this.projectsRepository.getAllProject();
        final List<ProjectMapper> projectMappers = new ArrayList<>();
        projects.forEach(p -> {
            projectMappers.add(ConvertProvider.from(p));
        });
        return projectMappers;

    }

    @Override
    public List<ProjectMapper> searchProjectByName(String keySearch) throws RedmineException {
        LOGGER.info(keySearch);
        List<Project> projects = this.projectsRepository.getAllProject();
        final List<ProjectMapper> projectMappers = new ArrayList<>();
        projects.stream().filter(p -> p.getName().toLowerCase().contains(keySearch.toLowerCase())).forEachOrdered(p2 -> {
            projectMappers.add(ConvertProvider.from(p2));
        });
        return projectMappers;
    }

}
