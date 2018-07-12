package com.pal.intern.rest;

import com.pal.intern.bean.Permission;
import com.pal.intern.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin/role")
public class ManagerRoleControler {

    @Autowired
    RoleService roleService;

    @RequestMapping(method = RequestMethod.POST)
    public HttpStatus addRoleUser(@RequestBody Permission permission) {
        boolean result = this.roleService.addRoleUser(permission.getUserId(), permission.getRoleId());
        return result ? HttpStatus.OK : HttpStatus.CONFLICT;
    }

    @RequestMapping(value = "/{userId}/{roleId}", method = RequestMethod.DELETE)
    public HttpStatus deleteRoleUser(@PathVariable("userId") int userId, @PathVariable("roleId") int roleId) {
        boolean result = this.roleService.deleteRoleUser(userId, roleId);
        return result ? HttpStatus.OK : HttpStatus.CONFLICT;
    }
}
