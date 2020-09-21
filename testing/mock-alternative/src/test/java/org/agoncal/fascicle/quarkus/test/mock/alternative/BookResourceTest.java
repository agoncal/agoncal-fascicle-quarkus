package org.agoncal.fascicle.quarkus.test.mock.alternative;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static javax.ws.rs.core.Response.Status.OK;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.core.Is.is;

// @formatter:off
@QuarkusTest
public class BookResourceTest {

  @Test
  void shouldGetRandomBook() {
    given()
      .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON).
    when()
      .get("/api/books").
    then()
      .statusCode(OK.getStatusCode())
      .body("isbn_10", is("@Alternative isbn 10"))
      .body("isbn_13", is("@Alternative isbn 13"))
      .body("$", hasKey("title"))
      .body("$", hasKey("author"));
  }
}
