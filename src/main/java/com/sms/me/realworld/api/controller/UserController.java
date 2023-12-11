package com.sms.me.realworld.api.controller;

import com.sms.me.realworld.api.controller.dto.SignupRequest;
import com.sms.me.realworld.api.controller.dto.SignupResponse;
import com.sms.me.realworld.core.domain.user.User;
import com.sms.me.realworld.core.domain.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping
    @PreAuthorize("hasRole('NO_AUTH')")
    public SignupResponse signup(
            @RequestBody @Valid SignupRequest request
    ) {
        User user = userService.signup(request.toCommand());
        return SignupResponse.of(user);
    }
}
