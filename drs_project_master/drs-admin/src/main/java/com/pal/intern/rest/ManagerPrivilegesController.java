package com.pal.intern.rest;

import com.pal.intern.bean.Privileges;
import com.pal.intern.bean.post.PrivilegesPost;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.pal.intern.services.PrivilegesService;

@RestController
@RequestMapping(value = "/admin/privileges")
public class ManagerPrivilegesController {

    @Autowired
    PrivilegesService privilegesService;

    @RequestMapping(value = "/{Id}", method = RequestMethod.GET)
    public ResponseEntity<List<Privileges>> getPurilegesByUserId(@PathVariable("Id") int privilegeId) {
        return new ResponseEntity<>(this.privilegesService.findAllPrivileges(privilegeId), HttpStatus.OK);
    }

    @RequestMapping(value = "/{Id}", method = RequestMethod.DELETE)
    public boolean deletePurilegesById(@PathVariable("Id") int privilegeId) {
        return this.privilegesService.deletePrivileges(privilegeId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    PrivilegesPost addPurileges(@RequestBody PrivilegesPost privilege) {
        return this.privilegesService.addPrivileges(privilege);
    }
    
     @RequestMapping(value = "view-by-user/{Id}", method = RequestMethod.GET)
    public ResponseEntity<List<Privileges>> getByUser(@PathVariable("Id") int privilegeId) {
        return new ResponseEntity<>(this.privilegesService.vierByUser(privilegeId), HttpStatus.OK);
    }

}
