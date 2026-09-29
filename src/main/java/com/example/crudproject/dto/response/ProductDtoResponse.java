package com.example.crudproject.dto.response;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Datos de producto expuestos en las respuestas de la API.
 */
@Data
public class ProductDtoResponse {

    private Long idCategory;

    private String sku;

    private String name;

    private String description;

    private BigDecimal price;

    private Integer stock;

    private Boolean active;
}
