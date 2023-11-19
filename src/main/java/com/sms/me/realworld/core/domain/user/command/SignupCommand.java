package com.sms.me.realworld.core.domain.user.command;

import com.sms.me.realworld.core.domain.user.UserEntity;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SignupCommand {

    private String email;
    private String password;


    public UserEntity toEntity(){
        return UserEntity.builder()
                .email(email)
                .password(password)
                .build();
    }
}
