package com.example.backcitation.exception;

public class CitationNotFoundException extends RuntimeException {
    public CitationNotFoundException(String message) {
        super(message);
    }
}
