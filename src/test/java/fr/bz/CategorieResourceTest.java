package fr.bz;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class CategorieResourceTest {
    @Test
    public void testGetAllCategories() {
        given()
                .when().get("/categories/")
                .then()
                .statusCode(200);
        // You may add more assertions here based on the expected behavior
    }
}
