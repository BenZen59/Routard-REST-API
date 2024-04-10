package fr.bz.resources;

import fr.bz.dto.FormaliteExigenceDto;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;
@QuarkusTest
class FormaliteEntreeResourcesTest {

    @Test
    void getFormalitesAdmin() {
        given()
               .when()
               .get("/formalites_entree/CN/formalites_admins")
               .then()
               .contentType(MediaType.APPLICATION_JSON)
               .statusCode(200);

    }

    @Test
    void getFormalitesMedicale() {
        given()
                .when()
                .get("/formalites_entree/CN/formalites_medicales")
                .then()
                .contentType(MediaType.APPLICATION_JSON)
                .statusCode(200);
    }

    @Test
    void getVisaExemptedPays() {
        given()
                .when()
                .get("/formalites_entree/CN/visa_exempte")
                .then()
                .contentType(MediaType.APPLICATION_JSON)
                .statusCode(200);
    }
}