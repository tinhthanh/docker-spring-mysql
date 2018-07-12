package com.pal.intern.rest;

import com.pal.intern.config.security.AuthenticationFacade;
import com.pal.intern.domain.IssueMapper;
import com.pal.intern.domain.User;
import com.pal.intern.service.IssueTrackerService;
import com.pal.intern.service.UserService;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/issue_trackers")
public class IssueTrackerRest {

    @Autowired
    private IssueTrackerService issueTrackerService;
    @Autowired
    private AuthenticationFacade authenticationFacade;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getIssueTrackerByUserId(
            @RequestParam(value = "page", required = true, defaultValue = "1") int page,
            @RequestParam(value = "pageSize", required = true, defaultValue = "25") int pageSize) {

        Authentication authentication = authenticationFacade.getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Optional<User> user = this.userService.getUserByUserName(userDetails.getUsername());

        if (!user.isPresent()) {
            throw new AccessDeniedException("invalid token");
        }
        Map<String, Object> result = issueTrackerService.getIssueByTrackerWithPaging(user.get().getUserName(), LocalDate.now(), page, pageSize);
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/today", method = RequestMethod.GET)
    public ResponseEntity<?> getIssueChangeInToDay() {
        String  userNameAuthentication = authenticationFacade.getUserName();
        Optional<User> user = this.userService.getUserByUserName(userNameAuthentication);

        if (!user.isPresent()) {
            throw new AccessDeniedException("invalid token");
        }
        List<IssueMapper> result = this.issueTrackerService.getIssueByStatusTracker(user.get().getUserName(), LocalDate.now());
        return ResponseEntity.ok(result);
    }

}
