package com.thuso.shoppe.services;

import com.thuso.shoppe.dto.CustomerDto;
import com.thuso.shoppe.mapper.CustomerMapper;
import com.thuso.shoppe.repository.CustomerRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class CustomerService {

    @Inject
    CustomerRepository customerRepository;

    public List<CustomerDto> getCustomers(){ return CustomerMapper.INSTANCE.customerEntityListToDtoList(customerRepository.findAlive()); }

    public CustomerDto getCustomer(String name){ return CustomerMapper.INSTANCE.userEntityToDto(customerRepository.findByName(name)); }

    public CustomerDto getCustomerByUniqueId(String id){ return CustomerMapper.INSTANCE.userEntityToDto(customerRepository.finByUniqueId(id)); }

    public void updatePointBalance(Double points, String customerId){
        customerRepository.updatePointBalance(points, customerId);
    }

}
