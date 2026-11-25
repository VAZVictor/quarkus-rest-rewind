package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

@QuarkusTest
public class StudentResourceTest {

    @Inject
    StudentResource studentResource;

    @BeforeEach
    void reset() {
        studentResource.datasourceReset();
    }

    @Test
    void getAll_returnsTwoSucceed() {
        given()
                .when()
                    .get("/students")
                .then()
                    .statusCode(200)
                .contentType("/application/json")
                .body("size()", is(2))
                .body("[0].id", notNullValue());
    }
}