package com.example.crudproject.mapper;

import com.example.crudproject.dto.request.ProductDtoRequest;
import com.example.crudproject.dto.response.ProductDtoResponse;
import com.example.crudproject.entity.Category;
import com.example.crudproject.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

/**
 * Convierte productos entre entidades JPA y DTOs.
 */
@Mapper(componentModel = "spring")
public interface ProductMapper {

    /**
     * To entity product.
     *
     * @param productDto the product dto
     * @param category   the category
     * @return the product
     */
    @Mapping(target = "category", source = "category")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Product toEntity(ProductDtoRequest productDto, Category category);

    /**
     * To dto product dto response.
     *
     * @param product the product
     * @return the product dto response
     */
    @Mapping(target = "categoryName", source = "category.name")
    ProductDtoResponse toDto(Product product);

    /**
     * To updated entity.
     *
     * @param productDtoRequest the product dto request
     * @param product           the product
     */
    @Mapping(target = "name", source = "productDtoName")
    @Mapping(target = "description", source = "productDtoDescription")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "category", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    void toUpdatedEntity(ProductDtoRequest productDtoRequest, @MappingTarget Product product);

}
