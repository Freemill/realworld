package com.sms.me.realworld.core.domain.user.command;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SignupCommand {

    private String email;
    private String password;


}
