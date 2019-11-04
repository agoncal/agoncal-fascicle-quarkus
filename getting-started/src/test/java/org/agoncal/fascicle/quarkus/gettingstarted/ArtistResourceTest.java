package org.agoncal.fascicle.quarkus.gettingstarted;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */


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
      statusCode(200).
      and().
      body(containsString("John"));

//    Response response = target("/artists").request().get();
//    assertEquals(200, response.getStatus());
//    String artists = response.readEntity(String.class);
//    assertEquals("John", JsonPath.parse(artists).read("$.[0].firstName"));
//    assertEquals("Lennon", JsonPath.parse(artists).read("$.[0].lastName"));
    // end::adocShouldGetAllAuthors[]
  }
//
//  @Test
//  public void shouldGetArtist() {
//    // tag::adocShouldGetArtist[]
//    String artists = target("/artists").request().get(String.class);
//    String id = JsonPath.parse(artists).read("$.[0].id");
//    Response response = target("/artists").path(id).request().get();
//    assertEquals(200, response.getStatus());
//    String artist = response.readEntity(String.class);
//    assertEquals("John", JsonPath.parse(artist).read("$.firstName"));
//    assertEquals("Lennon", JsonPath.parse(artist).read("$.lastName"));
//    // end::adocShouldGetArtist[]
//  }
//
//  @Test
//  public void shouldCountArtist() {
//    // tag::shouldCountArtist[]
//    Response response = target("/artists/count").request().get();
//    assertEquals(200, response.getStatus());
//    // end::shouldCountArtist[]
//  }
//
//  @Test
//  public void shouldCreateArtist() {
//    // tag::adocShouldCreateArtist[]
//    Integer nbArtists = target("/artists/count").request().get(Integer.class);
//    Artist artist = new Artist().firstName("George").lastName("Martin");
//    Response response = target("/artists").request().post(Entity.json(artist));
//    assertEquals(201, response.getStatus());
//    assertEquals(new Integer(nbArtists + 1), target("/artists/count").request().get(Integer.class));
//    // end::adocShouldCreateArtist[]
//  }
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
