package com.example.crudproject.dto.request;

import lombok.Data;

import java.math.BigDecimal;


@Data
public class ProductDtoRequest {

    private Long idCategory;

    private String sku;

    private String ProductDtoName;

    private String ProductDtoDescription;

    private BigDecimal price;

    private Integer stock;

    private Boolean active;

}
