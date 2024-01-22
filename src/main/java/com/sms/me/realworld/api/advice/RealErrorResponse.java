package com.sms.me.realworld.api.advice;

import com.sms.me.realworld.core.exception.ErrorType;
import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class RealErrorResponse {

    private String code;
    private String message;

    public RealErrorResponse(ErrorType errorType) {
        this.code = errorType.getCode();
        this.message = errorType.getMessage();
    }
}
