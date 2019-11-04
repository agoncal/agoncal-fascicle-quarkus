package org.agoncal.fascicle.quarkus.firststep;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

// @formatter:off
// tag::adocSnippet[]
@QuarkusTest
public class AuthorResourceTest {

  @Test
  public void shouldGetAllScifiAuthors() {
    given().
    when().
      get("/authors").
    then().
      statusCode(200).
        and().
      body(is("Isaac Asimov, Ray Bradbury, Douglas Adams"));
  }

  @Test
  public void shouldGetScifiAuthor() {
    given().
    when().
      get("/authors/0").
    then().
      statusCode(200).
        and().
      body(is("Isaac Asimov"));
  }
}
// end::adocSnippet[]
