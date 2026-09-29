package com.example.crudproject.service;

import com.example.crudproject.dto.request.ProductDtoRequest;
import com.example.crudproject.dto.response.ProductDtoResponse;
import com.example.crudproject.entity.Product;

import java.util.List;

/**
 * Define las operaciones disponibles para gestionar productos.
 */
public interface ProductService {

    /**
     * Create product.
     *
     * @param product the product
     * @return the product
     */
    Product create(ProductDtoRequest product);

    /**
     * Find all list.
     *
     * @return the list
     */
    List<ProductDtoResponse> findAll();

    /**
     * Find by id product dto response.
     *
     * @param id the id
     * @return the product dto response
     */
    ProductDtoResponse findById(Long id);

    /**
     * Update product.
     *
     * @param id         the id
     * @param productDto the product dto
     * @return the product
     */
    Product update(Long id, ProductDtoRequest productDto);

    /**
     * Delete.
     *
     * @param id the id
     */
    void delete(Long id);
}
