package com.example.ticktockdeal.admin.response;

import com.example.ticktockdeal.core.domain.DealProduct;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProductResponse {

    @NonNull
    private String name;

    @NonNull
    private Integer stock;

    public ProductResponse(DealProduct product) {
        this.name = product.getName();
        this.stock = product.getStock();
    }
}
