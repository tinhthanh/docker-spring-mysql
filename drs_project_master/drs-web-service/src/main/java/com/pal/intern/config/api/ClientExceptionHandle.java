package com.pal.intern.config.api;

import java.nio.file.AccessDeniedException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class ClientExceptionHandle {

    @ExceptionHandler({HttpClientErrorException.class})
    public ResponseEntity<ApiError> exceptionHandlerForClinetError(HttpClientErrorException e, HttpServletRequest request) {
        ApiError apiError = new ApiError(e.getStatusCode(), e.getStatusCode().value(), ApiError.getFullURL(request), Arrays.asList(e.getMessage()));
        return new ResponseEntity<>(apiError, apiError.getStatus());

    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiError> exceptionHandlerForBadRequest(HttpMessageNotReadableException e, HttpServletRequest request) {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(), ApiError.getFullURL(request), Arrays.asList(e.getMessage()));
        return new ResponseEntity<>(apiError, apiError.getStatus());

    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public ResponseEntity<ApiError> exceptionHandlerForMethodNoTAllowed(HttpRequestMethodNotSupportedException e, HttpServletRequest request) {

        ApiError apiError = new ApiError(HttpStatus.METHOD_NOT_ALLOWED, HttpStatus.METHOD_NOT_ALLOWED.value(), ApiError.getFullURL(request), Arrays.asList(e.getMessage()));
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseEntity<ApiError> exceptionHandlerForNoHandleFound(AccessDeniedException e, HttpServletRequest request) {
        ApiError apiError = new ApiError(HttpStatus.FORBIDDEN, HttpStatus.FORBIDDEN.value(), ApiError.getFullURL(request), Arrays.asList(e.getMessage()));
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    @ExceptionHandler({NoHandlerFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ApiError> exceptionHandlerForNoHandleFound(NoHandlerFoundException e, HttpServletRequest request) {
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(), ApiError.getFullURL(request), Arrays.asList(e.getMessage()));
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiError> exceptionHandlerForArgument(MethodArgumentNotValidException e, HttpServletRequest request) {
        BindingResult bindingResult = e.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        List<String> errorMessage = new LinkedList<>();
        fieldErrors.forEach(error -> {
            errorMessage.add(error.getDefaultMessage());
        });
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(), ApiError.getFullURL(request), errorMessage);
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

}
