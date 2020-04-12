package org.agoncal.fascicle.quarkus.http.jaxrs.ex04;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static javax.ws.rs.core.HttpHeaders.ACCEPT;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.OK;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
//@formatter:off
@QuarkusTest
public class CustomerResourceTest {

  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test
  public void shouldCheckSearchCustomerURI() {
    given()
      .header(ACCEPT, APPLICATION_JSON)
      .pathParam("text", "smith").
    when()
      .get("/customers/search/{text}").
    then()
      .statusCode(OK.getStatusCode());
  }

  @Test
  public void shouldCheckGetCustomerByLoginURI() {
    given()
      .header(ACCEPT, APPLICATION_JSON)
      .pathParam("login", "foobarsmith").
    when()
      .get("customers/{login}").
    then()
      .statusCode(OK.getStatusCode());
  }

  @Test
  public void shouldCheckGetCustomerByIdURI() {
    given()
      .header(ACCEPT, APPLICATION_JSON)
      .pathParam("customerId", 12345).
    when()
      .get("customers/{customerId}").
    then()
      .statusCode(OK.getStatusCode());
  }
}
