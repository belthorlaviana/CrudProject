package com.example.crudproject.service;

import com.example.crudproject.entity.Category;

/**
 * Define las operaciones disponibles para gestionar categorías.
 */
public interface CategoryService {

    /**
     * Find by id category.
     *
     * @param id the id
     * @return the category
     */
    Category findById(Long id);
}
