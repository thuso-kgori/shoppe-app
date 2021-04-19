package com.thuso.shoppe.rest;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;

@QuarkusTest
class ShopperResourceTest {

    @Test
    public void testGetProducts() {
        given()
                .when().get("/shop/products")
                .then()
                .statusCode(200)
                .body("$.size()", is(4));
    }

    @Test
    public void testGetCustomers() {
        given()
                .when().get("/shop/customers")
                .then()
                .statusCode(200)
                .body("$.size()", is(2));
    }
}