package org.agoncal.fascicle.quarkus.core.logging;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static javax.ws.rs.core.Response.Status.NO_CONTENT;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
@QuarkusTest
public class LoggingResourceTest {

  @Test
  public void shouldDisplayLogs() {
    given().
    when()
      .get("/logs").
    then()
      .statusCode(NO_CONTENT.getStatusCode());
  }
}
