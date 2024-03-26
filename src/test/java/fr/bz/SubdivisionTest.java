package fr.bz;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.equalTo;

@QuarkusTest
public class SubdivisionTest {
    @Test
    public void testGetSubdivisionByIdEndpoint() {
        given()
                .pathParam("idSubdivision", 100)
                .when().get("/subdivisions/{idSubdivision}")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("idSubdivision", equalTo(100));
    }

    @Test
    public void testGetSubdivisionByIdEndpoint_NotFound() {
        given()
                .pathParam("idSubdivision", 9999)
                .when().get("/subdivisions/{idSubdivision}")
                .then()
                .statusCode(404);
    }

    @Test
    public void testGetVillesBySubdivisionEndpoint() {
        given()
                .pathParam("idSubdivision", 100)
                .when().get("/subdivisions/{idSubdivision}/villes")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);
        // You may add more assertions here based on the expected behavior
    }

    @Test
    public void testGetVillesBySubdivisionEndpoint_NotFound() {
        given()
                .pathParam("idSubdivision", 9999)
                .when().get("/subdivisions/{idSubdivision}/villes")
                .then()
                .contentType("text/plain")
                .body(is("Cet id de subdivision n'existe pas"))
                .statusCode(404);
    }
}
