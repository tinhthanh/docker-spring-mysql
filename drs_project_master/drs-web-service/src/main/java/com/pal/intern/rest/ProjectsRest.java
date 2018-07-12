package com.pal.intern.rest;

import com.pal.intern.domain.ProjectMapper;
import com.pal.intern.service.ProjectsService;
import com.taskadapter.redmineapi.RedmineException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/redmine/projects")
public class ProjectsRest {

    @Autowired
    private ProjectsService projectsService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ProjectMapper>> getAllProject() throws RedmineException {
        List<ProjectMapper> projectMappers = this.projectsService.getAllProject();
        return new ResponseEntity<>(projectMappers, HttpStatus.OK);
    }

    @RequestMapping(value = "/{projectId}", method = RequestMethod.GET)
    public ResponseEntity<ProjectMapper> getProjectByProjectId(@PathVariable(name = "projectId", required = false) int projectId) throws RedmineException {
        ProjectMapper project = projectsService.getProjectById(projectId);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ResponseEntity<List<ProjectMapper>> searchProjectByName(@RequestParam(name = "keySearch", required = true) String keySearch) throws RedmineException {
        List<ProjectMapper> projectMappers = this.projectsService.searchProjectByName(keySearch);
        return new ResponseEntity<>(projectMappers, HttpStatus.OK);

    }

}
