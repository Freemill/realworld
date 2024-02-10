package com.sms.me.realworld.core.domain.follow;

import com.sms.me.realworld.core.domain.user.UserEntity;
import com.sms.me.realworld.core.domain.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class FollowServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FollowRepository followRepository;
    @Autowired
    private FollowService sut;


    @Test
    void follow() {
        //given
        Long followingId = userRepository.save(userEntity("test1@test.com")).getId();
        Long followerId = userRepository.save(userEntity("test2@test.com")).getId();
        sut.follow(followingId, followerId);

        //then
        assertTrue(followRepository.existsByFollowingIdAndFollowerId(followingId, followerId));

    }

    @Test
    void unfollow() {
    }

    private UserEntity userEntity(String email) {
        return UserEntity.builder()
                .email(email)
                .password("random")
                .username("username")
                .build();
    }
}