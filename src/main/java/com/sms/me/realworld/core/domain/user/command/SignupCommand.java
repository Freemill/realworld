package com.sms.me.realworld.core.domain.user.command;

import com.sms.me.realworld.core.domain.user.UserEntity;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SignupCommand {

    private String email;
    private String password;
    private String username;


    public UserEntity toEntity(String encryptedPassword) {
        return UserEntity.builder()
                .email(email)
                .password(encryptedPassword)
                .username(username)
                .build();
    }

}
