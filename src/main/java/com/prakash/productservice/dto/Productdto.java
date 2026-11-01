package com.prakash.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Productdto {
    private String productName;
    private String productDescription;
    private double productPrice;
    private long quantity;

}
