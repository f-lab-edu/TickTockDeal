package com.example.ticktockdeal.user.service;

import com.example.ticktockdeal.core.domain.User;
import com.example.ticktockdeal.core.repository.UserRepository;
import com.example.ticktockdeal.exception.PasswordNotMatchedException;
import com.example.ticktockdeal.exception.UserNotFoundException;
import com.example.ticktockdeal.user.dto.LoginRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.example.ticktockdeal.user.session.SessionKeyConstraints.LOGIN_SESSION;

@RequiredArgsConstructor
@Service
public class SessionService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final HttpSession httpSession;

    public User login(LoginRequest request) {

        User user = userRepository.findUserByUserId(request.getLoginId());
        validateExistUser(user);

        validatePassword(user, request.getLoginPassword());

        httpSession.setAttribute(LOGIN_SESSION, User.builder()
                .id(user.getId())
                .userId(request.getLoginId())
                .password(request.getLoginPassword())
                .build());

        return user;

    }


    // 유저가 존재하는지 유효성 검사
    private void validateExistUser(User user) {

        Optional.ofNullable(user)
                .orElseThrow(() -> new UserNotFoundException("유저를 찾을 수 없습니다."));

    }

    // 비밀번호의 일치여부 유효성 검사
    private void validatePassword(User user, String password) {

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new PasswordNotMatchedException("비밀번호가 일치하지 않습니다.");
        }

    }

    // 세션에서 현재 로그인된 사용자의 정보를 가져오는 기능
    public User getLoggedInUserFromSession() {
        User user = (User) httpSession.getAttribute(LOGIN_SESSION);
        validateExistUser(user);
        return user;
    }

    // 데이터베이스에서 현재 로그인된 사용자의 정보를 가져오는 기능
    public User getLoggedInUserFromDatabase() {
        User user = getLoggedInUserFromSession();
        return userRepository.findById(user.getId())
                .orElseThrow(() -> new UserNotFoundException("유저를 찾을 수 없습니다."));
    }

    // 로그아웃 기능
    public void logoutUser() {
        httpSession.removeAttribute(LOGIN_SESSION);
    }

    public String getUserId() {
        return (String)httpSession.getAttribute(LOGIN_SESSION);
    }
}






