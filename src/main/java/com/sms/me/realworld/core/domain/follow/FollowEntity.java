package com.sms.me.realworld.core.domain.follow;

import com.sms.me.realworld.core.domain.common.AuditableEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "follows")
public class FollowEntity extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, updatable = false)
    private Long followingId;
    @Column(nullable = false, updatable = false)
    private Long followerId;

    public FollowEntity(Long followingId, Long followerId) {
        this.followingId = followingId;
        this.followerId = followerId;
    }
}
