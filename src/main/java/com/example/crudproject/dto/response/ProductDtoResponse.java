package com.example.crudproject.dto.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDtoResponse {

    private String categoryName;

    private String sku;

    private String name;

    private String description;

    private BigDecimal price;

    private Integer stock;
}
