package com.pal.intern.config.api;

public class ResourceException extends Exception {

    private String message;

    public ResourceException(String message) {
        super(message);
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

}
