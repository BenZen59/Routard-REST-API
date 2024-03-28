package fr.bz;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@QuarkusTest
public class PointInteretTest {
    @Test
    public void testGetAllPointsInteretsEndpoint() {
        given()
                .when().get("/pointsinterets/search/")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);
        // You may add more assertions here based on the expected behavior
    }

    @Test
    public void testGetAllPointsInteretsByCategorieEndpoint() {
        int idCategorie = 1;
        given()
                .pathParam("idCategorie", idCategorie)
                .when().get("/pointsinterets/search?idCategorie={idCategorie}")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);
    }

    @Test
    public void testGetAllPointsInteretsBySubdivisionEndpoint() {
        int idSubdivision = 16;
        given()
                .pathParam("idSubdivision", idSubdivision)
                .when().get("/pointsinterets/search?idSubdivision={idSubdivision}")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);
    }

    @Test
    public void testGetAllPointsInteretsByCategorieBySubdivisionEndpoint() {
        int idCategorie = 1;
        int idSubdivision = 16;
        given()
                .pathParam("idCategorie", idCategorie)
                .pathParam("idSubdivision", idSubdivision)
                .when().get("/pointsinterets/search?idCategorie={idCategorie}&idSubdivision={idSubdivision}")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);
    }

   @Test
    public void testResultatsIsEmptyPointsInteretsEndpoint() {
        int idSubdivision = 1;
        int idCategorie = 1;
        given()
                .pathParam("idSubdivision", idSubdivision)
                .pathParam("idCategorie", idCategorie)
                .when()
                .get("/pointsinterets/search?idCategorie={idCategorie}&idSubdivision={idSubdivision}")
                .then()
                .statusCode(404)
                .contentType(MediaType.TEXT_PLAIN)
                .body(equalTo("Aucun résultats trouvées"));
    }

    @Test
    public void testIdisFalsePointsInteretsWithCategorieEndpoint() {
        int idCategorie = 9999;
        given()
                .pathParam("idCategorie", idCategorie)
                .when()
                .get("/pointsinterets/search?idCategorie={idCategorie}")
                .then()
                .statusCode(404)
                .contentType(MediaType.TEXT_PLAIN)
                .body(equalTo("La catégorie avec l'ID 9999 n'existe pas dans la base de données"));
    }

    @Test
    public void testIdisFalsePointsInteretsWithSubdivisionsEndpoint() {
        int idSubdivision = 9999;
        given()
                .pathParam("idSubdivision", idSubdivision)
                .when()
                .get("/pointsinterets/search?idSubdivision={idSubdivision}")
                .then()
                .statusCode(404)
                .contentType(MediaType.TEXT_PLAIN)
                .body(equalTo("La subdivision avec l'ID 9999 n'existe pas dans la base de données"));
    }
}
