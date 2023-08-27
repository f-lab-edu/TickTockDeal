package com.example.ticktockdeal.admin.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NonNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
public class CreateDealProductRequest {

    @NonNull
    private String name;

    @NonNull
    private Integer stock;

    @NonNull
    private BigDecimal price;

    @NonNull
    private String requestId;

    @NonNull
    private String content;

    private String status;

    @NonNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime startedAt;

    @NonNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime finishedAt;
}
