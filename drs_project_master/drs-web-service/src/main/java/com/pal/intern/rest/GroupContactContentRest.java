package com.pal.intern.rest;

import com.pal.intern.config.api.ApiError;
import com.pal.intern.config.api.ResourceException;
import com.pal.intern.domain.GroupContactContent;
import com.pal.intern.domain.GroupContactContentCreation;
import com.pal.intern.service.GroupContactContentService;
import java.util.Arrays;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/group_contact_contents")
public class GroupContactContentRest {

    @Autowired
    private GroupContactContentService groupContactContentService;

    /**
     * API method for create new group contact content
     *
     * @param gccc entity want to save
     * @param request
     * @return new entity
     */
    @RequestMapping(method = RequestMethod.POST)
    @PreAuthorize(value = "isGroupContactOwner(#gccc.groupContactId)")
    public ResponseEntity<?> createGroupContactContent(@RequestBody @Valid GroupContactContentCreation gccc, HttpServletRequest request) {
        int newGroupContactContentId = groupContactContentService.createGroupContactContent(gccc.getContactEmail(), gccc.getContactAction(), gccc.getGroupContactId());
        if (newGroupContactContentId <= 0) {
            ApiError apiError = new ApiError(HttpStatus.CONFLICT, HttpStatus.CONFLICT.value(), ApiError.getFullURL(request), Arrays.asList("save entity failed.check your data"));
            return new ResponseEntity<>(apiError, apiError.getStatus());
        }
        return new ResponseEntity(groupContactContentService.getGroupContactContentById(newGroupContactContentId, 1).get(), HttpStatus.CREATED);
    }

    /**
     * API method for update group contact content
     *
     * @param groupContactContent
     * @param request
     * @return
     * @throws ResourceException
     */
    @RequestMapping(method = RequestMethod.PATCH)
    @PreAuthorize(value = "isGroupContactContentOwnerWithAllStatus(#groupContactContent.id)")
    public ResponseEntity<?> updateGroupContactContent(@RequestBody GroupContactContent groupContactContent, HttpServletRequest request) throws ResourceException {
        Optional<GroupContactContent> optional = this.groupContactContentService.getGroupContactContentById(groupContactContent.getId(), 1);
        if (!optional.isPresent()) {
            throw new ResourceException("resource not found");
        }
        int numberOfRowsEffected = this.groupContactContentService.updateGroupContactContent(groupContactContent);
        if (numberOfRowsEffected > 0) {
            return new ResponseEntity(this.groupContactContentService.getGroupContactContentById(groupContactContent.getId(), 1).get(), HttpStatus.CREATED);
        }
        ApiError apiError = new ApiError(HttpStatus.CONFLICT, HttpStatus.CONFLICT.value(), ApiError.getFullURL(request), Arrays.asList("save entity failed.check your data", "number of row effected " + numberOfRowsEffected));
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    /**
     * API method for delete group contact content
     *
     * @param groupContactContentId
     * @param request
     * @return
     * @throws ResourceException
     */
    @RequestMapping(value = "/{groupContactContentId}", method = RequestMethod.DELETE)
    @PreAuthorize(value = "isGroupContactContentOwnerWithAllStatus(#groupContactContentId)")
    public ResponseEntity<?> deleteGroupContactContentById(@PathVariable("groupContactContentId") int groupContactContentId, HttpServletRequest request) throws ResourceException {
        Optional<GroupContactContent> groupContactContentAllStatus = this.groupContactContentService.getGroupContactContentByIdWithAllStatus(groupContactContentId);
        if (!groupContactContentAllStatus.isPresent()) {
            throw new ResourceException("resource not found");
        } else {
            Optional<GroupContactContent> groupContactContent = this.groupContactContentService.getGroupContactContentById(groupContactContentId, 0);
            if (!groupContactContent.isPresent()) {
                this.groupContactContentService.deleteGroupContactContet(groupContactContentId);
                 return new ResponseEntity(HttpStatus.NO_CONTENT);
            }
            ApiError apiError = new ApiError(HttpStatus.GONE, HttpStatus.GONE.value(), ApiError.getFullURL(request), Arrays.asList("Resource already deleted"));
            return new ResponseEntity<>(apiError, apiError.getStatus());
        }

    }

    @RequestMapping(value = "/{groupContactContentId}", method = RequestMethod.GET)
    @PreAuthorize(value = "isGroupContactContentOwnerWithAllStatus(#groupContactContentId)")
    public ResponseEntity<?> getGroupContactContentById(@PathVariable("groupContactContentId") int groupContactContentId) throws ResourceException {
        Optional<GroupContactContent> optional = this.groupContactContentService.getGroupContactContentById(groupContactContentId, 1);
        if (!optional.isPresent()) {
            throw new ResourceException("resource not found");
        }
        return ResponseEntity.ok(optional.get());
    }
}
