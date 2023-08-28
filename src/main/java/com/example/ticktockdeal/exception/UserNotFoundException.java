package com.example.ticktockdeal.exception;

public class UserNotFoundException extends IllegalArgumentException {

    public UserNotFoundException(String message) {
        super(message);
    }
}
