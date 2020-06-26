package org.agoncal.fascicle.quarkus.http.jaxrs.ex01;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static javax.ws.rs.core.HttpHeaders.ACCEPT;
import static javax.ws.rs.core.MediaType.TEXT_PLAIN;
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
  public void shouldGetBook() {
      given()
        .header(ACCEPT, TEXT_PLAIN).
      when()
        .get("/book").
      then()
        .statusCode(OK.getStatusCode());
  }
}
