package org.agoncal.fascicle.quarkus.puttingtogether.generator;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

@QuarkusTest
public class NumberResourceTest {

  @Test
  public void checkNumberGenerator() {
    given()
      .when().get("/api/numbers/book")
      .then()
      .statusCode(200)
      .body(containsString("BK"));
  }
}
