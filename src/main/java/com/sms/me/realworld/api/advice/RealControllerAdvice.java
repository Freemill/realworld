package com.sms.me.realworld.api.advice;

import com.sms.me.realworld.core.exception.ErrorType;
import com.sms.me.realworld.core.exception.RealException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
@Slf4j
public class RealControllerAdvice {

    @ExceptionHandler(RealException.class)
    public ResponseEntity<RealErrorResponse> realExceptionHandler(RealException e) {
        ErrorType errorType = e.getErrorType();
        return ResponseEntity.status(errorType.getStatus()).body(new RealErrorResponse(errorType));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<RealErrorResponse> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        List<String> messages = e.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList();
        return ResponseEntity.badRequest().body(new RealErrorResponse(ErrorType.BAD_REQUEST.getCode(), messages.toString()));
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<RealErrorResponse> exceptionHandler(Exception e) {
        log.error("message: {}", e.getMessage(), e);
        return ResponseEntity.internalServerError().body(new RealErrorResponse(ErrorType.INTERNAL_SERVER_ERROR));
    }

}
