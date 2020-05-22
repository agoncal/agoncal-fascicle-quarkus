package org.agoncal.fascicle.quarkus.gettingstarted;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import javax.ws.rs.core.MediaType;

import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */

// @formatter:off
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
// tag::adocSnippet[]
@QuarkusTest
public class ArtistResourceTest {

  @Test
  // tag::adocSkip[]
  @Order(1)
  // end::adocSkip[]
  public void shouldGetAllArtists() {
    given().
    when().
      get("/artists").
    then().
      assertThat().
        statusCode(is(200)).
      and().
        body("size()", is(4));
  }

  @Test
  // tag::adocSkip[]
  @Order(2)
  // end::adocSkip[]
  public void shouldGetArtist() {
    UUID id = given().get("/artists").then().extract().response().jsonPath().getUUID("id[0]");

    given().
      pathParam("id", id).
    when().
      get("/artists/{id}").
    then().
      assertThat().
        statusCode(is(200)).
      and().
        body(containsString("John"));
  }

  @Test
  // tag::adocSkip[]
  @Order(3)
  // end::adocSkip[]
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
  // tag::adocSkip[]
  @Test
  @Order(4)
  public void shouldCreateArtist() {
    Artist artist = new Artist().firstName("George").lastName("Martin");
    given().
      contentType(MediaType.APPLICATION_JSON).
      body(artist).
    when().
      post("/artists").
    then().
      assertThat().
        statusCode(is(201));
  }

  @Test
  @Order(5)
  public void shouldCountArtistAfterCreate() {
    given().
    when().
      get("/artists/count").
    then().
      assertThat().
        statusCode(is(200)).
      and().
        body(is("5"));
  }


  @Test
  @Order(6)
  public void shouldDeleteArtist() {
    UUID id = given().get("/artists").then().extract().response().jsonPath().getUUID("id[0]");

    given().
      pathParam("id", id).
    when().
      delete("/artists/{id}").
    then().
      assertThat().
        statusCode(is(204));
  }

  @Test
  @Order(7)
  public void shouldCountArtistAfterDelete() {
    given().
    when().
      get("/artists/count").
    then().
      assertThat().
        statusCode(is(200)).
      and().
        body(is("4"));
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
