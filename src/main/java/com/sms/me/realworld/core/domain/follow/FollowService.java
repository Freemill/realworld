package com.sms.me.realworld.core.domain.follow;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FollowService {

    private final FollowRepository followRepository;

    @Transactional
    public void follow(Long followingId, Long followerId) {
        FollowEntity followEntity = new FollowEntity(followingId, followerId);
        followRepository.save(followEntity);
    }

    @Transactional
    public void unfollow(Long followingId, Long followerId) {
        followRepository.deleteByFollowingIdAndFollowerId(followingId, followerId);
    }

    public boolean isFollowing(Long followingId, Long followerId) {
        return followRepository.existsByFollowingIdAndFollowerId(followingId, followerId);
    }
}
