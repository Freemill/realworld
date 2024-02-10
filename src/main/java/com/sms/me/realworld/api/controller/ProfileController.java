package com.sms.me.realworld.api.controller;

import com.sms.me.realworld.api.controller.dto.ProfileResponse;
import com.sms.me.realworld.api.security.AuthUserDetails;
import com.sms.me.realworld.core.domain.profile.Profile;
import com.sms.me.realworld.core.domain.profile.ProfileFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profiles")
@RequiredArgsConstructor
@Slf4j
public class ProfileController {

    private final ProfileFacade profileFacade;

    @GetMapping("/{username}")
    public ProfileResponse getProfile(
            @AuthenticationPrincipal AuthUserDetails userDetails,
            @PathVariable String username
    ) {
        Long userId = userDetails.userId;
        Profile profile = profileFacade.getProfile(userId, username);

        return ProfileResponse.of(profile);
    }

    @PostMapping("/{username}/follow")
    public ProfileResponse follow(
            @AuthenticationPrincipal AuthUserDetails userDetails,
            @PathVariable String username
    ) {
        Long userId = userDetails.userId;
        Profile profile = profileFacade.follow(userId, username);

        return ProfileResponse.of(profile);
    }

    @DeleteMapping("/{username}/follow")
    public ProfileResponse unfollow(
            @AuthenticationPrincipal AuthUserDetails userDetails,
            @PathVariable String username
    ) {
        Long userId = userDetails.userId;
        Profile profile = profileFacade.unfollow(userId, username);

        return ProfileResponse.of(profile);
    }
}
