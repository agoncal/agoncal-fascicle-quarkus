package org.agoncal.fascicle.quarkus.http.jaxrs.ex01;

import io.quarkus.test.junit.QuarkusTest;
import org.agoncal.fascicle.quarkus.http.jaxrs.Customer;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static javax.ws.rs.core.HttpHeaders.ACCEPT;
import static javax.ws.rs.core.HttpHeaders.CONTENT_TYPE;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.CREATED;
import static javax.ws.rs.core.Response.Status.NO_CONTENT;
import static javax.ws.rs.core.Response.Status.OK;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// @formatter:off
@QuarkusTest
public class CustomerResourceTest {

  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test
  public void shouldGetCustomers() {
    List<Customer> customers =
      given()
        .header(ACCEPT, APPLICATION_JSON).
      when()
        .get("/customers").
      then()
        .statusCode(OK.getStatusCode())
        .extract().body().as(ArrayList.class);

    assertEquals(2, customers.size());

  }

  @Test
  public void shouldGetCustomer() {
    given()
      .header(ACCEPT, APPLICATION_JSON)
      .pathParam("customerId", 1234).
    when()
      .get("/customers/{customerId}").
    then()
      .statusCode(OK.getStatusCode())
      .body("email", Is.is("jsmith@gmail.com"))
      .body("firstName", Is.is("John"))
      .body("lastName", Is.is("Smith"));
  }

  @Test
  public void shouldCreateCustomer() {
    Customer customer = new Customer("John", "Smith", "jsmith@gmail.com", "1334565");

    given()
      .body(customer)
      .header(CONTENT_TYPE, APPLICATION_JSON)
      .header(ACCEPT, APPLICATION_JSON).
    when()
      .post("/customers").
    then()
      .statusCode(CREATED.getStatusCode());
  }

  @Test
  public void shouldUpdateCustomer() {
    Customer customer = new Customer("John", "Smith", "jsmith@gmail.com", "1334565");

    given()
      .body(customer)
      .header(CONTENT_TYPE, APPLICATION_JSON)
      .header(ACCEPT, APPLICATION_JSON).
    when()
      .put("/customers").
    then()
      .statusCode(OK.getStatusCode())
      .header(CONTENT_TYPE, APPLICATION_JSON)
      .body("firstName", Is.is("JohnUpdated"));
  }

  @Test
  public void shouldDeleteCustomer() {
    // Deletes the previously created book
    given()
      .pathParam("customerId", 1234).
    when()
      .delete("/customers/{customerId}").
    then()
      .statusCode(NO_CONTENT.getStatusCode());
  }
}
