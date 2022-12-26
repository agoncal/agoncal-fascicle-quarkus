package org.agoncal.fascicle.quarkus.restclient.issn;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static jakarta.ws.rs.core.Response.Status.OK;
import static org.hamcrest.Matchers.hasKey;

// @formatter:off
@QuarkusTest
public class IssnResourceTest {

  @Test
  void shouldGenerateIssn() {
    given()
      .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON).
    when()
      .get("/api/issn").
    then()
      .statusCode(OK.getStatusCode())
      .body("$", hasKey("issn"));
  }
}
