package com.example.ticktockdeal.core.domain;

import com.example.ticktockdeal.user.dto.JoinRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    private String userId;
    private String password;
    private String address;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static User create(JoinRequest request, String hashed) {

        User user = User.builder()
                .userId(request.getUserId())
                .password(hashed)
                .address(request.getAddress())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        return user;
    }

}
