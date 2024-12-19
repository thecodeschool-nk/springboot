package com.thecodeschool.security.model;

public class AuthSuccessResponse implements AuthResponse {

    private String token;

    public AuthSuccessResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
