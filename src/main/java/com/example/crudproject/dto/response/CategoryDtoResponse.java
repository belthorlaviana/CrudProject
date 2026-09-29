package com.example.crudproject.dto.response;

import lombok.Data;

/**
 * Datos de categoría expuestos en las respuestas de la API.
 */
@Data
public class CategoryDtoResponse {

    private Long id;

    private String name;

    private String description;
}
