package com.sms.me.realworld.core.domain.user;

import com.sms.me.realworld.core.domain.user.command.SignupCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User signup(SignupCommand command){

        return User.of(userRepository.save(command.toEntity()));

    }


}
