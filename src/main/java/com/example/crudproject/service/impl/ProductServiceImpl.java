package com.example.crudproject.service.impl;

import com.example.crudproject.dto.request.ProductDtoRequest;
import com.example.crudproject.dto.response.ProductDtoResponse;
import com.example.crudproject.exceptions.ProductNotFoundException;
import com.example.crudproject.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementa la lógica de negocio para las operaciones de productos.
 */
@Service
public class ProductServiceImpl implements ProductService {

    private final List<ProductDtoResponse> dataList = new ArrayList<ProductDtoResponse>();

    public ProductServiceImpl() {

        dataList.add(ProductDtoResponse.builder()
                .idProduct(1L)
                .idCategory(1L)
                .sku("PROD001")
                .name("Teclado")
                .description("Teclado mecánico")
                .price(new BigDecimal("49.99"))
                .stock(10)
                .active(true)
                .build());

        dataList.add(ProductDtoResponse.builder()
                .idProduct(2L)
                .idCategory(1L)
                .sku("PROD002")
                .name("Ratón")
                .description("Ratón inalámbrico")
                .price(new BigDecimal("19.99"))
                .stock(25)
                .active(true)
                .build());

        dataList.add(ProductDtoResponse.builder()
                .idProduct(3L)
                .idCategory(2L)
                .sku("PROD003")
                .name("Monitor")
                .description("Monitor de 27 pulgadas")
                .price(new BigDecimal("199.99"))
                .stock(5)
                .active(true)
                .build());
    }

    @Override
    public ProductDtoResponse create(ProductDtoRequest productDto) {

        ProductDtoResponse data = ProductDtoResponse.builder()
                .idProduct(productDto.getIdProduct())
                .idCategory(productDto.getIdCategory())
                .sku(productDto.getSku())
                .name(productDto.getName())
                .description(productDto.getDescription())
                .price(productDto.getPrice())
                .stock(productDto.getStock())
                .active(productDto.getActive())
                .build();

        dataList.add(data);

        return data;
    }

    @Override
    public List<ProductDtoResponse> findAll() {

        return dataList;
    }

    @Override
    public ProductDtoResponse findById(Long id) {

        return dataList.stream()
                .filter(product -> product.getIdProduct().equals(id))
                .findFirst()
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    @Override
    public ProductDtoResponse update(Long id, ProductDtoRequest productDto) {

        ProductDtoResponse existingProduct = findById(id);

        if (null != existingProduct) {
            ProductDtoResponse updatedProduct = ProductDtoResponse.builder()
                    .idProduct(existingProduct.getIdProduct())//EL ID DELPRODUCTO NO SE PUEDE CAMBIAR, SE MANTIENE EL ID DEL PRODUCTO EXISTENTE
                    .idCategory(productDto.getIdCategory())
                    .sku(productDto.getSku())
                    .name(productDto.getName())
                    .description(productDto.getDescription())
                    .price(productDto.getPrice())
                    .stock(productDto.getStock())
                    .active(productDto.getActive())
                    .build();

            int index = dataList.indexOf(existingProduct);
            dataList.set(index, updatedProduct);

            return updatedProduct;
        }

        return null;

    }

    @Override
    public void delete(Long id) {

        ProductDtoResponse product = findById(id);
        dataList.remove(product);
    }
}