package com.example.crudproject.service;

import com.example.crudproject.dto.request.ProductDtoRequest;
import com.example.crudproject.dto.response.ProductDtoResponse;
import com.example.crudproject.entity.Product;

import java.util.List;

public interface ProductService {
    //fecho
    Product create(ProductDtoRequest product);
    //fecho
    List<ProductDtoResponse> findAll();
    //fecho
    ProductDtoResponse findById(Long id);

    Product update(Long id, ProductDtoRequest productDto);

    void delete(Long id);
}
