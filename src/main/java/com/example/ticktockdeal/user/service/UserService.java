package com.example.ticktockdeal.user.service;

import com.example.ticktockdeal.core.domain.User;
import com.example.ticktockdeal.core.repository.UserRepository;
import com.example.ticktockdeal.user.dto.JoinRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public User join(JoinRequest joinRequest) {

        boolean isExistsUserId = userRepository.existsByUserId(joinRequest.getUserId());

        if(isExistsUserId) {
            throw new IllegalArgumentException("이미 존재하는 아이디입니다.");
        }

        String password = passwordEncoder.encode(joinRequest.getPassword());

        User user = User.create(joinRequest, password);

        userRepository.save(user);

        return user;
    }
}
