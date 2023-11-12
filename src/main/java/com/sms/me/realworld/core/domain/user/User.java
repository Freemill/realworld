package com.sms.me.realworld.core.domain.user;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class User {

    private Long id;
    private String email;


}
