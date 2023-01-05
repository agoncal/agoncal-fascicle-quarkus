package org.agoncal.fascicle.quarkus.test.nativemode;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

// @formatter:off
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

  @Test @Disabled("Test is not implemented yet")
  public void shouldCreateAnArtist() {
    // some work to do
  }

  @Test
  public void shouldGetOneArtist() {
    given()
      .pathParam("id", 1).
    when()
      .get("/artists/{id}").
    then()
      .statusCode(is(200))
      .body("first_name", is("John"))
      .body("last_name", is("Lennon"));
  }
}
