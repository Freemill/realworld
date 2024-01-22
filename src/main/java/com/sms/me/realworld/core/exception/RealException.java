package com.sms.me.realworld.core.exception;

import lombok.Getter;


@Getter
public class RealException extends RuntimeException {
    private final ErrorType errorType;
    private final String message;

    public RealException(ErrorType errorType) {
        this.errorType = errorType;
        this.message = errorType.getMessage();
    }

    public RealException(ErrorType errorType, String message) {
        this.errorType = errorType;
        this.message = message;
    }
}
