package com.example.crudproject.service.impl;

import com.example.crudproject.Repository.ProductRepository;
import com.example.crudproject.dto.request.ProductDtoRequest;
import com.example.crudproject.dto.response.ProductDtoResponse;
import com.example.crudproject.entity.Category;
import com.example.crudproject.entity.Product;
import com.example.crudproject.mapper.ProductMapper;
import com.example.crudproject.service.CategoryService;
import com.example.crudproject.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementa la lógica de negocio para las operaciones de productos.
 */
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final CategoryService categoryService;

    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, CategoryService categoryService, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
        this.productMapper = productMapper;
    }

    @Override
    public ProductDtoResponse create(ProductDtoRequest productDto) {

        Category category = categoryService.findById(productDto.getIdCategory());
        Product product = productMapper.toEntity(productDto, category);
        Product savedProduct = productRepository.save(product);
        return productMapper.toDto(savedProduct);
    }

    @Override
    public List<ProductDtoResponse> findAll() {

        return productRepository.findAll().stream()
                .map(productMapper::toDto)
                .toList();
    }

    @Override
    public ProductDtoResponse findById(Long id) {
        return productRepository.findById(id)
                .map(productMapper::toDto)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Product not found with id: " + id
                        )
                );
    }

    @Override
    public ProductDtoResponse update(Long id, ProductDtoRequest productDto) {

        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Product not found with id: " + id
                        )
                );

        Category category = categoryService.findById(productDto.getIdCategory());

        productMapper.toUpdatedEntity(productDto, existingProduct);
        existingProduct.setCategory(category);

        Product updatedProduct = productRepository.save(existingProduct);
        return productMapper.toDto(updatedProduct);
    }

    @Override
    public void delete(Long id) {

        if (!productRepository.existsById(id)) {
            throw new RuntimeException(
                    "Product not found with id: " + id
            );
        }

        productRepository.deleteById(id);
    }
}