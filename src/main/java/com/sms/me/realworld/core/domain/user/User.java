package com.sms.me.realworld.core.domain.user;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class User {

    private Long id;
    private String email;
    private String token;
    private String username;
    private String bio;
    private String image;


    //정적 factory method
    public static User of(UserEntity entity, String token) {
        return User.builder()
                .id(entity.getId())
                .email(entity.getEmail())
                .token(token)
                .username(entity.getUsername())
                .bio(entity.getBio())
                .image(entity.getImage())
                .build();
    }


}
