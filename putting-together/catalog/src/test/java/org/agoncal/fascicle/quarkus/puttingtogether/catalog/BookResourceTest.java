package org.agoncal.fascicle.quarkus.puttingtogether.catalog;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class BookResourceTest {

  @Test @Disabled
  public void checkHealth() {
    given()
      .when().get("/books/health")
      .then()
      .statusCode(200);
//      .body(is("Alive and Kicking !!!"));
  }
}
