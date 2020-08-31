package org.agoncal.fascicle.quarkus.test.jvmnativemode;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

// @formatter:off
// tag::adocSnippet[]
@QuarkusTest
public class ArtistResourceTest {

  @Test
  public void shouldGetAllArtists() {
    given().
    when()
      .get("/artists").
    then()
      .statusCode(is(200));
  }
}
// end::adocSnippet[]
