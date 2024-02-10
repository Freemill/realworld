package com.sms.me.realworld.api.controller.dto;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.sms.me.realworld.core.domain.profile.Profile;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@JsonTypeName("profile")
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ProfileResponse {

    private String username;
    private String bio;
    private String image;
    private boolean follow;

    public static ProfileResponse of(Profile profile) {
        return ProfileResponse.builder()
                .username(profile.getUsername())
                .bio(profile.getBio())
                .image(profile.getImage())
                .follow(profile.isFollow())
                .build();
    }
}
