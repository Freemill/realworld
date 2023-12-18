package com.sms.me.realworld.api.controller.dto;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.sms.me.realworld.core.domain.user.command.SignupCommand;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
@JsonTypeName("user")
public class SignupRequest {

    @Email
    private String email;

    @Size(min = 8, max = 32)
    private String password;

    @Size(min = 2, max = 20)
    private String username;


    public SignupCommand toCommand() {
        return SignupCommand.builder()
                .email(email)
                .password(password)
                .username(username)
                .build();
    }
}
