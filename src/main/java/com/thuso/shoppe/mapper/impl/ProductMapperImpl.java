package com.thuso.shoppe.mapper.impl;

import com.thuso.shoppe.dto.ProductDto;
import com.thuso.shoppe.entity.Product;
import com.thuso.shoppe.mapper.ProductMapper;

import java.util.ArrayList;
import java.util.List;

public abstract class ProductMapperImpl implements ProductMapper {
    @Override
    public List<ProductDto> productEntityListToDtoList(List<Product> products) {
        if (products == null) {
            return null;
        }

        List<ProductDto> list = new ArrayList<>(products.size());
        for (Product product : products) {
            list.add(productEntityToDto(product));
        }
        return list;
    }
}
