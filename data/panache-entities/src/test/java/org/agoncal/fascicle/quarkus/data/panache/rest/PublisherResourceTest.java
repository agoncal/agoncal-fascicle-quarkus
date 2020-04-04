package org.agoncal.fascicle.quarkus.data.panache.rest;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.common.mapper.TypeRef;
import org.agoncal.fascicle.quarkus.data.panache.model.Publisher;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Random;

import static io.restassured.RestAssured.given;
import static javax.ws.rs.core.HttpHeaders.ACCEPT;
import static javax.ws.rs.core.HttpHeaders.CONTENT_TYPE;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.CREATED;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;
import static javax.ws.rs.core.Response.Status.NO_CONTENT;
import static javax.ws.rs.core.Response.Status.OK;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTest
class PublisherResourceTest {

  private static final String DEFAULT_NAME = "Name";
  private static final String UPDATED_NAME = "Name (updated)";

  private static int nbPublishers;
  private static String publisherId;

  @Test
  void shouldNotGetUnknownPublisher() {
    Long randomId = new Random().nextLong();
    given()
      .pathParam("id", randomId)
      .when().get("/publishers/{id}")
      .then()
      .statusCode(NOT_FOUND.getStatusCode());
  }

  @Test
  @Order(1)
  void shouldGetInitialPublishers() {
    List<Publisher> publishers =
      given().
        when()
        .get("/publishers").
        then()
        .statusCode(OK.getStatusCode())
        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
        .extract().body().as(getPublisherTypeRef());

    nbPublishers = publishers.size();
    assertTrue(nbPublishers > 0);
  }

  private TypeRef<List<Publisher>> getPublisherTypeRef() {
    return new TypeRef<List<Publisher>>() {
    };
  }

  @Test
  @Order(2)
  void shouldAddAPublisher() {
    Publisher publisher = new Publisher();
    publisher.name = DEFAULT_NAME;

    // Persists a new publisher
    String location =
      given()
        .body(publisher)
        .header(CONTENT_TYPE, APPLICATION_JSON)
        .header(ACCEPT, APPLICATION_JSON).
        when()
        .post("/publishers").
        then()
        .statusCode(CREATED.getStatusCode())
        .extract().header("Location");

    // Extracts the Location and stores the publisher id
    assertTrue(location.contains("/publishers"));
    String[] segments = location.split("/");
    publisherId = segments[segments.length - 1];
    assertNotNull(publisherId);

    // Checks the publisher has been created
    given()
      .pathParam("id", publisherId).
      when()
      .get("/publishers/{id}").
      then()
      .statusCode(OK.getStatusCode())
      .header(CONTENT_TYPE, APPLICATION_JSON)
      .body("name", Is.is(DEFAULT_NAME));

    // Checks there is an extra publisher in the database
    List<Publisher> publishers =
      given().
        when()
        .get("/publishers").
        then()
        .statusCode(OK.getStatusCode())
        .header(CONTENT_TYPE, APPLICATION_JSON)
        .extract().body().as(getPublisherTypeRef());

    assertEquals(nbPublishers + 1, publishers.size());
  }
  // end::adocShouldAddAnItem[]

  // tag::adocShouldUpdateAnItem[]
  @Test
  @Order(3)
  void shouldUpdateAnItem() {
    Publisher publisher = new Publisher();
    publisher.id = Long.valueOf(publisherId);
    publisher.name = UPDATED_NAME;

    // Updates the previously created publisher
    given()
      .body(publisher)
      .header(CONTENT_TYPE, APPLICATION_JSON)
      .header(ACCEPT, APPLICATION_JSON).
      when()
      .put("/publishers").
      then()
      .statusCode(OK.getStatusCode())
      .header(CONTENT_TYPE, APPLICATION_JSON)
      .body("name", Is.is(UPDATED_NAME));
  }

  @Test
  @Order(4)
  void shouldRemoveAnItem() {
    // Deletes the previously created publisher
    given()
      .pathParam("id", publisherId).
      when()
      .delete("/publishers/{id}").
      then()
      .statusCode(NO_CONTENT.getStatusCode());

    // Checks there is less a publisher in the database
    List<Publisher> publishers =
      given().
        when()
        .get("/publishers").
        then()
        .statusCode(OK.getStatusCode())
        .header(CONTENT_TYPE, APPLICATION_JSON)
        .extract().body().as(getPublisherTypeRef());

    assertEquals(nbPublishers, publishers.size());
  }
  // end::adocShouldRemoveAnItem[]
}
