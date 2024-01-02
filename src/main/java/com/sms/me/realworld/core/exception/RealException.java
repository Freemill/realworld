package com.sms.me.realworld.core.exception;

import lombok.Getter;

import javax.lang.model.type.ErrorType;

@Getter
public class RealException extends RuntimeException {
    private ErrorType errorType;
    private String message;

    public RealException(String message) {
        super(message);
        this.message = message;
    }
}
