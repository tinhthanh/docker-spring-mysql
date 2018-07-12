package com.pal.intern.service;

public interface PermissionCheckerService {

    public boolean isReportOwner(int reportId, int userId);

    public boolean isGroupContactOwner(int groupContactId, int userId);

    public boolean isGroupContactContentOwner(int groupContactContentId, int userId);

    public boolean isGroupContactContentOwnerWithAllStatus(int groupContactContentId, int userId);

    public boolean isTaskOwner(int taskId, int userId);

    
   public boolean isCustomTaskOwner(int customTaskID,int userID);
}
