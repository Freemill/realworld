package com.sms.me.realworld.core.domain.user.command;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserUpdateCommand {
    private String email;
    private String username;
    private String password;
    private String bio;
    private String image;

}
