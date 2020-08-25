package org.agoncal.fascicle.quarkus.gettingstarted;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */

// tag::adocSnippet[]
@QuarkusTest
public class ArtistResourceTest {

  @Test
  public void shouldGetAllArtists() {
    given().
    when()
      .get("/artists").
    then()
      .assertThat()
        .statusCode(is(200))
      .and()
        .body("size()", equalTo(4));
  }

  @Test
  public void shouldCountArtist() {
    given().
    when()
      .get("/artists/count").
    then()
      .assertThat()
        .statusCode(is(200))
      .and()
        .body(is("4"));
  }
}
// end::adocSnippet[]
