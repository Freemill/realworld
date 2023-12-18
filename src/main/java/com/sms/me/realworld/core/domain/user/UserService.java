package com.sms.me.realworld.core.domain.user;

import com.sms.me.realworld.core.domain.authentication.TokenManager;
import com.sms.me.realworld.core.domain.user.command.SignupCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final TokenManager tokenManager;
    private final PasswordEncoder passwordEncoder;

    public User signup(SignupCommand command) {
        String encryptedPassword = passwordEncoder.encode(command.getPassword());
        UserEntity saved = userRepository.save(command.toEntity(encryptedPassword));
        String token = tokenManager.generateToken(saved.getId());

        return User.of(saved, token);

    }


}
