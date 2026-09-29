package com.example.crudproject.service.impl;

import com.example.crudproject.Repository.CategoryRepository;
import com.example.crudproject.Repository.ProductRepository;
import com.example.crudproject.dto.request.ProductDtoRequest;
import com.example.crudproject.dto.response.ProductDtoResponse;
import com.example.crudproject.entity.Category;
import com.example.crudproject.entity.Product;
import com.example.crudproject.mapper.ProductMapper;
import com.example.crudproject.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementa la lógica de negocio para las operaciones de productos.
 */
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.productMapper = productMapper;
    }

    @Override
    public Product create(ProductDtoRequest productDto) {

        Category category = categoryRepository.findById(productDto.getIdCategory())
                .orElseThrow(() ->
                        new RuntimeException("Categoría no encontrada"));

        Product product= productMapper.toEntity(productDto,category);


        return productRepository.save(product);
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
    public Product update(Long id, ProductDtoRequest productDto) {

        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Product not found with id: " + id
                        )
                );

        Category category = categoryRepository.findById(productDto.getIdCategory())
                .orElseThrow(() ->
                        new RuntimeException("Categoría no encontrada"));

        productMapper.toUpdatedEntity(productDto, existingProduct);
        existingProduct.setCategory(category);

        return productRepository.save(existingProduct);
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