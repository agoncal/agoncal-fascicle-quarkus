package org.agoncal.fascicle.quarkus.faulttolerance.book;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static jakarta.ws.rs.core.Response.Status.OK;
import static org.hamcrest.Matchers.hasKey;

// @formatter:off
@QuarkusTest
public class BookResourceTest {

  @Test
  void shouldGenerateBookNumbers() {
    given()
      .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON).
    when()
      .get("/books/numbers").
    then()
      .statusCode(OK.getStatusCode())
      .body("$", hasKey("isbn13"));
  }

  @Test
  void shouldCreateABook() {
    given()
      .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON).
    when()
      .post("/books").
    then()
      .statusCode(OK.getStatusCode())
      .body("$", hasKey("title"))
      .body("$", hasKey("issn"));
  }

  @Test
  void shouldCreateALegacyBook() {
    given()
      .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON).
    when()
      .post("/books/legacy").
    then()
      .statusCode(OK.getStatusCode())
      .body("$", hasKey("title"))
      .body("$", hasKey("issn"));
  }
}
