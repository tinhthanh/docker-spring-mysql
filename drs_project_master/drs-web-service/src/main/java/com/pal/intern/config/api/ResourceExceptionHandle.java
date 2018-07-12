package com.pal.intern.config.api;

import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ResourceExceptionHandle {

    @ExceptionHandler(ResourceException.class)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<ApiError> exeptionHandleForUserNotFound(ResourceException e, HttpServletRequest request) {
        ApiError apiError = new ApiError(HttpStatus.NO_CONTENT, HttpStatus.NO_CONTENT.value(), ApiError.getFullURL(request), Arrays.asList(e.getMessage()));
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

}
