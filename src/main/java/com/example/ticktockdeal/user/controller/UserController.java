package com.example.ticktockdeal.user.controller;

import com.example.ticktockdeal.core.domain.User;
import com.example.ticktockdeal.user.dto.JoinRequest;
import com.example.ticktockdeal.user.dto.LoginRequest;
import com.example.ticktockdeal.user.response.UserResponse;
import com.example.ticktockdeal.user.service.SessionService;
import com.example.ticktockdeal.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/users")
@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;
    private final SessionService sessionService;

    @PostMapping
    public UserResponse join(@RequestBody @Validated JoinRequest request) {
        User user = userService.join(request);
        return new UserResponse(user);
    }

    @PostMapping("/login")
    public UserResponse login(@RequestBody @Validated LoginRequest loginRequest) {
        User user = sessionService.login(loginRequest);
        return new UserResponse(user);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        sessionService.logoutUser();
        return ResponseEntity.ok("Logout successful");
    }

}
