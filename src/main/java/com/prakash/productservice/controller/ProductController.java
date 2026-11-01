package com.prakash.productservice.controller;

import com.prakash.productservice.dto.Productdto;
import com.prakash.productservice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Productdto> getProduct(@PathVariable Long productId) {
        Productdto productDto = productService.getProductDetails(productId);
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> addProduct(@RequestBody Productdto productdto) {
        Long productId = productService.addProduct(productdto);
        return new ResponseEntity<>(productId, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Productdto>> getAllProducts() {
        List<Productdto> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }


}
