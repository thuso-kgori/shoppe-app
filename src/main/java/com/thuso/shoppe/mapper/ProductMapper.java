package com.thuso.shoppe.mapper;

import com.thuso.shoppe.dto.ProductDto;
import com.thuso.shoppe.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper( ProductMapper.class );

    ProductDto productEntityToDto(Product product);
    Product productDtoToProductEntity(ProductDto productDto);

    List<ProductDto> productEntityListToDtoList(List<Product> products);
}
