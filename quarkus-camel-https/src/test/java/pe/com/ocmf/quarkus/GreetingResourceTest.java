package pe.com.ocmf.quarkus;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;


@QuarkusTest
class GreetingResourceTest {
    @Test
    void testGetExtensionsById() {
        given()
          .when().get("/api/extensions?id=io.quarkus:quarkus-hibernate-validator")
          .then()
             .statusCode(200)
             .body("$.size()", is(2),
                     "[0].id", is("io.quarkus:quarkus-hibernate-validator"));
    }

}