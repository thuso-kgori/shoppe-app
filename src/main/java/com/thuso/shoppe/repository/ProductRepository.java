package com.thuso.shoppe.repository;

import com.thuso.shoppe.entity.Product;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ProductRepository implements PanacheRepository<Product> {

    public Product findByCode(String code){
        return find("code", code).firstResult();
    }

    public List<Product> findAlive(){
        return list("status", true);
    }

    public void deleteByCode(String code){
        delete("code", code);
    }
}
