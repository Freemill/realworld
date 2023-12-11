package com.sms.me.realworld.core.domain.user;

import com.sms.me.realworld.core.domain.authentication.TokenManager;
import com.sms.me.realworld.core.domain.user.command.SignupCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final TokenManager tokenManager;

    public User signup(SignupCommand command) {
        UserEntity saved = userRepository.save(command.toEntity());
        String token = tokenManager.generateToken(saved.getId());

        return User.of(saved, token);

    }


}
