package com.sms.me.realworld.api.docs;

import com.sms.me.realworld.api.controller.dto.*;
import com.sms.me.realworld.api.security.AuthUserDetails;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "user", description = "User API")
public interface UserApiSpec {

    @Operation(summary = "회원가입")
    SignupResponse signup(SignupRequest request);

    @Operation(summary = "로그인")
    LoginResponse login(LoginRequest request, AuthUserDetails userDetails);

    @Operation(summary = "로그인 유저 조회")
    UserResponse getUser(AuthUserDetails userDetails);

    @Operation(summary = "로그인 유저 수정")
    public UserResponse updateUser(AuthUserDetails userDetails, UserUpdateRequest request);

}
