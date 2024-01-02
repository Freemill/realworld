package com.sms.me.realworld.core.domain.user;

import com.sms.me.realworld.core.domain.authentication.TokenManager;
import com.sms.me.realworld.core.domain.user.command.LoginCommand;
import com.sms.me.realworld.core.domain.user.command.SignupCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final TokenManager tokenManager;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public User signup(SignupCommand command) {
        String encryptedPassword = passwordEncoder.encode(command.getPassword());
        UserEntity saved = userRepository.save(command.toEntity(encryptedPassword));
        String token = tokenManager.generateToken(saved.getId());

        return User.of(saved, token);
    }

    public User login(LoginCommand command) {
        UserEntity userEntity = userRepository.findByEmail(command.getEmail());
        if (!passwordEncoder.matches(command.getPassword(), userEntity.getPassword())) {
            throw new IllegalArgumentException("임시 에러");
        }

        String token = tokenManager.generateToken(userEntity.getId());

        return User.of(userEntity, token);
    }


}
