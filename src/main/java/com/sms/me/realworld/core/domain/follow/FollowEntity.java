package com.sms.me.realworld.core.domain.follow;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "follows")
public class FollowEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long followingId;
    @Column(nullable = false)
    private Long followerId;

    public FollowEntity(Long followingId, Long followerId) {
        this.followingId = followingId;
        this.followerId = followerId;
    }
}
