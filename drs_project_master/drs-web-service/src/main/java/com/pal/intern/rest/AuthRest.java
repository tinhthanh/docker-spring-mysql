package com.pal.intern.rest;

import com.pal.intern.config.api.ApiError;
import com.pal.intern.config.app.ConfigVariable;
import com.pal.intern.config.app.ParamConfig;
import com.pal.intern.config.jwt.JwtService;
import com.pal.intern.config.jwt.UserAuth;
import com.pal.intern.config.jwt.UserTokenState;
import com.pal.intern.config.security.AuthenticationFacade;
import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
public class AuthRest {

    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private ParamConfig paramConfig;

    @Autowired
    private AuthenticationFacade authenticationFacade;

    private final Log LOGGER = LogFactory.getLog(this.getClass().getName());

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody @Valid UserAuth userAuth, HttpServletResponse response, Device device, HttpServletRequest request) {

        final UserDetails userDetails;
        LOGGER.info(userAuth);
        try {
            final Authentication authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(userAuth.getUserName(),
                                    userAuth.getPassword()));
            LOGGER.info(authenticationManager);
            LOGGER.info(authentication);
            SecurityContextHolder.getContext().setAuthentication(authentication);

            userDetails = userDetailsService.loadUserByUsername(userAuth.getUserName());
            LOGGER.info(userDetails.getPassword() + " [get password from userdetail]");

        } catch (AuthenticationException e) {
            ApiError apiError = new ApiError();
            apiError.setUrl(ApiError.getFullURL(request));
            apiError.setStatus(HttpStatus.FORBIDDEN);
            apiError.setCode(HttpStatus.FORBIDDEN.value());
            apiError.setErrors(Arrays.asList(e.getMessage()));
            return new ResponseEntity<>(apiError, apiError.getStatus());
        }

        String jws = jwtService.generateToken(userDetails.getUsername(), device);
        int expiresIn = (int) jwtService.getExpiredIn(device);
        // Add cookie to response
        response.addCookie(this.jwtService.createAuthCookie(jws, expiresIn));
        // Return the token

        UserTokenState userToken = new UserTokenState();
        userToken.setAccessToken(jws);
        userToken.setTokenType(this.paramConfig.getParamConfig(ConfigVariable.JWT_PREFIX));
        userToken.setExpireIn(expiresIn);
        return ResponseEntity.ok(userToken);
    }

    @RequestMapping(value = "/refresh", method = RequestMethod.GET)
    public ResponseEntity<?> refreshAuthenticationToken(HttpServletRequest request, HttpServletResponse response, Device device) {
        final UserDetails userDetails;
        String authToken = jwtService.getToken(request);
        Authentication authentication = authenticationFacade.getAuthentication();
        LOGGER.info("[auth when refresh token:] " + authentication);
        try {
            userDetails = userDetailsService.loadUserByUsername(jwtService.getUserNameFromToKen(authToken));

            LOGGER.info("is valid token " + jwtService.validateToken(authToken, userDetails));
            if (authToken != null && authentication != null && jwtService.validateToken(authToken, userDetails)) {
                LOGGER.info(userDetails.getPassword() + " [get password from userdetail]");
                String jws = jwtService.generateToken(userDetails.getUsername(), device);
                int expiresIn = (int) jwtService.getExpiredIn(device);
                // Add cookie to response
                response.addCookie(this.jwtService.createAuthCookie(jws, expiresIn));
                // Return the token
                UserTokenState userToken = new UserTokenState();
                userToken.setAccessToken(jws);
                userToken.setTokenType(this.paramConfig.getParamConfig(ConfigVariable.JWT_PREFIX));
                userToken.setExpireIn(expiresIn);
                return ResponseEntity.ok(userToken);
            } else {
                ApiError apiError = new ApiError();
                apiError.setUrl(ApiError.getFullURL(request));
                apiError.setStatus(HttpStatus.FORBIDDEN);
                apiError.setCode(HttpStatus.FORBIDDEN.value());
                apiError.setErrors(Arrays.asList("token invalid"));
                return new ResponseEntity<>(apiError, apiError.getStatus());
            }

        } catch (UsernameNotFoundException e) {
            ApiError apiError = new ApiError();
            apiError.setUrl(ApiError.getFullURL(request));
            apiError.setStatus(HttpStatus.FORBIDDEN);
            apiError.setCode(HttpStatus.FORBIDDEN.value());
            apiError.setErrors(Arrays.asList("token invalid", e.getMessage()));
            return new ResponseEntity<>(apiError, apiError.getStatus());
        }
    }

}
