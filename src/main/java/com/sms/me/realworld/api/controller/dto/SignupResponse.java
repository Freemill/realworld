package com.sms.me.realworld.api.controller.dto;

import com.sms.me.realworld.core.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignupResponse {

    private Long userId;
    private String email;

    public static SignupResponse of(User user) {
        return new SignupResponse(user.getId(), user.getEmail());
    }
}
