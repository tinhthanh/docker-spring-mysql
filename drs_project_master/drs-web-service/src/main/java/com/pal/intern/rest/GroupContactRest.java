package com.pal.intern.rest;

import com.pal.intern.config.api.ApiError;
import com.pal.intern.config.api.ResourceException;
import com.pal.intern.config.security.AuthenticationFacade;
import com.pal.intern.domain.GroupContact;
import com.pal.intern.domain.GroupContactCreation;
import com.pal.intern.domain.GroupContactUpdate;
import com.pal.intern.domain.User;
import com.pal.intern.service.GroupContactService;
import com.pal.intern.service.UserService;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
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
@RequestMapping(value = "/group_contacts")
public class GroupContactRest {

    @Autowired
    private GroupContactService groupContactService;
    @Autowired
    private AuthenticationFacade authenticationFacade;
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAllGroupContactWithPaging(
            @RequestParam(value = "page", required = true, defaultValue = "1") int page,
            @RequestParam(value = "pageSize", required = true, defaultValue = "25") int pageSize) {

        Authentication authentication = authenticationFacade.getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Optional<User> user = this.userService.getUserByUserName(userDetails.getUsername());

        if (!user.isPresent()) {
            throw new AccessDeniedException("invalid token");
        }
        Map<String, Object> result = this.groupContactService.getAllGroupContactByUserIdWithPaging(user.get().getUserId(), 1, page, pageSize);
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/{group_contact_id}", method = RequestMethod.GET)
    @PreAuthorize(value = "isGroupContactOwner(#groupContactId)")
    public ResponseEntity<?> getGroupContactById(@PathVariable("group_contact_id") int groupContactId) {
        Optional<GroupContact> result = this.groupContactService.getGroupContactByIdAndStatus(groupContactId, 1);
        if (result.isPresent()) {
            return ResponseEntity.ok(result.get());
        }
        return ResponseEntity.ok(Collections.emptyList());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createGroupContact(@RequestBody GroupContactCreation groupContact, HttpServletRequest request) {
        Authentication authentication = authenticationFacade.getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Optional<User> user = this.userService.getUserByUserName(userDetails.getUsername());
        int newGroupContactId = this.groupContactService.createGroupContact(groupContact.getGroupContactName(), user.get().getUserId());

        if (newGroupContactId <= 0) {
            ApiError apiError = new ApiError(HttpStatus.CONFLICT, HttpStatus.CONFLICT.value(), ApiError.getFullURL(request), Arrays.asList("save entity failed.check your data"));
            return new ResponseEntity<>(apiError, apiError.getStatus());
        }
        return new ResponseEntity(this.groupContactService.getGroupContactByIdAndStatus(newGroupContactId, 1).get(), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{groupContactId}", method = RequestMethod.DELETE)
    @PreAuthorize(value = "isGroupContactOwner(#groupContactId)")
    public ResponseEntity<?> deleteGroupContact(@PathVariable("groupContactId") int groupContactId, HttpServletRequest request) {
        int numberOfRowEffective = this.groupContactService.deleteGroupContact(groupContactId);
        if (numberOfRowEffective > 0) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        ApiError apiError = new ApiError(HttpStatus.CONFLICT, HttpStatus.CONFLICT.value(), ApiError.getFullURL(request), Arrays.asList("delete failed"));
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    @RequestMapping(method = RequestMethod.PATCH)
    @PreAuthorize(value = "isGroupContactOwner(#groupContact.groupContactId)")
    public ResponseEntity<?> updateGroupContact(@RequestBody GroupContactUpdate groupContact, HttpServletRequest request) throws ResourceException {
        Optional<GroupContact> optional = this.groupContactService.getGroupContactByIdAndStatus(groupContact.getGroupContactId(), 1);
        int numberOfRowEffected = 0;
        if (!optional.isPresent()) {
            throw new ResourceException("resource not found");
        } else {
            numberOfRowEffected = this.groupContactService.updateGroupContactById(groupContact.getGroupContactName(), groupContact.getGroupContactId());
            if (numberOfRowEffected >= 0) {
                return new ResponseEntity<>(this.groupContactService.getGroupContactByIdAndStatus(groupContact.getGroupContactId(), 1).get(), HttpStatus.CREATED);
            }
        }
        ApiError apiError = new ApiError(HttpStatus.CONFLICT, HttpStatus.CONFLICT.value(), ApiError.getFullURL(request), Arrays.asList("save entity failed.check your data", "number of row effected " + numberOfRowEffected));
        return new ResponseEntity<>(apiError, apiError.getStatus());

    }
}
