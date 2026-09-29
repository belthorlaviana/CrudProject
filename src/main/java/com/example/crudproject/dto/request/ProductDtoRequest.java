package com.example.crudproject.dto.request;

import lombok.Data;

import java.math.BigDecimal;


/**
 * Datos recibidos en las solicitudes para crear o actualizar un producto.
 */
@Data
public class ProductDtoRequest {

    private Long idCategory;

    private String sku;

    private String name;

    private String description;

    private BigDecimal price;

    private Integer stock;

    private Boolean active;

}
