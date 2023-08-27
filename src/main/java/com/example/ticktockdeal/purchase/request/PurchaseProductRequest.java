package com.example.ticktockdeal.purchase.request;

import lombok.Getter;
import lombok.NonNull;

@Getter
public class PurchaseProductRequest {

    @NonNull
    private Long productId;

    @NonNull
    private Integer quantity;

}
