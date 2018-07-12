package com.pal.intern.service.impl;

import com.pal.intern.repository.CustomTaskRepository;
import com.pal.intern.repository.GroupContactContentRepository;
import com.pal.intern.repository.GroupContactRepository;
import com.pal.intern.repository.ReportRepository;
import com.pal.intern.repository.TaskRepository;
import com.pal.intern.service.PermissionCheckerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionCheckerServiceImpl implements PermissionCheckerService {

    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private GroupContactRepository groupContactRepository;

    @Autowired
    private GroupContactContentRepository groupContactContentRepository;
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private CustomTaskRepository customTaskRepository;

    @Override
    public boolean isReportOwner(int reportId, int userId) {
        return this.reportRepository.isReportOwner(reportId, userId);
    }

    @Override
    public boolean isGroupContactOwner(int groupContactId, int userId) {
        return this.groupContactRepository.isGroupContactOwner(groupContactId, userId);
    }

    @Override
    public boolean isCustomTaskOwner(int customTaskID, int userID) {
        return this.customTaskRepository.isCustomTaskOwner(customTaskID, userID);
    }

    @Override
    public boolean isGroupContactContentOwner(int groupContactContentId, int userId) {
        return this.groupContactContentRepository.isGroupContactContentOwner(groupContactContentId, userId, 1, 1);
    }

    @Override
    public boolean isGroupContactContentOwnerWithAllStatus(int groupContactContentId, int userId) {
        return this.groupContactContentRepository.isGroupContactContentOwner(groupContactContentId, userId);
    }


    @Override
    public boolean isTaskOwner(int taskId, int userId) {
        return this.taskRepository.isTaskOwner(taskId, userId);

    }

}
