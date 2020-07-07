package org.agoncal.fascicle.quarkus.faulttolerance.isbn;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static javax.ws.rs.core.Response.Status.OK;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.not;

// @formatter:off
@QuarkusTest
public class IsbnResourceTest {

  @Test
  void shouldGenerateIsbnWithSeparator() {
    given()
      .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
      .queryParam("separator", true).
    when()
      .get("/api/isbn").
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
      .get("/api/isbn").
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
      .get("/api/isbn").
    then()
      .statusCode(OK.getStatusCode())
      .body("$", hasKey("isbn13"))
      .body("isbn13", not(containsString("-")))
      .body("$", hasKey("gs1"));
  }
}
