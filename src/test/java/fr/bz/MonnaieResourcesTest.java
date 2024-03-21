package fr.bz;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@QuarkusTest
public class MonnaieResourcesTest {
    @Test
    public void testGetAllMonnaiesEndpoint() {
        given()
                .when().get("/monnaies")
                .then()
                .statusCode(200);
    }

    @Test
    public void testGetMonnaieByIdEndpoint() {
        given()
                .pathParam("codeIsoMonnaie", "EUR")
                .when().get("/monnaies/{codeIsoMonnaie}")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("codeIsoMonnaie", equalTo("EUR"));
    }

    @Test
    public void testGetMonnaieByIdEndpoint_NotFound() {
        given()
                .pathParam("codeIsoMonnaie", "xx") // Remplacer "xx" avec un codeIsoMonnaie qui n'existe pas dans votre base de données
                .when().get("/monnaies/{codeIsoMonnaie}")
                .then()
                .statusCode(404);
    }
}
