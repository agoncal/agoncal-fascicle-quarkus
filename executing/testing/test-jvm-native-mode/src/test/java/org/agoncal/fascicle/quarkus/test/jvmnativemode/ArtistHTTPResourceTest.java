package org.agoncal.fascicle.quarkus.test.jvmnativemode;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

// @formatter:off
// tag::adocSnippet[]
@QuarkusTest
@TestHTTPEndpoint(ArtistResource.class)
public class ArtistHTTPResourceTest {

  @Test
  public void shouldGetAllArtists() {
    given().
    when()
      .get().
    then()
      .statusCode(is(200));
  }

  @Test
  public void shouldGetOneArtist() {
    given()
      .pathParam("id", 1).
    when()
      .get("/{id}").
    then()
      .statusCode(is(200))
      .body("first_name", is("John"))
      .body("last_name", is("Lennon"));
  }
}
// end::adocSnippet[]
