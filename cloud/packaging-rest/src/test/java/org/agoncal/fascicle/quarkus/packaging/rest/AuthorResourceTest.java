package org.agoncal.fascicle.quarkus.packaging.rest;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.get;
import static org.hamcrest.core.Is.is;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// @formatter:off
// tag::adocSnippet[]
@QuarkusTest
public class AuthorResourceTest {

  @Test
  public void shouldGetAllAuthors() {
    get("/authors").
    then()
      .assertThat()
        .statusCode(is(200))
      .and()
        .body(is("Isaac Asimov, Ray Bradbury, Douglas Adams"));
  }

  @Test
  public void shouldGetAnAuthor() {
    get("/authors/0").
    then()
      .assertThat()
        .statusCode(is(200))
      .and()
        .body(is("Isaac Asimov"));
  }
}
// end::adocSnippet[]
