package com.sms.me.realworld.core.domain.user;

import com.sms.me.realworld.core.exception.ErrorType;
import com.sms.me.realworld.core.exception.RealException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserQueryService {

    private final UserRepository userRepository;

    public User getUserOrThrow(Long userId) {
        UserEntity entity = userRepository.findById(userId).orElseThrow(() -> new RealException(ErrorType.USER_NOT_FOUND));
        return User.of(entity, null);
    }

    public User getUserOrThrow(String username) {
        UserEntity entity = userRepository.findByUsername(username).orElseThrow(() -> new RealException(ErrorType.USER_NOT_FOUND));
        return User.of(entity, null);
    }

}
