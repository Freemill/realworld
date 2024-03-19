package com.sms.me.realworld.core.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorType {
    BAD_REQUEST("REAL-ERR-10400", HttpStatus.BAD_REQUEST, "잘못된 요청입니다."),
    NOT_FOUND("REAL-ERR-10404", HttpStatus.NOT_FOUND, "리소스를 찾을 수 없습니다."),
    FORBIDDEN("REAL-ERR-10403", HttpStatus.FORBIDDEN, "권한이 없습니다."),
    USER_NOT_FOUND("REAL-ERR-11404", HttpStatus.NOT_FOUND, "유저를 찾을 수 없습니다."),
    SLUG_NOT_FOUND("REAL-ERR-11405", HttpStatus.NOT_FOUND, "슬러그를 찾을 수 없습니다."),
    INTERNAL_SERVER_ERROR("REAL-ERR-19500", HttpStatus.INTERNAL_SERVER_ERROR, "일시적인 오류가 발생했습니다.");

    private final String code;
    private final HttpStatus status;
    private final String message;

    ErrorType(String code, HttpStatus status, String message) {
        this.code = code;
        this.status = status;
        this.message = message;
    }
}
