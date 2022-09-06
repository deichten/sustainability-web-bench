package com.adidas.ea.sustainability;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;


@QuarkusTest
public class CalculatorResourceTest {

    @Test
    public void testAddEndpoint() {
        given()
            .when()
                .get("/calc/add/2/3")
            .then()
                .statusCode(200)
                .body("result", is(5));

        given()
            .when()
                .get("/calc/add/1/5")
            .then()
                .statusCode(200)
                .body("result", is(6));

        given()
            .when()
                .get("/calc/add/0/0")
            .then()
                .statusCode(200)
                .body("result", is(0));

        given()
            .when()
                .get("/calc/add/-3/1")
            .then()
                .statusCode(200)
                .body("result", is(-2));

        given()
            .when()
                .get("/calc/add/2")
            .then()
                .statusCode(404);
    }

    @Test
    public void testSubEndpoint() {
        given()
            .when()
                .get("/calc/sub/3/2")
            .then()
                .statusCode(200)
                .body("result", is(1));

        given()
            .when()
                .get("/calc/sub/5/2")
            .then()
                .statusCode(200)
                .body("result", is(3));

        given()
            .when()
                .get("/calc/sub/0/0")
            .then()
                .statusCode(200)
                .body("result", is(0));

        given()
            .when()
                .get("/calc/sub/-3/1")
            .then()
                .statusCode(200)
                .body("result", is(-4));

        given()
            .when()
                .get("/calc/sub/2")
            .then()
                .statusCode(404);
    }

    @Test
    public void testMulEndpoint() {
        given()
            .when()
                .get("/calc/mul/3/2")
            .then()
                .statusCode(200)
                .body("result", is(6));

        given()
            .when()
                .get("/calc/mul/2/3")
            .then()
                .statusCode(200)
                .body("result", is(6));

        given()
            .when()
                .get("/calc/mul/0/0")
            .then()
                .statusCode(200)
                .body("result", is(0));

        given()
            .when()
                .get("/calc/mul/-3/2")
            .then()
                .statusCode(200)
                .body("result", is(-6));

        given()
            .when()
                .get("/calc/mul/2")
            .then()
                .statusCode(404);
    }

    @Test
    public void testDivEndpoint() {
        given()
            .when()
                .get("/calc/div/3/2")
            .then()
                .statusCode(200)
                .body("result", is(1));

        given()
            .when()
                .get("/calc/div/9/2")
            .then()
                .statusCode(200)
                .body("result", is(4));

        given()
            .when()
                .get("/calc/div/0/5")
            .then()
                .statusCode(200)
                .body("result", is(0));

        given()
            .when()
                .get("/calc/div/5/0")
            .then()
                .statusCode(200)
                .body("error", is("Division by zero"));

        given()
            .when()
                .get("/calc/div/2")
            .then()
                .statusCode(404);
    }

}
