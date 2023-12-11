package com.sms.me.realworld.api.controller.dto;

import com.sms.me.realworld.core.domain.user.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SignupResponse {

    private String email;
    private String token;
    private String username;
    private String bio;
    private String image;

    public static SignupResponse of(User user) {
        return SignupResponse.builder()
                .email(user.getEmail())
                .token(user.getToken())
                .username(user.getUsername())
                .bio(user.getBio())
                .image(user.getImage())
                .build();
    }
}
