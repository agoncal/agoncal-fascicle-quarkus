package org.agoncal.fascicle.quarkus.puttingtogether.catalog;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
//@QuarkusTestResource(H2DatabaseTestResource.class)
public class BookResourceTest {

  @Test
  public void checkHealth() {
    given()
      .when().get("/books/health")
      .then()
      .statusCode(200);
//      .body(is("Alive and Kicking !!!"));
  }
}
