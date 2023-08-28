package com.example.ticktockdeal.exception;

public class PasswordNotMatchedException extends IllegalArgumentException {

    public PasswordNotMatchedException(String message) {
        super(message);
    }
}
