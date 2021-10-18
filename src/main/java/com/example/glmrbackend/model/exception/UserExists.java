package com.example.glmrbackend.model.exception;

public class UserExists extends RuntimeException{
    public UserExists(String message) {
        super(message);
    }
}
