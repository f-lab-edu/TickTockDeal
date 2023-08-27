package com.example.ticktockdeal.user.controller;

import com.example.ticktockdeal.core.domain.User;
import com.example.ticktockdeal.user.dto.JoinRequest;
import com.example.ticktockdeal.user.response.UserResponse;
import com.example.ticktockdeal.user.service.UserService;
import lombok.RequiredArgsConstructor;
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

    @PostMapping
    public UserResponse join(@RequestBody @Validated JoinRequest request) {
        User user = userService.join(request);
        return new UserResponse(user);
    }


}
