package com.example.crudproject.mapper;

import com.example.crudproject.dto.response.CategoryDtoResponse;
import com.example.crudproject.entity.Category;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-10-22T15:34:18+0200",
    comments = "version: 1.6.3, compiler: javac, environment: Java 24 (Oracle Corporation)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public CategoryDtoResponse toDto(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryDtoResponse categoryDtoResponse = new CategoryDtoResponse();

        categoryDtoResponse.setId( category.getId() );
        categoryDtoResponse.setName( category.getName() );
        categoryDtoResponse.setDescription( category.getDescription() );

        return categoryDtoResponse;
    }

    @Override
    public Category toEntity(CategoryDtoResponse categoryDto) {
        if ( categoryDto == null ) {
            return null;
        }

        Category category = new Category();

        category.setId( categoryDto.getId() );
        category.setName( categoryDto.getName() );
        category.setDescription( categoryDto.getDescription() );

        return category;
    }
}
