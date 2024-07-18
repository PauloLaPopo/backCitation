package com.example.backcitation.utils;

public class LoginMessage {
    String message;
    Boolean status;
    String token;

    public String getMessage() {
        return message;
    }

    public Boolean getStatus() {
        return status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public LoginMessage(String message, Boolean status) {
        this.message = message;
        this.status = status;
    }

    public LoginMessage(String message, Boolean status, String token) {
        this.message = message;
        this.status = status;
        this.token = token;
    }
}
