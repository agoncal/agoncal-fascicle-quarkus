package org.agoncal.fascicle.quarkus.core.logging;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static jakarta.ws.rs.core.Response.Status.NO_CONTENT;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
@QuarkusTest
public class InjectedLoggingResourceTest {

  @Test
  public void shouldDisplayLogs() {
    given().
    when()
      .get("/logs/inject").
    then()
      .statusCode(NO_CONTENT.getStatusCode());
  }
}
