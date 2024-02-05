package com.sms.me.realworld.api.controller.dto;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.sms.me.realworld.core.domain.user.command.UserUpdateCommand;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
@JsonTypeName("user")
@Getter
public class UserUpdateRequest {

    @Email
    private String email;

    @Size(min = 2, max = 20)
    private String username;

    @Size(min = 8, max = 32)
    private String password;
    private String image;
    private String bio;


    public UserUpdateCommand toCommand() {
        return UserUpdateCommand.builder()
                .email(email)
                .username(username)
                .password(password)
                .bio(bio)
                .image(image)
                .build();
    }
}
