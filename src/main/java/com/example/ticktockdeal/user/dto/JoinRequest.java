package com.example.ticktockdeal.user.dto;

import lombok.Getter;
import lombok.NonNull;

@Getter
public class JoinRequest {

    @NonNull
    private String userId;

    @NonNull
    private String password;

    @NonNull
    private String address;
}
