package org.agoncal.fascicle.quarkus.number;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;
import static javax.ws.rs.core.Response.Status.OK;
import static org.hamcrest.Matchers.hasKey;

// @formatter:off
// tag::adocSnippet[]
@QuarkusTest
public class NumberResourceTest {

  @Test
  void shouldGenerateIsbnNumbers() {
    given()
      .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON).
    when()
      .get("/api/numbers").
    then()
      .statusCode(OK.getStatusCode())
      .body("$", hasKey("isbn_10"))
      .body("$", hasKey("isbn_13"));
  }
  // tag::adocSkip[]

  @Test
  void shouldPingOpenAPI() {
    given()
      .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON).
    when()
      .get("/q/openapi").
    then()
      .statusCode(OK.getStatusCode());
  }

  @Test
  void shouldPingSwaggerUI() {
    given().
    when()
      .get("/q/swagger-ui").
    then()
      .statusCode(OK.getStatusCode());
  }

  @Test
  void shouldPingLiveness() {
    given().
    when()
      .get("/health/live").
    then()
      .statusCode(OK.getStatusCode());
  }

  @Test
  void shouldPingReadiness() {
    given().
    when()
      .get("/health/ready").
    then()
      .statusCode(OK.getStatusCode());
  }

  @Test
  void shouldPingMetrics() {
    given()
      .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON).
    when()
      .get("/metrics/application").
    then()
      .statusCode(NOT_FOUND.getStatusCode());
  }

  @Test
  void shouldNotFindDummy() {
    given().
    when()
      .get("/api/numbers/dummy").
    then()
      .statusCode(NOT_FOUND.getStatusCode());
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
