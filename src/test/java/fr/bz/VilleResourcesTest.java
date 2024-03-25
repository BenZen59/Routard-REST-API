package fr.bz;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@QuarkusTest
public class VilleResourcesTest {
    @Test
    public void testGetVilleByIdEndpoint() {
        given()
                .pathParam("idVille", 588)
                .when().get("/villes/{idVille}")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("idVille", equalTo(588));
    }

    @Test
    public void testGetVilleByIdEndpoint_NotFound() {
        given()
                .pathParam("idVille", "xx") // Remplacer "xx" avec un codeIso31661 qui n'existe pas dans votre base de données
                .when().get("/villes/{idVille}")
                .then()
                .statusCode(404);
    }
}
