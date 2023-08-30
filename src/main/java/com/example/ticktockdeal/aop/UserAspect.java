package com.example.ticktockdeal.aop;

import com.example.ticktockdeal.user.service.SessionService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

@RequiredArgsConstructor
@Aspect
@Configuration
public class UserAspect {

    private final SessionService sessionService;

    @Before("@annotation(com.example.ticktockdeal.annotation.LoginCheck)")
    public void loginCheck() throws HttpClientErrorException {
        String userId = sessionService.getUserId();
        if(userId == null) {
            throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED);
        }

    }
}
