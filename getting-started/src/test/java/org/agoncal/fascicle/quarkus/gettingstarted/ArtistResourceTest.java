package org.agoncal.fascicle.quarkus.gettingstarted;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */

// @formatter:off
// tag::adocBegin[]
@QuarkusTest
public class ArtistResourceTest {

  // end::adocBegin[]
  // ======================================
  // =              Methods               =
  // ======================================

  @Test
  public void shouldGetAllArtists() {
    // tag::adocShouldGetAllArtists[]
    given().
    when().
      get("/artists").
    then().
      assertThat().
        statusCode(is(200)).
      and().
        body("size()", is(4));
    // end::adocShouldGetAllAuthors[]
  }

  @Test
  public void shouldGetArtist() {
      // tag::adocShouldGetArtist[]
//    String artists = given().get("/artists").then().extract().response().asString();
//    String id = JsonPath.parse(artists).read("$.[0].id");
//    Response response = target("/artists").path(id).request().get();
//    assertEquals(200, response.getStatus());
//    String artist = response.readEntity(String.class);
//    assertEquals("John", JsonPath.parse(artist).read("$.firstName"));
//    assertEquals("Lennon", JsonPath.parse(artist).read("$.lastName"));
    // end::adocShouldGetArtist[]
  }

  @Test
  public void shouldCountArtist() {
    // tag::shouldCountArtist[]
    given().
    when().
      get("/artists/count").
    then().
      assertThat().
        statusCode(is(200)).
      and().
        body(is("4"));
    // end::shouldCountArtist[]
  }

  @Test
  public void shouldCreateArtist() {
    // tag::adocShouldCreateArtist[]
    Artist artist = new Artist().firstName("George").lastName("Martin");
    given().
      contentType(MediaType.APPLICATION_JSON).
      body(artist).
    when().
      post("/artists").
    then().
      assertThat().
        statusCode(is(201));
    // end::adocShouldCreateArtist[]
  }
//
//  @Test
//  public void shouldDeleteArtist() {
//    // tag::adocShouldDeleteArtist[]
//    Integer nbArtists = target("/artists/count").request().get(Integer.class);
//    String artists = target("/artists").request().get(String.class);
//    String id = JsonPath.parse(artists).read("$.[0].id");
//    Response response = target("/artists").path(id).request().delete();
//    assertEquals(204, response.getStatus());
//    assertEquals(new Integer(nbArtists - 1), target("/artists/count").request().get(Integer.class));
//    // end::adocShouldDeleteArtist[]
//  }
}
