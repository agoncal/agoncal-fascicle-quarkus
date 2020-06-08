package org.agoncal.fascicle.quarkus.http.jaxrs.ex03;

import io.quarkus.test.junit.QuarkusTest;
import org.agoncal.fascicle.quarkus.http.jaxrs.Book;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static javax.ws.rs.core.HttpHeaders.ACCEPT;
import static javax.ws.rs.core.HttpHeaders.CONTENT_TYPE;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.CREATED;
import static javax.ws.rs.core.Response.Status.OK;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// @formatter:off
@QuarkusTest
public class ItemResourceTest {

  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test
  public void shouldCheckGetItemsURI() {
    given()
      .header(ACCEPT, APPLICATION_JSON).
    when()
      .get("/items").
    then()
      .statusCode(OK.getStatusCode());
  }

  @Test
  public void shouldCheckGetCDsURI() {
    given()
      .header(ACCEPT, APPLICATION_JSON).
    when()
      .get("/items/cds").
    then()
      .statusCode(OK.getStatusCode());
  }

  @Test
  public void shouldCheckGetBooksURI() {
    given()
      .header(ACCEPT, APPLICATION_JSON).
    when()
      .get("/items/books").
    then()
      .statusCode(OK.getStatusCode());
  }

  @Test
  public void shouldCheckPostBookURI() {
    Book book = new Book("The Hitchhiker's Guide to the Galaxy", 12.5F, "Science fiction comedy book", "1-84023-742-2", 354, false);

    given()
      .body(book)
      .header(CONTENT_TYPE, APPLICATION_JSON)
      .header(ACCEPT, APPLICATION_JSON).
    when()
      .post("/items/books").
    then()
      .statusCode(CREATED.getStatusCode());
  }
}
