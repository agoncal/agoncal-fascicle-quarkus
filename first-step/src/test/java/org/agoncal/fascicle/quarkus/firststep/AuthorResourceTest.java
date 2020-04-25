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
    get("/authors").
    then()
      .statusCode(200)
      .body(Is.is("Isaac Asimov, Ray Bradbury, Douglas Adams"));
  }

  @Test
  public void shouldGetAnAuthor() {
    get("/authors/0").
    then()
      .statusCode(200)
      .body(Is.is("Isaac Asimov"));
  }
}
// end::adocSnippet[]
