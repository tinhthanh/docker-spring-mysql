package com.pal.intern.config.security.method;

import com.pal.intern.config.security.UserPrincipal;
import com.pal.intern.domain.User;
import com.pal.intern.service.PermissionCheckerService;
import java.util.Optional;
import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.core.Authentication;

public class CustomMethodSecurityExpressionRoot extends SecurityExpressionRoot
        implements MethodSecurityExpressionOperations {
    
    private Object filterObject;
    private Object returnObject;
    private Object target;
    private PermissionCheckerService permissionCheckerService;
    
    public CustomMethodSecurityExpressionRoot(Authentication authentication) {
        super(authentication);
    }
    
    public void setPermissionCheckerService(PermissionCheckerService permissionCheckerService) {
        this.permissionCheckerService = permissionCheckerService;
    }
    
    @Override
    public void setFilterObject(Object filterObject) {
        this.filterObject = filterObject;
    }
    
    @Override
    public Object getFilterObject() {
        return filterObject;
    }
    
    @Override
    public void setReturnObject(Object returnObject) {
        this.returnObject = returnObject;
    }
    
    @Override
    public Object getReturnObject() {
        return returnObject;
    }
    
    @Override
    public Object getThis() {
        return target;
    }
    
    public Optional<User> getUserFromPrincipal() {
        return Optional.ofNullable(((UserPrincipal) this.getPrincipal()).getUser());
    }
    
    public boolean isReportOwner(int reportId) {
        if (getUserFromPrincipal().isPresent()) {
            return this.permissionCheckerService.isReportOwner(reportId, getUserFromPrincipal().get().getUserId());
        }
        return false;
    }
    
    public boolean isTaskOwner(int taskId) {
        Optional<User> user = Optional.ofNullable(((UserPrincipal) this.getPrincipal()).getUser());
        if (user.isPresent()) {
            return this.permissionCheckerService.isTaskOwner(taskId, user.get().getUserId());
        }
        return false;
    }
    
    public boolean isGroupContactOwner(int groupContactId) {
        Optional<User> user = Optional.ofNullable(((UserPrincipal) this.getPrincipal()).getUser());
        if (user.isPresent()) {
            return this.permissionCheckerService.isGroupContactOwner(groupContactId, user.get().getUserId());
        }
        return false;
    }
    
    public boolean isGroupContactContentOwner(int groupContactContentId) {
        Optional<User> user = Optional.ofNullable(((UserPrincipal) this.getPrincipal()).getUser());
        if (user.isPresent()) {
            return this.permissionCheckerService.isGroupContactContentOwner(groupContactContentId, user.get().getUserId());
        }
        return false;
    }
    
    public boolean isGroupContactContentOwnerWithAllStatus(int groupContactContentId) {
        Optional<User> user = Optional.ofNullable(((UserPrincipal) this.getPrincipal()).getUser());
        if (user.isPresent()) {
            return this.permissionCheckerService.isGroupContactContentOwnerWithAllStatus(groupContactContentId, user.get().getUserId());
        }
        return false;
    }
   public boolean isCustomTaskOwner(int customTaskID){
         Optional<User> user = Optional.ofNullable(((UserPrincipal) this.getPrincipal()).getUser());
         if(user.isPresent()){
             return this.permissionCheckerService.isCustomTaskOwner(customTaskID, user.get().getUserId());
         }
         return false;
   }
}
