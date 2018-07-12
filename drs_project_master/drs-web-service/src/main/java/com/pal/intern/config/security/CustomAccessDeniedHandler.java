package com.pal.intern.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pal.intern.config.api.ApiError;
import java.io.IOException;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    public CustomAccessDeniedHandler() {
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {

        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        ApiError apiError = new ApiError();
        apiError.setStatus(HttpStatus.FORBIDDEN);

        apiError.setUrl(apiError.getFullURL(request));
        apiError.setCode(HttpStatus.FORBIDDEN.value());
        apiError.setErrors(Arrays.asList(accessDeniedException.getMessage()));
        /**
         * convert object to json String using JACKSON lib
         */
        ObjectMapper mapper = new ObjectMapper();
        String jsonObject = mapper.writeValueAsString(apiError);

        response.getOutputStream().println(jsonObject);
    }

}
