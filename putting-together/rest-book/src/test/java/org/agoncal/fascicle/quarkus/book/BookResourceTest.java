package org.agoncal.fascicle.quarkus.book;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;
import static javax.ws.rs.core.Response.Status.OK;
import static org.hamcrest.Matchers.hasKey;

//@formatter:off
// tag::adocHeader[]
@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookResourceTest {

  @Test
  void shouldPingOpenAPI() {
    given()
      .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON).
    when()
      .get("/openapi").
    then()
      .statusCode(NOT_FOUND.getStatusCode());
  }

  @Test
  void shouldPingSwaggerUI() {
    given().
    when()
      .get("/swagger-ui").
    then()
      .statusCode(NOT_FOUND.getStatusCode());
  }

  @Test
  public void shouldNotFindDummy() {
    given().
    when()
      .get("/api/books/dummy").
    then()
      .statusCode(NOT_FOUND.getStatusCode());
  }

  @Test
  void shouldGetRandomBook() {
    given()
      .when().get("/api/books").
    then()
      .statusCode(OK.getStatusCode())
      .body("$", hasKey("isbn_13"))
      .body("$", hasKey("isbn_10"))
      .body("$", hasKey("title"))
      .body("$", hasKey("author"))
      .body("$", hasKey("genre"))
      .body("$", hasKey("publisher"));
  }
}
