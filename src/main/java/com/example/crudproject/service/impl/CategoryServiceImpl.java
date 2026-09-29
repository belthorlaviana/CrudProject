package com.example.crudproject.service.impl;

import com.example.crudproject.Repository.CategoryRepository;
import com.example.crudproject.entity.Category;
import com.example.crudproject.service.CategoryService;
import org.springframework.stereotype.Service;

/**
 * Implementación de la lógica de negocio para las operaciones de categorías.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Categoría no encontrada con id: " + id));
    }
}
