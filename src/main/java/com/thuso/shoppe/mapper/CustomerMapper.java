package com.thuso.shoppe.mapper;

import com.thuso.shoppe.dto.CustomerDto;
import com.thuso.shoppe.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper( CustomerMapper.class );

    CustomerDto userEntityToDto(Customer user);
    Customer userDtoToUserEntity(CustomerDto userDto);

    List<CustomerDto> customerEntityListToDtoList(List<Customer> customers);
}
