package org.agoncal.fascicle.quarkus.core.devservices;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static jakarta.ws.rs.core.Response.Status.NO_CONTENT;
import static jakarta.ws.rs.core.Response.Status.OK;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
@QuarkusTest
public class NumberGeneratorResourceTest {

  // ======================================
  // =              Methods               =
  // ======================================

  @Test
  public void shouldGetNumber() {
    given().
      when()
      .get("/numbers").
      then()
      .statusCode(OK.getStatusCode());
  }
}
