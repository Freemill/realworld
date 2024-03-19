package com.sms.me.realworld.core.domain.profile;

import com.sms.me.realworld.core.domain.follow.FollowService;
import com.sms.me.realworld.core.domain.user.User;
import com.sms.me.realworld.core.domain.user.UserQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProfileFacade {
    private final UserQueryService userQueryService;
    private final FollowService followService;

    public Profile getProfile(Long userId, Long targetUserId) {
        User user = userQueryService.getUserOrThrow(userId);
        if (Objects.equals(userId, targetUserId)) {
            return Profile.of(user, false);
        }

        boolean following = followService.isFollowing(userId, targetUserId);
        return Profile.of(user, following);
    }

    public Profile getProfile(Long userId, String targetUsername) {
        User targetUser = userQueryService.getUserOrThrow(targetUsername);
        boolean following = followService.isFollowing(userId, targetUser.getId());
        return Profile.of(targetUser, following);
    }

    public Profile follow(Long userId, String targetUsername) {
        User targetUser = userQueryService.getUserOrThrow(targetUsername);
        followService.follow(userId, targetUser.getId());
        return Profile.of(targetUser, true);
    }

    public Profile unfollow(Long userId, String targetUsername) {
        User targetUser = userQueryService.getUserOrThrow(targetUsername);
        followService.unfollow(userId, targetUser.getId());
        return Profile.of(targetUser, false);
    }
}
