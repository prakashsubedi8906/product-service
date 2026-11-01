package com.prakash.productservice.service;

import com.prakash.productservice.dto.Productdto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {
    Productdto getProductDetails(Long productId);

    Long addProduct(Productdto productdto);

    List<Productdto> getAllProducts();
}
