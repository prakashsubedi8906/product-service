package com.prakash.productservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @GetMapping("/{productId}")
    public ResponseEntity<String> getProduct(@Validated @PathVariable Long productId) {
        return ResponseEntity.ok("Product Service is running");
    }


}
