package com.sms.me.realworld.core.domain.user;

import com.sms.me.realworld.core.domain.user.command.LoginCommand;
import com.sms.me.realworld.core.domain.user.command.SignupCommand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@Transactional
class UserServiceTest {

    @Autowired
    private UserService sut;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;


    @Test
    void signup() {
        //given
        SignupCommand command = SignupCommand.builder()
                .email("test3@naver.com")
                .password("password")
                .username("username")
                .build();

        //when
        User user = sut.signup(command);

        //then
        assertEquals("test3@naver.com", user.getEmail());
        assertEquals("username", user.getUsername());

    }

    @Test
    void login() {
        //given
        UserEntity userEntity = UserEntity.builder()
                .email("test@test.com")
                .password(passwordEncoder.encode("password"))
                .username("tester")
                .build();
        UserEntity saved = userRepository.save(userEntity);

        //when
        LoginCommand command = LoginCommand.builder()
                .email("test@test.com")
                .password("password")
                .build();
        User user = sut.login(command);

        //then
        assertEquals("test@test.com", user.getEmail());
        assertEquals("tester", user.getUsername());

    }

}