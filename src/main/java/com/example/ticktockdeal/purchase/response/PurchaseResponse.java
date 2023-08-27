package com.example.ticktockdeal.purchase.response;

import com.example.ticktockdeal.core.domain.Purchase;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor
@Getter
public class PurchaseResponse {

    @NonNull
    private Long productId;

    @NonNull
    private Integer quantity;

    public PurchaseResponse(Purchase purchase) {
        this.productId = purchase.getDealProductId();
        this.quantity = purchase.getQuantity();
    }


}
