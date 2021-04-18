package com.thuso.shoppe.services;

import com.thuso.shoppe.ErrorMessages;
import com.thuso.shoppe.dto.CustomerDto;
import com.thuso.shoppe.dto.ProductDto;
import com.thuso.shoppe.entity.Order;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
public class ProcessorService {

    @Inject
    CustomerService customerService;

    @Inject
    ProductService productService;

    public List<ProductDto> getProducts(){ return productService.getProducts(); }


    public Response.ResponseBuilder processOrder(Order order){
        Double total = 0.0;

        if(order.getCustomerId() == null)
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(ErrorMessages.CUSTOMER_DATA.toString());
        if(order.getCodes().isEmpty())
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(ErrorMessages.PRODUCT_DATA.toString());

        CustomerDto customer = customerService.getCustomerByUniqueId(order.getCustomerId());

        if(customer == null)
            return Response.status(Response.Status.FORBIDDEN.getStatusCode()).entity(ErrorMessages.NO_SUCH_CUSTOMER.toString());

        for (String code : order.getCodes()){
            ProductDto product = productService.getProduct(code);
            if(product == null)
                return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(code+" - "+ErrorMessages.NO_SUCH_PRODUCT.toString());
            total += product.getPointsCost();
        }

        if( customer.getPoints() > total ){
            Double balance = customer.getPoints() - total;
            customerService.updatePointBalance(balance, customer.getIdNumber());
        } else {
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(ErrorMessages.INSUFFICIENT_FUNDS.toString());
        }

        return Response.ok();
    }

}
