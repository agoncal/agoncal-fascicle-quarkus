package org.agoncal.fascicle.quarkus.gettingstarted;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsString;

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
    when().
      get("/artists").
    then().
      assertThat().
        statusCode(is(200)).
      and().
        body("first_name[0]", containsString("John")).
        body("first_name[1]", containsString("Paul")).
        body("first_name[2]", containsString("George")).
        body("first_name[3]", containsString("Ringo"));
  }

  @Test
  public void shouldCountArtist() {
    given().
    when().
      get("/artists/count").
    then().
      assertThat().
        statusCode(is(200)).
      and().
        body(is("4"));
  }
}
// end::adocSnippet[]
