package com.example.backcitation.dto;

public class AuthorRequest {
    private String author;

    public AuthorRequest() {
    }

    public AuthorRequest(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
