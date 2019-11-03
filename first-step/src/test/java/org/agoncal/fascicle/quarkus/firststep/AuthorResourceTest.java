package org.agoncal.fascicle.quarkus.firststep;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class AuthorResourceTest {

  // @formatter:off
  @Test
  public void shouldGetAllScifiAuthors() {
    // tag::adocShouldGetAllAuthors[]
    given().
    when().
      get("/authors").
    then().
      statusCode(200).
      body(is("Isaac Asimov, Ray Bradbury, Douglas Adams"));
    // end::adocShouldGetAllAuthors[]
  }

  @Test
  public void shouldGet1stScifiAuthor() {
    // tag::adocShouldGetAuthor[]
    given().
    when().
      get("/authors/0").
    then().
      statusCode(200).
      body(is("Isaac Asimov"));
    // end::adocShouldGetAuthor[]
  }
  // @formatter:on

  @Test
  public void shouldGet2ndScifiAuthor() {
    given()
      .when().get("/authors/1")
      .then()
      .statusCode(200)
      .body(is("Ray Bradbury"));
  }
}
