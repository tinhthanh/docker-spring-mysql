package com.pal.intern.config.api;

import com.taskadapter.redmineapi.RedmineException;
import io.jsonwebtoken.JwtException;
import java.rmi.ServerException;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException;

@RestControllerAdvice
public class ServerExeptionHandle {

    @ExceptionHandler({HttpServerErrorException.class, ServerException.class})
    public ResponseEntity<ApiError> exceptionHandlerForServerError(HttpServerErrorException e, HttpServletRequest request) {
        ApiError apiError = new ApiError(e.getStatusCode(), e.getStatusCode().value(), ApiError.getFullURL(request), Arrays.asList(e.getMessage()));
        return new ResponseEntity<>(apiError, apiError.getStatus());

    }

    @ExceptionHandler({ServletException.class})
    public ResponseEntity<ApiError> exceptionHandlerForServletError(ServletException e, HttpServletRequest request) {
//        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        ApiError apiError = new ApiError(httpStatus, httpStatus.value(), ApiError.getFullURL(request), Arrays.asList(e.getMessage()));
        return new ResponseEntity<>(apiError, apiError.getStatus());

    }

    @ExceptionHandler(RedmineException.class)
    public ResponseEntity<ApiError> exceptionHandlerForRedmine(RedmineException e, HttpServletRequest request) {
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        ApiError apiError = new ApiError(httpStatus, httpStatus.value(), ApiError.getFullURL(request), Arrays.asList(e.getMessage()));
        return new ResponseEntity<>(apiError, apiError.getStatus());

    }

    @ExceptionHandler(JwtException.class)
    public ResponseEntity<ApiError> exceptionHandlerForJwtExeption(JwtException e, HttpServletRequest request) {
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        ApiError apiError = new ApiError(httpStatus, httpStatus.value(), ApiError.getFullURL(request), Arrays.asList(e.getMessage()));
        return new ResponseEntity<>(apiError, apiError.getStatus());

    }

}
