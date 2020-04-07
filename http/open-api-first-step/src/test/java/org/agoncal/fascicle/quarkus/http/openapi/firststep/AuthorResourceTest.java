package org.agoncal.fascicle.quarkus.http.openapi.firststep;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static javax.ws.rs.core.HttpHeaders.ACCEPT;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.OK;
import static org.hamcrest.CoreMatchers.is;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
//@formatter:off
@QuarkusTest
public class AuthorResourceTest {

  @Test
  public void shouldGetAnAuthor() {
    given()
      .pathParam("index", 0).
    when()
      .get("/authors/{index}").
    then()
      .statusCode(OK.getStatusCode())
      .body(is("Isaac Asimov"));
  }

  @Test
  void shouldPingOpenAPI() {
    given()
      .header(ACCEPT, APPLICATION_JSON).
      when()
      .get("/openapi").
      then()
      .statusCode(OK.getStatusCode());
  }

  @Test
  void shouldPingSwaggerUI() {
    given().
      when()
      .get("/swagger-ui").
      then()
      .statusCode(OK.getStatusCode());
  }
}
