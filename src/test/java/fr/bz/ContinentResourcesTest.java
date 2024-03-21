package fr.bz;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class ContinentResourcesTest {

    @Test
    public void testGetAllContinents() {
        given()
                .when().get("/continents/")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);
        // You may add more assertions here based on the expected behavior
    }

    @Test
    public void testGetPaysByContinent() {
        String codeContinent = "EU"; // Replace with an actual continent code for testing
        given()
                .pathParam("codeContinent", codeContinent)
                .when().get("/continents/{codeContinent}/pays")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);
        // You may add more assertions here based on the expected behavior
    }

    @Test
    public void testGetPaysByIdEndpoint_NotFound() {
        given()
                .pathParam("codeContinent", "xx") // Remplacer "xx" avec un codeIso31661 qui n'existe pas dans votre base de données
                .when().get("/continents/{codeContinent}/pays")
                .then()
                .statusCode(404);
    }
}
