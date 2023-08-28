package com.example.ticktockdeal.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class LoginRequest {

    @NonNull
    private String loginId;

    @NonNull
    private String loginPassword;

}
