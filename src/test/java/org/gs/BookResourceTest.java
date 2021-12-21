package org.gs;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class BookResourceTest {

    @Test
    public void getBooks() {
        given()
                .when()
                .get("/books")
                .then()
                .statusCode(200)
                .body(
                        "$.size()", is(2),
                        "[0].id", is(1),
                        "[0].title", is("The Lord of the Rings"),
                        "[1].id", is(2),
                        "[1].title", is("Harry Potter"));
    }

    @Test
    public void getBookById() {
        given()
                .when()
                .get("/books/1")
                .then()
                .statusCode(200)
                .body(
                        "id", is(1),
                        "title", is("The Lord of the Rings"));
    }

    @Test
    public void getBookByIdNotFound() {
        given()
                .when()
                .get("/books/3")
                .then()
                .statusCode(404);
    }

}