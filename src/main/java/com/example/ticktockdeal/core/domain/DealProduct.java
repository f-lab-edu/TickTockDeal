package com.example.ticktockdeal.core.domain;

import com.example.ticktockdeal.admin.request.CreateDealProductRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DealProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    private String name;
    private Integer stock;
    private BigDecimal price;
    private String requestId;
    private String content;
    private String status;
    private LocalDateTime startedAt;
    private LocalDateTime finishedAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static DealProduct create(CreateDealProductRequest request) {

        DealProduct product = DealProduct.builder()
                .name(request.getName())
                .stock(request.getStock())
                .price(request.getPrice())
                .requestId(request.getRequestId())
                .content(request.getContent())
                .status(request.getStatus())
                .startedAt(request.getStartedAt())
                .finishedAt(request.getFinishedAt())
                .createdAt(LocalDateTime.now())
                .build();

        return product;
    }
}
