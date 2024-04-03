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

    @Test
    public void testGetInfoByCodePaysEndpoint() {
        given()
                .pathParam("codeIso31661", "FR")
                .when().get("/pays/{codeIso31661}/informations")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);
    }

    @Test
    public void testGetInformationByCodePaysWithoutTypeInfoEndpoint() {
        given()
                .pathParam("codeIso31661", "YT")
                .when().get("/pays/{codeIso31661}/informations")
                .then()
                .statusCode(404)
                .contentType("text/plain")
                .body(is("Pas d'information pour ce pays"));
    }

    @Test
    public void testGetInformationByCodePaysWithoutTypeInfoEndpoint_NotFound() {
        given()
                .pathParam("codeIso31661", "ZZZ")
                .when().get("/pays/{codeIso31661}/informations")
                .then()
                .statusCode(404)
                .contentType("text/plain")
                .body(is("Cet id de pays n'existe pas !"));
    }

    @Test
    public void testGetInformationbyPaysEndpoint() {
        String codeIso31661 = "FR";
        int idTypeInfo = 1;
        given()
                .pathParam("codeIso31661", codeIso31661)
                .pathParam("idTypeInfo", idTypeInfo)
                .when().get("/pays/{codeIso31661}/informations?idTypeInfo={idTypeInfo}")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);
    }

    @Test
    public void testGetInformationbyPaysEndpoint_NotFound() {
        String codeIso31661 = "FR";
        int idTypeInfo = 9999;
        given()
                .pathParam("codeIso31661", codeIso31661)
                .pathParam("idTypeInfo", idTypeInfo)
                .when().get("/pays/{codeIso31661}/informations?idTypeInfo={idTypeInfo}")
                .then()
                .statusCode(404)
                .contentType("text/plain")
                .body(is("L'id de type d'info n'existe pas"));
    }
}
