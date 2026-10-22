package com.example.crudproject.exceptions;

public class CategoryNotFoundException extends RuntimeException {

    public CategoryNotFoundException(Long id) {
        super("Categoría no encontrada con id: " + id);
    }
}