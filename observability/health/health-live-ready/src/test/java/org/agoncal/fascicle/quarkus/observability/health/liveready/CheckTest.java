package org.agoncal.fascicle.quarkus.observability.health.liveready;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

//@formatter:off
@QuarkusTest
public class CheckTest {

  @Test
  void shouldPingHealth() {
    given().
    when()
      .get("/q/health").
    then()
      .statusCode(503);
  }

  @Test
  void shouldPingLiveness() {
    given().
    when()
      .get("/q/health/live").
    then()
      .statusCode(200);
  }

  @Test
  void shouldPingReadiness() {
    given().
    when()
      .get("/q/health/ready").
    then()
      .statusCode(503);
  }

  @Test
  void shouldPingStartup() {
    given().
    when()
      .get("/q/health/started").
    then()
      .statusCode(200);
  }
}
