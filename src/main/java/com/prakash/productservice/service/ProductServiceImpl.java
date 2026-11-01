package com.prakash.productservice.service;

import com.prakash.productservice.dto.Productdto;
import com.prakash.productservice.entity.Product;
import com.prakash.productservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Productdto getProductDetails(Long productId) {
        Product product =  findProductOrThrow(productId);
        return toDto(product);
    }

    @Override
    public Long addProduct(Productdto productdto) {
        Product product = fromDto(productdto);
        Product savedProduct = productRepository.save(product);
        return savedProduct.getProductId();
    }

    @Override
    public List<Productdto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(this::toDto)
                .toList();
    }


    public Product findProductOrThrow(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));
    }

    public Productdto toDto(Product product) {
        return Productdto.builder()
                .productName(product.getProductName())
                .productDescription(product.getProductDescription())
                .productPrice(product.getProductPrice())
                .quantity(product.getQuantity())
                .build();
    }
    private Product fromDto(Productdto productdto) {
        return Product.builder()
                .productName(productdto.getProductName())
                .productDescription(productdto.getProductDescription())
                .productPrice(productdto.getProductPrice())
                .quantity(productdto.getQuantity())
                .build();
    }
}
