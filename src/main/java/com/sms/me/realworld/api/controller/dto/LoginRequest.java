package com.sms.me.realworld.api.controller.dto;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.sms.me.realworld.core.domain.user.command.LoginCommand;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
@JsonTypeName("user")
@Getter
public class LoginRequest {

    @Email
    private String email;

    @Size(min = 8, max = 32)
    private String password;


    public LoginCommand toCommand() {
        return LoginCommand.builder()
                .email(email)
                .password(password)
                .build();
    }
}
