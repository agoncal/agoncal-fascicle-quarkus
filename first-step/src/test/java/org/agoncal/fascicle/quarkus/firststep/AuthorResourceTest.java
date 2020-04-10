package org.agoncal.fascicle.quarkus.firststep;

import io.quarkus.test.junit.QuarkusTest;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.get;

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
    // tag::adocShouldGetAllAuthors[]
    get("/authors").
    then()
      .statusCode(200)
      .body(Is.is("Isaac Asimov, Ray Bradbury, Douglas Adams"));
    // end::adocShouldGetAllAuthors[]
  }

  @Test
  public void shouldGetAnAuthor() {
    // tag::adocShouldGetAuthor[]
    get("/authors/0").
    then()
      .statusCode(200)
      .body(Is.is("Isaac Asimov"));
    // end::adocShouldGetAuthor[]
  }

  @Test
  public void shouldNotFindResource() {
    // tag::adocShouldNotFindResource[]
    get("/dummy").
    then()
      .statusCode(404);
    // end::adocShouldNotFindResource[]
  }
}
// end::adocSnippet[]
