package com.sms.me.realworld.core.domain.profile;

import com.sms.me.realworld.core.domain.follow.FollowService;
import com.sms.me.realworld.core.domain.user.User;
import com.sms.me.realworld.core.domain.user.UserQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileFacade {
    private final UserQueryService userQueryService;
    private final FollowService followService;

    public Profile getProfile(Long followingId, String targetUsername) {
        User targetUser = userQueryService.getUserOrThrow(targetUsername);
        boolean follow = followService.isFollowing(followingId, targetUser.getId());
        return Profile.of(targetUser, follow);
    }

    public Profile follow(Long followingId, String targetUsername) {
        User targetUser = userQueryService.getUserOrThrow(targetUsername);
        followService.follow(followingId, targetUser.getId());
        return Profile.of(targetUser, true);
    }

}
