package com.sms.me.realworld.core.domain.user;

import com.sms.me.realworld.core.domain.authentication.TokenManager;
import com.sms.me.realworld.core.domain.user.command.LoginCommand;
import com.sms.me.realworld.core.domain.user.command.SignupCommand;
import com.sms.me.realworld.core.domain.user.command.UserUpdateCommand;
import com.sms.me.realworld.core.exception.ErrorType;
import com.sms.me.realworld.core.exception.RealException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

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


    @Transactional
    public User updateUser(Long userId, UserUpdateCommand command) {
        UserEntity userEntity = userRepository.findByEmail(command.getEmail());

        if (!Objects.equals(userEntity.getId(), userId)) {
            throw new RealException(ErrorType.FORBIDDEN);
        }

        String encryptedPassword = passwordEncoder.encode(command.getPassword());
        userEntity = userEntity.update(command.getEmail(), command.getUsername(), encryptedPassword, command.getBio(), command.getImage());

        return User.of(userEntity, null);
    }
}
