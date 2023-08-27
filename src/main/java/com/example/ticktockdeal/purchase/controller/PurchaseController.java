package com.example.ticktockdeal.purchase.controller;

import com.example.ticktockdeal.core.domain.Purchase;
import com.example.ticktockdeal.purchase.request.PurchaseProductRequest;
import com.example.ticktockdeal.purchase.response.PurchaseResponse;
import com.example.ticktockdeal.purchase.service.PurchaseProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/purchase")
@RequiredArgsConstructor
@RestController
public class PurchaseController {

    private final PurchaseProductService purchaseProductService;

    @PostMapping
    public PurchaseResponse purchase(@RequestBody @Validated PurchaseProductRequest request) {
        Purchase purchase = purchaseProductService.purchase(request);
        return new PurchaseResponse(purchase);
    }
}
