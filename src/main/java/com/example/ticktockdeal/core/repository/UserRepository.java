package com.example.ticktockdeal.core.repository;

import com.example.ticktockdeal.core.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByUserId(String userId);

}
