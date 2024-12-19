package com.thecodeschool.security.model;

public class AuthErrorResponse implements AuthResponse {

    private String errorMessage;

    public AuthErrorResponse() {}

    public AuthErrorResponse(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
