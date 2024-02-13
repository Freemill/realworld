package com.sms.me.realworld.api.docs;

import com.sms.me.realworld.api.controller.dto.ProfileResponse;
import com.sms.me.realworld.api.security.AuthUserDetails;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "profile", description = "Profile API")
public interface ProfileApiSpec {

    @Operation(summary = "프로필 조회")
    ProfileResponse getProfile(AuthUserDetails userDetails, String username);

    @Operation(summary = "팔로우")
    ProfileResponse follow(AuthUserDetails userDetails, String username);

    @Operation(summary = "언팔로우")
    ProfileResponse unfollow(AuthUserDetails userDetails, String username);

}
