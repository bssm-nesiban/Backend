package com.caring.caring.exception;

import org.springframework.http.HttpStatus;

public class MemberException extends GeneralException {
    private String message;

    public MemberException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
