package com.thuso.shoppe.repository;

import com.thuso.shoppe.entity.Customer;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class CustomerRepository implements PanacheRepository<Customer> {

    public Customer findByName(String name){
        return find("lastName", name).firstResult();
    }

    public List<Customer> findAlive(){
        return list("status", true);
    }

    public Customer finByUniqueId(String idNumber){
        return find("idNumber", idNumber).firstResult();
    }

    public void deleteByUniqueId(String idNumber){
        delete("idNumber", idNumber);
    }

    @Transactional
    public void updatePointBalance(Double points, String customerId){
        Customer.update("points = :points where idNumber = :customerId", Parameters.with("points", points).and("customerId", customerId)); }
}
