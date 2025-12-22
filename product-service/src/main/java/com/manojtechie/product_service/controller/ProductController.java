package com.manojtechie.product_service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import com.manojtechie.product_service.dto.ProductRequest;
import com.manojtechie.product_service.service.ProductService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import com.manojtechie.product_service.dto.ProductResponse;
import java.util.List;



@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping  // Now: /api/products
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productrequest) {
        productService.createProduct(productrequest);
    }

    @GetMapping  // Now: /api/products
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/test")
    public String test() {
        return "Hello";
    }
}