package fr.bz;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.equalTo;

@QuarkusTest
public class VilleResourcesTest {
    @Test
    public void testGetVilleByIdEndpoint() {
        given()
                .pathParam("idVille", 437)
                .when().get("/villes/{idVille}")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("idVille", equalTo(437));
    }

    @Test
    public void testGetVilleByIdEndpoint_NotFound() {
        given()
                .pathParam("idVille", 99999)
                .when().get("/villes/{idVille}")
                .then()
                .statusCode(404);
    }

    @Test
    public void testGetMeteobyIdVIlleEndpoint() {
        given()
                .pathParam("idVille", 147)
                .when().get("/villes/{idVille}/meteo")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);
    }
    @Test
    public void testGetVilleByIdWithoutClimatEndpoint() {
        given()
                .pathParam("idVille", 588)
                .when().get("/villes/{idVille}/meteo")
                .then()
                .statusCode(404)
                .contentType("text/plain")
                .body(is("Pas de température pour cette ville"));
    }
    @Test
    public void testGetVilleByIdWithoutClimatEndpoint_NotFound() {
        given()
                .pathParam("idVille", 99999)
                .when().get("/villes/{idVille}/meteo")
                .then()
                .statusCode(404)
                .contentType("text/plain")
                .body(is("Cet id de ville n'existe pas !"));
    }

    @Test
    public void testGetVilleClimatByMoisEndpoint() {
        int idVille = 147;
        int idMois = 1;
        given()
                .pathParam("idVille", idVille)
                .pathParam("idMois", idMois)
                .when().get("/villes/{idVille}/meteo?idMois={idMois}")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);
    }

    @Test
    public void testGetVilleClimatByMoisEndpoint_NotFound() {
        int idVille = 147;
        int idMois = 13;
        given()
                .pathParam("idVille", idVille)
                .pathParam("idMois", idMois)
                .when().get("/villes/{idVille}/meteo?idMois={idMois}")
                .then()
                .statusCode(404)
                .contentType("text/plain")
                .body(is("L'id du mois n'existe pas"));
    }
}
