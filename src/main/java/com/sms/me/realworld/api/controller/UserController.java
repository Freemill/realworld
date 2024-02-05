package com.sms.me.realworld.api.controller;

import com.sms.me.realworld.api.controller.dto.*;
import com.sms.me.realworld.api.docs.UserApiSpec;
import com.sms.me.realworld.api.security.AuthUserDetails;
import com.sms.me.realworld.core.domain.user.User;
import com.sms.me.realworld.core.domain.user.UserQueryService;
import com.sms.me.realworld.core.domain.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Slf4j
public class UserController implements UserApiSpec {

    private final UserService userService;
    private final UserQueryService userQueryService;


    @PostMapping
    @PreAuthorize("hasRole('NO_AUTH')")
    public SignupResponse signup(
            @RequestBody @Valid SignupRequest request
    ) {
        User user = userService.signup(request.toCommand());
        return SignupResponse.of(user);
    }

    @PostMapping("/login")
    @PreAuthorize("hasRole('NO_AUTH')")
    public LoginResponse login(
            @RequestBody @Valid LoginRequest request,
            @AuthenticationPrincipal AuthUserDetails userDetails
    ) {
        User user = userService.login(request.toCommand());
        return LoginResponse.of(user);
    }

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public UserResponse getUser(
            @AuthenticationPrincipal AuthUserDetails userDetails
    ) {
        Long userId = userDetails.userId;
        User user = userQueryService.getUserOrThrow(userId);

        return UserResponse.of(user);
    }

    @PutMapping
    @PreAuthorize("hasRole('USER')")
    public UserResponse updateUser(
            @AuthenticationPrincipal AuthUserDetails userDetails,
            @RequestBody @Valid UserUpdateRequest request
    ) {
        User user = userService.updateUser(userDetails.userId, request.toCommand());

        return UserResponse.of(user);
    }


}
