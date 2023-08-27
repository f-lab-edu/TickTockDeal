package com.example.ticktockdeal.core.repository;

import com.example.ticktockdeal.core.domain.DealProduct;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DealProductRepository extends JpaRepository<DealProduct, Long> {

    @Lock(LockModeType.PESSIMISTIC_READ)
    @Query("select d from DealProduct d where d.id = :id")
    DealProduct findByIdWithLock(@Param("id") Long id);
}
