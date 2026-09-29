package com.example.crudproject.mapper;

import com.example.crudproject.dto.request.ProductDtoRequest;
import com.example.crudproject.dto.response.ProductDtoResponse;
import com.example.crudproject.entity.Category;
import com.example.crudproject.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "category", source = "category")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Product toEntity(ProductDtoRequest productDto, Category category);

    @Mapping(target = "categoryName", source = "category.name")
    ProductDtoResponse toDto(Product product);

    @Mapping(target = "name", source = "productDtoName")
    @Mapping(target = "description", source = "productDtoDescription")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "category", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    void toUpdatedEntity(ProductDtoRequest productDtoRequest, @MappingTarget Product product);

}
