package com.example.ticktockdeal.core.repository;

import com.example.ticktockdeal.core.domain.DealProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DealProductRepository extends JpaRepository<DealProduct, Long> {
}
