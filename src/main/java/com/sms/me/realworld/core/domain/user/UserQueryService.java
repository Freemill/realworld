package com.sms.me.realworld.core.domain.user;

import com.sms.me.realworld.core.cache.CacheSpec;
import com.sms.me.realworld.core.cache.CommonRedisTemplate;
import com.sms.me.realworld.core.exception.ErrorType;
import com.sms.me.realworld.core.exception.RealException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserQueryService {

    private final UserRepository userRepository;
    private final CommonRedisTemplate redisTemplate;

    public User getUserOrThrow(Long userId) {
        User user = redisTemplate.get(userId, CacheSpec.USER_BY_ID);
        if (user != null) {
            return user;
        }

        UserEntity entity = userRepository.findById(userId).orElseThrow(() -> new RealException(ErrorType.USER_NOT_FOUND));
        return redisTemplate.set(userId, User.of(entity, null), CacheSpec.USER_BY_ID);
    }

    public User getUserOrThrow(String username) {
        User user = redisTemplate.get(username, CacheSpec.USER_BY_USERNAME);
        if (user != null) {
            return user;
        }

        UserEntity entity = userRepository.findByUsername(username).orElseThrow(() -> new RealException(ErrorType.USER_NOT_FOUND));
        return redisTemplate.set(username, User.of(entity, null), CacheSpec.USER_BY_USERNAME);
    }

}
