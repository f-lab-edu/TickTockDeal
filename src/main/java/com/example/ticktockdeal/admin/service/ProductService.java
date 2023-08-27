package com.example.ticktockdeal.admin.service;

import com.example.ticktockdeal.admin.request.CreateDealProductRequest;
import com.example.ticktockdeal.core.domain.DealProduct;
import com.example.ticktockdeal.core.repository.DealProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final DealProductRepository dealProductRepository;

    @Transactional
    public DealProduct create(CreateDealProductRequest request) {
        DealProduct product = DealProduct.create(request);
        dealProductRepository.save(product);

        return product;
    }
}
