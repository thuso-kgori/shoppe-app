package com.thuso.shoppe.services;

import com.thuso.shoppe.dto.ProductDto;
import com.thuso.shoppe.entity.Product;
import com.thuso.shoppe.mapper.ProductMapper;
import com.thuso.shoppe.repository.ProductRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class ProductService {

    @Inject
    ProductRepository productRepository;

    public ProductDto getProduct(String code){ return ProductMapper.INSTANCE.productEntityToDto(productRepository.findByCode(code)); }
    public List<ProductDto> getProducts(){ return ProductMapper.INSTANCE.productEntityListToDtoList(productRepository.findAlive()); }

}
