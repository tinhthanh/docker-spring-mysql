package com.pal.intern.rest;

import com.pal.intern.config.api.ResourceException;
import com.pal.intern.config.jwt.JwtService;
import com.pal.intern.domain.User;
import com.pal.intern.service.UserService;
import java.util.Map;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRest {

    @Autowired
    private UserService userService;
    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserDetailsService userDetailsService;

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    @PreAuthorize(value = "hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> getUserByUserId(@PathVariable("userId") int userId) throws ResourceException {
        Optional<User> user = this.userService.getUserByUserId(userId);
        if (!user.isPresent()) {
            throw new ResourceException("user not found");
        }
        return new ResponseEntity<>(user.get(), HttpStatus.OK);
    }

    @RequestMapping(value = "/user/info", method = RequestMethod.GET)
    @PreAuthorize(value = "hasRole('ROLE_USER')")
    public ResponseEntity<?> getUserInfo(HttpServletRequest request) {
        String auth = this.jwtService.getToken(request);
        String userName = this.jwtService.getUserNameFromToKen(auth);
        if (auth != null && userName != null) {
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(userName);
            if (this.jwtService.validateToken(auth, userDetails)) {
                Optional<User> user = this.userService.getUserByUserName(userName);
                if (user.isPresent()) {
                    Map<String, Object> result = userService.getUserInfo(user.get().getUserId());
                    return ResponseEntity.ok(result);
                }

            }

        }
        throw new AccessDeniedException("invalid token");

    }
}
