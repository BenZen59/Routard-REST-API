package fr.bz;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.equalTo;

@QuarkusTest
public class PaysResourcesTest {
    @Test
    public void testGetPaysByIdEndpoint() {
        given()
                .pathParam("codeIso31661", "FR")
                .when().get("/pays/{codeIso31661}")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("codeIso31661", equalTo("FR"));
    }

    @Test
    public void testGetPaysByIdEndpoint_NotFound() {
        given()
                .pathParam("codeIso31661", "xx") // Remplacer "xx" avec un codeIso31661 qui n'existe pas dans votre base de données
                .when().get("/pays/{codeIso31661}")
                .then()
                .statusCode(404);
    }

    @Test
    public void testGetSubdivisionByPaysEndpoint() {
        given()
                .pathParam("codeIso31661", "FR")
                .when().get("/pays/{codeIso31661}/subdivisions")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);
    }

    @Test
    public void testGetSubdivisionByPaysEndpoint_NotFound() {
        given()
                .pathParam("codeIso31661", "xx") // Remplacer "xx" avec un codeIso31661 qui n'existe pas dans votre base de données
                .when().get("/pays/{codeIso31661}/subdivisions")
                .then()
                .contentType("text/plain")
                .body(is("Aucune subdivisions trouvés pour ce pays"))
                .statusCode(404);
    }
}
