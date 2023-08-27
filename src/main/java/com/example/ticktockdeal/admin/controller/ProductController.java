package com.example.ticktockdeal.admin.controller;

import com.example.ticktockdeal.admin.request.CreateDealProductRequest;
import com.example.ticktockdeal.admin.response.ProductResponse;
import com.example.ticktockdeal.admin.service.ProductService;
import com.example.ticktockdeal.core.domain.DealProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/products")
@RestController
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ProductResponse createProduct(@RequestBody @Validated CreateDealProductRequest request) {
        DealProduct product = productService.create(request);
        return new ProductResponse(product);
    }

}
