package com.pal.intern.config.api;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;

public class ApiError {

    private HttpStatus status;
    private int code;
    private String timestamp;
    private String url;
    private List<String> errors;

    public ApiError() {
        /**
         * times issue error
         */
        DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS Z");
        timestamp = ZonedDateTime.now().format(FORMATTER);
    }

    public ApiError(HttpStatus status, int code, String url, List<String> errors) {
        this.status = status;
        this.code = code;
        this.url = url;
        this.errors = errors;

        DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS Z");
        timestamp = ZonedDateTime.now().format(FORMATTER);
    }

    public ApiError(int code, String url, List<String> errors) {
        this.code = code;
        this.url = url;
        this.errors = errors;
        DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS Z");
        timestamp = ZonedDateTime.now().format(FORMATTER);
    }

    public ApiError(HttpStatus status, int code, String timestamp, String url, List<String> errors) {
        this.status = status;
        this.code = code;
        this.timestamp = timestamp;
        this.url = url;
        this.errors = errors;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "ApiError{" + "status=" + status + ", code=" + code + ", timestamp=" + timestamp + ", url=" + url + ", errors=" + errors + '}';
    }

    /**
     * get full URL request
     *
     * @param request HttpServletRequest
     * @return String URL request
     */
    public static String getFullURL(HttpServletRequest request) {
        StringBuffer requestURL = request.getRequestURL();
        String queryString = request.getQueryString();

        if (queryString == null) {
            return requestURL.toString();
        } else {
            return requestURL.append('?').append(queryString).toString();
        }
    }
}
