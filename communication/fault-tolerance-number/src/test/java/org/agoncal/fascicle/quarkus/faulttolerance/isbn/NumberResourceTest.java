package org.agoncal.fascicle.quarkus.faulttolerance.isbn;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static jakarta.ws.rs.core.Response.Status.OK;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.not;

// @formatter:off
@QuarkusTest
public class NumberResourceTest {

  @Test
  void shouldGenerateIsbnWithSeparator() {
    given()
      .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
      .queryParam("separator", true).
    when()
      .get("/api/numbers/isbn").
    then()
      .statusCode(OK.getStatusCode())
      .body("$", hasKey("isbn13"))
      .body("isbn13", containsString("-"))
      .body("$", hasKey("gs1"));
  }

  @Test
  void shouldGenerateIsbn() {
    given()
      .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON).
    when()
      .get("/api/numbers/isbn").
    then()
      .statusCode(OK.getStatusCode())
      .body("$", hasKey("isbn13"))
      .body("isbn13", containsString("-"))
      .body("$", hasKey("gs1"));
  }

  @Test
  void shouldGenerateIsbnWithoutSeparator() {
    given()
      .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
      .queryParam("separator", false).
    when()
      .get("/api/numbers/isbn").
    then()
      .statusCode(OK.getStatusCode())
      .body("$", hasKey("isbn13"))
      .body("isbn13", not(containsString("-")))
      .body("$", hasKey("gs1"));
  }

  @Test
  void shouldGenerateIssn() {
    given()
      .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON).
      when()
      .get("/api/numbers/issn").
      then()
      .statusCode(OK.getStatusCode())
      .body("$", hasKey("isbn10"));
  }
}
