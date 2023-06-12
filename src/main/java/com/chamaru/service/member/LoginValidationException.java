package com.chamaru.service.member;

public class LoginValidationException extends RuntimeException {

    private String field;

    public LoginValidationException(String field, String message) {
        super(message);
        this.field = field;
    }

    public String getField() {
        return field;
    }
}