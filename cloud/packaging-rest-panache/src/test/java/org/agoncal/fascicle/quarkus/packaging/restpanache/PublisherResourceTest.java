package org.agoncal.fascicle.quarkus.packaging.restpanache;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// @formatter:off
@QuarkusTest
public class PublisherResourceTest {

  @Test
  void shouldFindAll() {
    get("/publishers").
    then()
      .statusCode(is(200));
  }

  @Test
  void shouldFindById() {
    given()
      .pathParam("id", 1001).
    when()
      .get("/publishers/{id}").
    then()
      .statusCode(is(200))
      .body("publisher_name", is("APress"));
  }

  @Test
  void shouldFindByName() {
    given()
      .pathParam("name", "APress").
    when()
      .get("/publishers/{name}").
    then()
      .statusCode(is(200))
      .body("publisher_name", is("APress"));
  }

  @Test
  void shouldDeleteById() {
  }

  @Test
  void shouldDeleteByName() {
  }

  @Test
  void shouldPersist() {
  }
}
