package com.example.crudproject.mapper;

import com.example.crudproject.dto.request.ProductDtoRequest;
import com.example.crudproject.dto.response.ProductDtoResponse;
import com.example.crudproject.entity.Category;
import com.example.crudproject.entity.Product;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-10-22T15:34:18+0200",
    comments = "version: 1.6.3, compiler: javac, environment: Java 24 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product toEntity(ProductDtoRequest productDto, Category category) {
        if ( productDto == null && category == null ) {
            return null;
        }

        Product product = new Product();

        if ( productDto != null ) {
            product.setName( productDto.getName() );
            product.setDescription( productDto.getDescription() );
            product.setSku( productDto.getSku() );
            product.setPrice( productDto.getPrice() );
            product.setStock( productDto.getStock() );
            product.setActive( productDto.getActive() );
        }
        product.setCategory( category );

        return product;
    }

    @Override
    public ProductDtoResponse toDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDtoResponse productDtoResponse = new ProductDtoResponse();

        productDtoResponse.setIdCategory( productCategoryId( product ) );
        productDtoResponse.setSku( product.getSku() );
        productDtoResponse.setName( product.getName() );
        productDtoResponse.setDescription( product.getDescription() );
        productDtoResponse.setPrice( product.getPrice() );
        productDtoResponse.setStock( product.getStock() );
        productDtoResponse.setActive( product.getActive() );

        return productDtoResponse;
    }

    @Override
    public void toUpdatedEntity(ProductDtoRequest productDtoRequest, Product product) {
        if ( productDtoRequest == null ) {
            return;
        }

        product.setSku( productDtoRequest.getSku() );
        product.setName( productDtoRequest.getName() );
        product.setDescription( productDtoRequest.getDescription() );
        product.setPrice( productDtoRequest.getPrice() );
        product.setStock( productDtoRequest.getStock() );
        product.setActive( productDtoRequest.getActive() );
    }

    private Long productCategoryId(Product product) {
        Category category = product.getCategory();
        if ( category == null ) {
            return null;
        }
        return category.getId();
    }
}
