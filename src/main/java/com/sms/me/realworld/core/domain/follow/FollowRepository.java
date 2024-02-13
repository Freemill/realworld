package com.sms.me.realworld.core.domain.follow;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowRepository extends JpaRepository<FollowEntity, Long> {

    void deleteByFollowingIdAndFollowerId(Long followingId, Long followerId);

    boolean existsByFollowingIdAndFollowerId(Long followingId, Long followerId);

}
