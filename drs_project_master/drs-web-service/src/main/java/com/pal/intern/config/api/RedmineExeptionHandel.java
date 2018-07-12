package com.pal.intern.config.api;

import com.taskadapter.redmineapi.RedmineException;
import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RedmineExeptionHandel {
    
    @ExceptionHandler(RedmineException.class)
     public ResponseEntity<ApiError> exceptionHandlerForRedmine(RedmineException e, HttpServletRequest request) {
        ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value(), ApiError.getFullURL(request), Arrays.asList(e.getMessage()));
        return new ResponseEntity<>(apiError, apiError.getStatus());

    }

}
