package com.sms.me.realworld.api.controller;

import com.sms.me.realworld.api.controller.dto.SignupRequest;
import com.sms.me.realworld.api.controller.dto.SignupResponse;
import com.sms.me.realworld.core.domain.user.User;
import com.sms.me.realworld.core.domain.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public SignupResponse signup(@RequestBody @Valid SignupRequest request) {
        User user = userService.signup(request.toCommand());
        return SignupResponse.of(user);
    }
}
