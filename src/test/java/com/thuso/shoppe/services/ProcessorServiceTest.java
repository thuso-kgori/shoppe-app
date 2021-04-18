package com.thuso.shoppe.services;

import com.thuso.shoppe.ErrorMessages;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@QuarkusTest
class ProcessorServiceTest {
    @Test
    void purchase() {
        given()
                .body("{\n" +
                        "\t\"customerId\": \"55544\",\n" +
                        "\t\"codes\": [\"9921\",\"7743\"]\n" +
                        "}")
                .header("Content-Type", MediaType.APPLICATION_JSON)
                .when()
                .post("/shop/buy")
                .then()
                .statusCode(200);
    }

    @Test
    void purchaseExpensiveProduct() {
        given()
                .body("{\n" +
                        "\t\"customerId\": \"55544\",\n" +
                        "\t\"codes\": [\"9921\",\"94934\"]\n" +
                        "}")
                .header("Content-Type", MediaType.APPLICATION_JSON)
                .when()
                .post("/shop/buy")
                .then()
                .statusCode(400)
                .body(equalTo(ErrorMessages.INSUFFICIENT_FUNDS.toString()));
    }

    @Test
    void purchaseUnavailableProduct() {
        given()
                .body("{\n" +
                        "\t\"customerId\": \"55544\",\n" +
                        "\t\"codes\": [\"88383\"]\n" +
                        "}")
                .header("Content-Type", MediaType.APPLICATION_JSON)
                .when()
                .post("/shop/buy")
                .then()
                .statusCode(400)
                .body(equalTo("88383 - " + ErrorMessages.NO_SUCH_PRODUCT.toString()));
    }

    @Test
    void unknownUser() {
        given()
                .body("{\n" +
                        "\t\"customerId\": \"9924433\",\n" +
                        "\t\"codes\": [\"88383\"]\n" +
                        "}")
                .header("Content-Type", MediaType.APPLICATION_JSON)
                .when()
                .post("/shop/buy")
                .then()
                .statusCode(403)
                .body(equalTo(ErrorMessages.NO_SUCH_CUSTOMER.toString()));
    }
}