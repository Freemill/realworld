package com.sms.me.realworld.api.controller.dto;

import com.sms.me.realworld.core.domain.user.command.SignupCommand;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class SignupRequest {

    @Email
    private String email;

    @Size(min = 8, max = 32)
    private String password;


    public SignupCommand toCommand() {
        return SignupCommand.builder()
                .email(email)
                .password(password)
                .build();
    }
}
