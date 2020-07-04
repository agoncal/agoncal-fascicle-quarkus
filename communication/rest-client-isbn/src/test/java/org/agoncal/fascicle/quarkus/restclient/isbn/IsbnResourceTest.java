package org.agoncal.fascicle.quarkus.restclient.isbn;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static javax.ws.rs.core.Response.Status.OK;
import static org.hamcrest.Matchers.hasKey;

// @formatter:off
@QuarkusTest
public class IsbnResourceTest {

  @Test
  void shouldGenerateIsbn() {
    given()
      .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON).
    when()
      .get("/api/isbn").
    then()
      .statusCode(OK.getStatusCode())
      .body("$", hasKey("isbn13"))
      .body("$", hasKey("gs1"));
  }
}
