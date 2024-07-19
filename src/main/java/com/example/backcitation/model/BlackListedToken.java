package com.example.backcitation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "blacklisted_tokens")
public class BlackListedToken {
    @Id
    private String token;

    private LocalDateTime invalidatedAt;

    public BlackListedToken() {
    }

    public BlackListedToken(String token, LocalDateTime invalidatedAt) {
        this.token = token;
        this.invalidatedAt = invalidatedAt;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDateTime getInvalidatedAt() {
        return invalidatedAt;
    }

    public void setInvalidatedAt(LocalDateTime invalidatedAt) {
        this.invalidatedAt = invalidatedAt;
    }
}