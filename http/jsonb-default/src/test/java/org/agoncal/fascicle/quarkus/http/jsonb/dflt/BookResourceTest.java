package org.agoncal.fascicle.quarkus.http.jsonb.dflt;

import io.quarkus.test.junit.QuarkusTest;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static javax.ws.rs.core.HttpHeaders.ACCEPT;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.OK;

// @formatter:off
@QuarkusTest
public class BookResourceTest {

  @Test
  public void shouldGetBookAsString() {
    given()
      .header(ACCEPT, APPLICATION_JSON).
    when()
      .get("/api/books/string").
    then()
      .statusCode(OK.getStatusCode())
      .body("title", Is.is("H2G2"))
      .body("isbn", Is.is("1-84023-742-2"));
  }

  @Test
  public void shouldGetBookAsResponseString() {
    given()
      .header(ACCEPT, APPLICATION_JSON).
    when()
      .get("/api/books/stringresp").
    then()
      .statusCode(OK.getStatusCode())
      .body("title", Is.is("H2G2"))
      .body("isbn", Is.is("1-84023-742-2"));
  }

  @Test
  public void shouldGetBook() {
    given()
      .header(ACCEPT, APPLICATION_JSON).
    when()
      .get("/api/books/book").
    then()
      .statusCode(OK.getStatusCode())
      .body("title", Is.is("H2G2"))
      .body("isbn", Is.is("1-84023-742-2"));
  }

  @Test
  public void shouldGetBookAsResponse() {
    given()
      .header(ACCEPT, APPLICATION_JSON).
    when()
      .get("/api/books/bookresp").
    then()
      .statusCode(OK.getStatusCode())
      .body("title", Is.is("H2G2"))
      .body("isbn", Is.is("1-84023-742-2"));
  }
}
