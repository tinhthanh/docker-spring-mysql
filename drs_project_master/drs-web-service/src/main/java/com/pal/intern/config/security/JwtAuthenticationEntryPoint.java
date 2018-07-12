package com.pal.intern.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pal.intern.config.api.ApiError;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        ApiError apiError = new ApiError();
        apiError.setStatus(HttpStatus.UNAUTHORIZED);
        
        apiError.setUrl(ApiError.getFullURL(request));
        apiError.setCode(HttpStatus.UNAUTHORIZED.value());
        apiError.setErrors(Arrays.asList(authException.getMessage()));
        /**
         * convert object to JSON String using JACKSON lib
         */
        ObjectMapper mapper = new ObjectMapper();
        String jsonObject = mapper.writeValueAsString(apiError);
        
        response.getOutputStream().println(jsonObject);

    }

}
