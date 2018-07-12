package com.pal.intern.rest;

import com.pal.intern.config.api.ApiError;
import com.pal.intern.config.security.AuthenticationFacade;
import com.pal.intern.domain.CustomTask;
import com.pal.intern.domain.User;
import com.pal.intern.service.CustomTaskService;
import com.pal.intern.service.UserService;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/custom_tasks")
public class CustomTaskRest {

    private final Log LOGGER = LogFactory.getLog(this.getClass().getName());
    @Autowired
    private AuthenticationFacade authenticationFacade;
    @Autowired
    private UserService userService;
    @Autowired
    private CustomTaskService customTaskService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getCustomTaskWithPaging(
            @RequestParam(value = "page", required = true, defaultValue = "1") int page,
            @RequestParam(value = "pageSize", required = true, defaultValue = "25") int pageSize
    ) {
        Authentication authentication = authenticationFacade.getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Optional<User> user = this.userService.getUserByUserName(userDetails.getUsername());

        if (!user.isPresent()) {
            throw new AccessDeniedException("invalid token");
        }
        Map<String, Object> result = this.customTaskService.getCustomTaskWithPaging(user.get().getUserId(), page, pageSize);

        return ResponseEntity.ok(result);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createCustomTask(@RequestBody CustomTask model) {
        Authentication authentication = authenticationFacade.getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Optional<User> user = this.userService.getUserByUserName(userDetails.getUsername());
        if (!user.isPresent()) {
            throw new AccessDeniedException("invalid token");
        }
        model.setUserID(user.get().getUserId());
        return ResponseEntity.ok(this.customTaskService.createCustomTask(model));
    }

    @RequestMapping(value = "/getCustomTask/{id}")
    @PreAuthorize(value = "isCustomTaskOwner(#customTaskID)")
    public ResponseEntity<?> getCustomTaskByID(@PathVariable("id") int customTaskID) {

        Authentication authentication = authenticationFacade.getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Optional<User> user = this.userService.getUserByUserName(userDetails.getUsername());
        if (!user.isPresent()) {
            throw new AccessDeniedException("invalid token");
        }
        Optional<CustomTask> customTaskByID = this.customTaskService.getCustomTaskByID(customTaskID);
        if (customTaskByID.isPresent()) {
            return ResponseEntity.ok(customTaskByID.get());
        } else {
            return ResponseEntity.ok(Collections.emptyList());
        }
    }

    @RequestMapping(value = "/getCustomTask/{id}", method = RequestMethod.DELETE)
    @PreAuthorize(value = "isCustomTaskOwner(#customTaskID)")
    public ResponseEntity<?> deleteCustomTaskByID(@PathVariable("id") int customTaskID, HttpServletRequest request) {
        if (this.customTaskService.isDeleted(customTaskID)) {
            ApiError apiError = new ApiError(HttpStatus.CONFLICT, HttpStatus.CONFLICT.value(), ApiError.getFullURL(request), Arrays.asList("Resource already deleted"));
            return new ResponseEntity<>(apiError, apiError.getStatus());
        } else {
            if (this.customTaskService.deleteCustomTask(customTaskID)) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                ApiError apiError = new ApiError(HttpStatus.CONFLICT, HttpStatus.CONFLICT.value(), ApiError.getFullURL(request), Arrays.asList("Cannot delete, something fail"));
                return new ResponseEntity<>(apiError, apiError.getStatus());
            }
        }
    }

    @RequestMapping(method = RequestMethod.PUT)
    @PreAuthorize(value = "isCustomTaskOwner(#model.id)")
    public ResponseEntity<?> updateCustomTask(@RequestBody CustomTask model) {
        Optional<CustomTask> customTaskUpdated = this.customTaskService.updateCustomTask(model);
        if (customTaskUpdated.isPresent()) {
            return new ResponseEntity<>(customTaskUpdated.get(), HttpStatus.CREATED);
        } else {
            return ResponseEntity.ok(Collections.emptyList());
        }
    }

    @RequestMapping(method = RequestMethod.PATCH)
    @PreAuthorize(value = "isCustomTaskOwner(#model.id)")
    public ResponseEntity<?> updateCustomTaskOneField(@RequestBody CustomTask model, HttpServletRequest request) {
        int numEffectRows = this.customTaskService.updateCustomTaskOneField(model);
        if (numEffectRows > 0) {
            return new ResponseEntity<>(this.customTaskService.getCustomTaskByID(model.getId()), HttpStatus.CREATED);
        } else {
            ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(), ApiError.getFullURL(request), Arrays.asList("Change something to update"));
            return new ResponseEntity<>(apiError, apiError.getStatus());
        }
    }
}
