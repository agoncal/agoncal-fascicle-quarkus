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
// tag::adocBegin[]
@QuarkusTest
public class ArtistResourceTest {

  // end::adocBegin[]
  // ======================================
  // =              Methods               =
  // ======================================

  @Test
  @Order(1)
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
  @Order(2)
  public void shouldGetArtist() {
    // tag::adocShouldGetArtist[]
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
    // end::adocShouldGetArtist[]
  }

  @Test
  @Order(3)
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
  @Order(4)
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
    // tag::adocShouldDeleteArtist[]
    UUID id = given().get("/artists").then().extract().response().jsonPath().getUUID("id[0]");

    given().
      pathParam("id", id).
    when().
      delete("/artists/{id}").
    then().
      assertThat().
        statusCode(is(204));
    // end::adocShouldDeleteArtist[]
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
}
