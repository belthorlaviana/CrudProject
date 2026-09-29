package com.example.crudproject.mapper;


import com.example.crudproject.dto.response.CategoryDtoResponse;
import com.example.crudproject.entity.Category;
import org.mapstruct.Mapper;

/**
 * Convierte categorías entre entidades JPA y DTOs.
 */
@Mapper(componentModel = "spring")
public interface CategoryMapper {

    /**
     * To dto category dto response.
     *
     * @param category the category
     * @return the category dto response
     */
    CategoryDtoResponse toDto(Category category);

    /**
     * To entity category.
     *
     * @param categoryDto the category dto
     * @return the category
     */
    Category toEntity(CategoryDtoResponse categoryDto);
}
