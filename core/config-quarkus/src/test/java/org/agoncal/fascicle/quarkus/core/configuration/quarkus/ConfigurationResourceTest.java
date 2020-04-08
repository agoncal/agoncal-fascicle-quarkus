package org.agoncal.fascicle.quarkus.core.configuration.quarkus;

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
public class ConfigurationResourceTest {

  @Test
  public void shouldDisplayConfiguration() {
    given().
    when()
      .get("/config/quarkus/test").
    then()
      .statusCode(NO_CONTENT.getStatusCode());
  }
}
