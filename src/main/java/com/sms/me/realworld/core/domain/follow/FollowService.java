package com.sms.me.realworld.core.domain.follow;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FollowService {

    private final FollowRepository followRepository;

    public void follow(Long followingId, Long followerId) {
        FollowEntity followEntity = new FollowEntity(followingId, followerId);
        followRepository.save(followEntity);
    }

    public void unfollow(Long followingId, Long followerId) {
        followRepository.deleteByFollowingIdAndFollowerId(followingId, followerId);
    }

    public boolean isFollowing(Long followingId, Long followerId) {
        return followRepository.existsByFollowingIdAndFollowerId(followingId, followerId);
    }
}
