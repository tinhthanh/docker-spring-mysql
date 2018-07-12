
package com.pal.intern.repository;

import com.taskadapter.redmineapi.RedmineException;
import com.taskadapter.redmineapi.bean.Project;
import java.util.List;

/**
 *
 * @author ttlang
 */
public interface ProjectsRepository {
    
    public Project getProjectById(int projectId) throws RedmineException;
    
    public List<Project> getAllProject()throws RedmineException;
    
    
}
