package org.agoncal.fascicle.quarkus.http.jaxrs.ex02;

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
      .get("/items/toprated").
    then()
      .statusCode(OK.getStatusCode());
  }
}
