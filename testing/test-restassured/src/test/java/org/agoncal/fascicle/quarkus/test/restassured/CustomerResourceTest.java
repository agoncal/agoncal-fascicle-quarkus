package org.agoncal.fascicle.quarkus.test.restassured;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static javax.ws.rs.core.HttpHeaders.ACCEPT;
import static javax.ws.rs.core.HttpHeaders.CONTENT_TYPE;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// @formatter:off
@QuarkusTest
public class CustomerResourceTest {

  @Test
  public void shouldListCustomers() {
    // tag::adocShouldListCustomers[]
    given().
    when()
      .get("/customers").
    then()
      .statusCode(200);
    // end::adocShouldListCustomers[]
  }

  @Test
  public void shouldListCustomersWithBase() {
    given()
      .baseUri("http://localhost:8081").
    when()
      .get("/customers").
    then()
      .statusCode(200);
  }

  @Test
  public void shouldListCustomersWithBaseAndHeader() {
    // tag::adocShouldListCustomersWithBaseAndHeader[]
    given()
      .baseUri("http://localhost:8081")
      .header(ACCEPT, APPLICATION_JSON).
    when()
      .get("/customers").
    then()
      .statusCode(200);
    // end::adocShouldListCustomersWithBaseAndHeader[]
  }

  @Test
  public void shouldListCustomersWithBaseAndAcceptHeader() {
    given()
      .baseUri("http://localhost:8081")
      .accept(APPLICATION_JSON).
    when()
      .get("/customers").
    then()
      .statusCode(200);
  }

  @Test
  public void shouldGetACustomer() {
    // tag::adocShouldGetACustomer[]
    given()
      .baseUri("http://localhost:8081")
      .header(ACCEPT, APPLICATION_JSON)
      .pathParam("id", 1L).
    when()
      .get("/customers/{id}").
    then()
      .statusCode(200);
    // end::adocShouldGetACustomer[]
  }

  @Test @Disabled
  public void shouldGetCustomers() {
    Customer customer =
    given()
      .accept(APPLICATION_JSON)
      .pathParam("id", 1L).
    when()
      .get("/customers/{id}").
    then()
      .statusCode(200)
      .extract().as(Customer.class);

    Assertions.assertEquals("John",customer.getFirstName());
  }

  @Test
  public void shouldGetCustomersThen() {
    // tag::shouldGetCustomersThen[]
    given()
      .pathParam("id", 1L).
    when()
      .get("/customers/{id}").
    then()
      .statusCode(200)
      .contentType(APPLICATION_JSON)
      .body("first-name", is("John"))
      .body("last-name", is("Lennon"));
    // end::shouldGetCustomersThen[]
  }

  @Test
  public void shouldGetCustomersJSonContainsContentXML() {
    given()
      .accept("application/xml").
    when()
      .get("/customers").
    then()
      .statusCode(406);
  }

  @Test
  public void shouldCountCustomers() {
    given().
    when()
      .get("/customers/count").
    then()
      .statusCode(200);
  }

  @Test
  public void shouldCountCustomersBody() {
    given().
    when()
      .get("/customers/count").
    then()
      .statusCode(200)
      .body(containsString("4"))
      .contentType(ContentType.TEXT);
  }

  @Test
  public void shouldCreateACustomer() {
    // tag::shouldCreateACustomer[]
    Customer customer = new Customer().firstName("John").lastName("Lennon");

    given()
      .body(customer)
      .header(CONTENT_TYPE, APPLICATION_JSON)
      .header(ACCEPT, APPLICATION_JSON).
    when()
      .post("/customers").
    then()
      .statusCode(201);
    // end::shouldCreateACustomer[]
  }

  @Test
  public void shouldCreateACustomerWithLocation() {
    Customer customer = new Customer().firstName("John").lastName("Lennon");

    String location =
    given()
      .body(customer)
      .header(CONTENT_TYPE, APPLICATION_JSON)
      .header(ACCEPT, APPLICATION_JSON).
    when()
      .post("/customers").
    then()
      .statusCode(201)
      .extract().header("Location");
    assertTrue(location.contains("/customers"));
  }
}
