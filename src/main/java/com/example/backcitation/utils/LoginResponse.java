package com.example.backcitation.utils;

import com.example.backcitation.model.RoleEnum;

public class LoginResponse {
    private String token;

    private RoleEnum role;

    private long expiresIn;

    public LoginResponse() {}

    public LoginResponse(String token, RoleEnum role, long expiresIn) {
        this.token = token;
        this.role = role;
        this.expiresIn = expiresIn;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }

    public void setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getToken() {
        return token;
    }

    public RoleEnum getRole() {
        return role;
    }

    public long getExpiresIn() {
        return expiresIn;
    }
}