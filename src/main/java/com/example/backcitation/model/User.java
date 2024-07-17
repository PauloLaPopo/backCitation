package com.example.backcitation.model;

import com.example.backcitation.utils.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "user_id", length = 255)
    private String userId;

    @Column(name = "user_name", length = 255)
    private String userName;

    @Column(name = "email", length = 255)
    private String email;

    @Column(name = "password", length = 255)
    private String password;

    @Column(name = "role", length = 255)
    private Role role;

    public User() {}

    public User(String userName, String email, String password, Role role) {
        this.userId = UUID.randomUUID().toString();
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }
}
