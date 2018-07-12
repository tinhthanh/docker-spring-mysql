package com.pal.intern.rest;

import com.pal.intern.bean.User;
import com.pal.intern.services.UserService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin")
public class ManagerUserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/get-all-users", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAllUser() {
        List<User> projectMappers = this.userService.findAll();
        return new ResponseEntity<>(projectMappers, HttpStatus.OK);
    }

    @RequestMapping(value = "/get-all-user-and-roles", method = RequestMethod.GET)
    public ResponseEntity< Map<String, Object>> getAllUserAndRole(
            @RequestParam(name = "offset", defaultValue = "0") int offset,
            @RequestParam(name = "limit", defaultValue = "5") int limit) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", userService.totalUserCount());
        List<User> projectMappers = this.userService.findAllWithRole(offset, limit);
        result.put("listOfUser", projectMappers);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
