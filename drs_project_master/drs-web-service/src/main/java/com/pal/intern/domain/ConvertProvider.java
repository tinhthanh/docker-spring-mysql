package com.pal.intern.domain;

import com.taskadapter.redmineapi.bean.Group;
import com.taskadapter.redmineapi.bean.Issue;
import com.taskadapter.redmineapi.bean.Membership;
import com.taskadapter.redmineapi.bean.Project;
import com.taskadapter.redmineapi.bean.Watcher;
import com.taskadapter.redmineapi.bean.User;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public final class ConvertProvider {

    public static ProjectMapper from(Project project) {

        ProjectMapper projectMapper = new ProjectMapper();

        projectMapper.setId(project.getId());
        projectMapper.setName(project.getName());
        projectMapper.setIdentifier(project.getIdentifier());
        projectMapper.setDescription(project.getDescription());
        projectMapper.setHomepage(project.getHomepage());
        projectMapper.setCreateOn(project.getCreatedOn());
        projectMapper.setUpdateOn(project.getUpdatedOn());
        return projectMapper;
    }

    public static IssueMapper from(Issue issue) {

        IssueMapper issueMapper = new IssueMapper();
        issueMapper.setId(issue.getId());
        issueMapper.setProject(new DomainMapper(issue.getProjectId(), issue.getProjectName()));
        issueMapper.setTracker(new DomainMapper(issue.getTracker().getId(), issue.getTracker().getName()));
        issueMapper.setStatus(new DomainMapper(issue.getStatusId(), issue.getStatusName()));
        issueMapper.setPriority(new DomainMapper(issue.getPriorityId(), issue.getPriorityText()));
        issueMapper.setAuthor(new DomainMapper(issue.getAuthorId(), issue.getAuthorName()));
        issueMapper.setSubject(issue.getSubject());
        issueMapper.setAssignee(new DomainMapper(issue.getAssigneeId(), issue.getAssigneeName()));
        Collection<Watcher> watchers = issue.getWatchers();
        final List<DomainMapper> result = new LinkedList<>();
        if (watchers != null) {
            watchers.forEach(w -> {
                result.add(new DomainMapper(w.getId(), w.getName()));
            });
        }
        issueMapper.setListOfWatcher(result);

        issueMapper.setDescription(issue.getDescription());
        issueMapper.setDoneRatio(issue.getDoneRatio());
        issueMapper.setCreatedOn(issue.getCreatedOn());
        issueMapper.setUpdatedOn(issue.getUpdatedOn());
        issueMapper.setClosedOn(issue.getClosedOn());
        return issueMapper;
    }

    public static UserMapper from(User user) {
        UserMapper userMapper = new UserMapper();

        userMapper.setId(user.getId());
        userMapper.setLogin(user.getLogin());
        userMapper.setFirstName(user.getFirstName());
        userMapper.setLastName(user.getLastName());
        userMapper.setMail(user.getMail());
        userMapper.setCreateOn(user.getCreatedOn());
        userMapper.setLastLoginOn(user.getLastLoginOn());

        Collection<Membership> memberships = user.getMemberships();
        List<DomainMapper> listOfMemberships = new LinkedList<>();
        if (memberships != null) {
            memberships.forEach(m -> {
                listOfMemberships.add(new DomainMapper(m.getGroupId(), m.getGroupName()));
            });
        }
        userMapper.setMemberships(listOfMemberships);

        Collection<Group> groups = user.getGroups();
        List<DomainMapper> listOfGroups = new LinkedList<>();
        if (groups != null) {
            groups.forEach(g -> {
                listOfGroups.add(new DomainMapper(g.getId(), g.getName()));
            });
        }
        userMapper.setGroups(listOfGroups);
        return userMapper;
    }
}
