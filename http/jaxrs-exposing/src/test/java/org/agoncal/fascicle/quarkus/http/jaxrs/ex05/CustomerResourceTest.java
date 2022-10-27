package org.agoncal.fascicle.quarkus.http.jaxrs.ex05;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static jakarta.ws.rs.core.HttpHeaders.ACCEPT;
import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;
import static jakarta.ws.rs.core.Response.Status.OK;

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
  public void shouldCheckGetCustomerByZipCodeCity() {
    given()
      .header(ACCEPT, APPLICATION_JSON)
      .queryParam("zip", 75011L)
      .queryParam("city", "Lisbon").
    when()
      .get("/customers").
    then()
      .statusCode(OK.getStatusCode());
  }

  @Test @Disabled("https://github.com/rest-assured/rest-assured/issues/417")
  public void shouldCheckGetCustomerByFirstnameName() {
    given()
      .header(ACCEPT, APPLICATION_JSON).
    when()
      .get("/customers/search;firstname=Antonio;surname=Goncalves").
    then()
      .statusCode(OK.getStatusCode());
  }
}
