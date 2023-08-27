package com.example.ticktockdeal.purchase.service;

import com.example.ticktockdeal.core.domain.DealProduct;
import com.example.ticktockdeal.core.domain.Purchase;
import com.example.ticktockdeal.core.domain.User;
import com.example.ticktockdeal.core.repository.DealProductRepository;
import com.example.ticktockdeal.core.repository.PurchaseRepository;
import com.example.ticktockdeal.purchase.request.PurchaseProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class PurchaseProductService {

    private final DealProductRepository dealProductRepository;
    private final PurchaseRepository purchaseRepository;

    @Transactional
    public Purchase purchase(PurchaseProductRequest purchaseProductRequest) {

        // 로그인은 이미 됐다고 가정함

        // 물품의 재고가 0 이상이어야 구매할 수 있음
        DealProduct product = dealProductRepository.findByIdWithLock(purchaseProductRequest.getProductId());

        if(product == null) {
            throw new IllegalArgumentException("상품이 존재하지 않습니다.");
        }

        LocalDateTime now = LocalDateTime.now();

        if(now.isBefore(product.getStartedAt()) || now.isAfter(product.getFinishedAt())) {
            throw new IllegalArgumentException("이 시간에는 상품을 구매할 수 없습니다.");
        }

        if(product.getStock() - purchaseProductRequest.getQuantity() < 1) {
            throw new IllegalArgumentException("현재 상품의 재고가 없습니다.");
        }

        product.decreaseStock(purchaseProductRequest.getQuantity());
        dealProductRepository.save(product);

        // 로그인 됐다고 가정
        User user = getLoggedInUser();
        Purchase purchase = Purchase.create(purchaseProductRequest, user.getId());
        purchaseRepository.save(purchase);

        return purchase;
    }

    private User getLoggedInUser() {
        User user = User.builder()
                .userId("userId")
                .id(10L)
                .build();

        return user;
    }
}
