package com.example.ticktockdeal.core.domain;

import com.example.ticktockdeal.purchase.request.PurchaseProductRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    private Long userId;
    private Long dealProductId;
    private Integer quantity;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static Purchase create(PurchaseProductRequest request, Long userId) {

        Purchase purchase = Purchase.builder()
                .userId(userId)
                .dealProductId(request.getProductId())
                .quantity(request.getQuantity())
                .createdAt(LocalDateTime.now())
                .build();

        return purchase;
    }
}
