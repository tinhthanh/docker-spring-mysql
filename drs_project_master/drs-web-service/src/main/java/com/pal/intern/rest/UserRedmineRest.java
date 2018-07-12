package com.pal.intern.rest;

import com.pal.intern.domain.UserMapper;
import com.pal.intern.service.UserRedmineService;
import com.taskadapter.redmineapi.RedmineException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/redmine/users")
public class UserRedmineRest {

    @Autowired
    private UserRedmineService userRedmineService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserMapper>> getAllUserRedmine() throws RedmineException {
        List<UserMapper> result = this.userRedmineService.getAllUserRedmine();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
