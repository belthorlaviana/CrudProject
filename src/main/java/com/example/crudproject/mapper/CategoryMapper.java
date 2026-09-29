package com.example.crudproject.mapper;


import com.example.crudproject.dto.response.CategoryDtoResponse;
import com.example.crudproject.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDtoResponse toDto(Category category);

    Category toEntity(CategoryDtoResponse categoryDto);
}
