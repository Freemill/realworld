package com.sms.me.realworld.api.controller.dto;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.sms.me.realworld.core.domain.user.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@JsonTypeName("user")
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class LoginResponse {

    private String email;
    private String token;
    private String username;
    private String bio;
    private String image;

    public static LoginResponse of(User user) {
        return LoginResponse.builder()
                .email(user.getEmail())
                .token(user.getToken())
                .username(user.getUsername())
                .bio(user.getBio())
                .image(user.getImage())
                .build();
    }
}
