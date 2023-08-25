package com.example.ticktockdeal.user.response;

import com.example.ticktockdeal.core.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Getter
@NoArgsConstructor
public class UserResponse {

    @NonNull
    private String userId;

    @NonNull
    private String address;

    public UserResponse(User user) {
        this.userId = user.getUserId();
        this.address = user.getAddress();
    }
}
