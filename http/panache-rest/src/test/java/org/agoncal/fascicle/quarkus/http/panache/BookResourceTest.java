package org.agoncal.fascicle.quarkus.http.panache;

import io.quarkus.test.junit.QuarkusTest;
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
public class BookResourceTest {

  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test
  public void shouldGetBooks() {
      given()
        .header(ACCEPT, APPLICATION_JSON).
      when()
        .get("/book").
      then()
        .statusCode(OK.getStatusCode());
  }

  @Test
  public void shouldCreateBook() {
    Book book = new Book();
    book.title = "H2G2";
    book.isbn = "1234-5678";
    book.nbOfPage = 123;

    given()
      .body(book)
      .header(CONTENT_TYPE, APPLICATION_JSON)
      .header(ACCEPT, APPLICATION_JSON).
    when()
      .post("/book").
    then()
      .statusCode(CREATED.getStatusCode());
  }

//  @Test
//  public void shouldUpdateCustomer() {
//    Customer customer = new Customer("John", "Smith", "jsmith@gmail.com", "1334565");
//
//    given()
//      .body(customer)
//      .header(CONTENT_TYPE, APPLICATION_JSON)
//      .header(ACCEPT, APPLICATION_JSON).
//    when()
//      .put("/customers").
//    then()
//      .statusCode(OK.getStatusCode())
//      .header(CONTENT_TYPE, APPLICATION_JSON)
//      .body("firstName", Is.is("JohnUpdated"));
//  }
//
//  @Test
//  public void shouldDeleteBook() {
//    // Deletes the previously created book
//    given()
//      .pathParam("customerId", 1234).
//    when()
//      .delete("/customers/{customerId}").
//    then()
//      .statusCode(NO_CONTENT.getStatusCode());
//  }
}
