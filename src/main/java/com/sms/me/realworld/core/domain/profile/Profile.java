package com.sms.me.realworld.core.domain.profile;


import com.sms.me.realworld.core.domain.user.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Profile {
    private String username;
    private String bio;
    private String image;
    private boolean follow;

    public static Profile of(User user, boolean follow) {
        return Profile.builder()
                .username(user.getUsername())
                .bio(user.getBio())
                .image(user.getImage())
                .follow(follow)
                .build();
    }
}
