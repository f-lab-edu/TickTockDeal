package com.example.ticktockdeal.core.repository;

import com.example.ticktockdeal.core.domain.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
