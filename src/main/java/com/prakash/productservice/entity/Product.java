package com.prakash.productservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;

    @Column(name = "productName", nullable = false)
    private String productName;

    @Column(name = "productDescription")
    private String productDescription;

    @Column(name = "productPrice", nullable = false)
    private Double productPrice;

    @Column(name = "quantity", nullable = false)
    private long quantity;

}
