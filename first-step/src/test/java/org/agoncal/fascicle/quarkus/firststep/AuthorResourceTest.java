package org.agoncal.fascicle.quarkus.firststep;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static javax.ws.rs.core.HttpHeaders.ACCEPT;
import static javax.ws.rs.core.MediaType.TEXT_PLAIN;
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
    given()
      .header(ACCEPT, TEXT_PLAIN).
    when()
      .get("/authors").
    then()
      .assertThat()
        .statusCode(is(200))
      .and()
        .body(is("Isaac Asimov, Ray Bradbury, Douglas Adams"));
  }

  @Test
  public void shouldGetAnAuthor() {
    given()
      .header(ACCEPT, TEXT_PLAIN)
      .pathParam("index", 0).
    when()
      .get("/authors/{index}").
    then()
      .assertThat()
        .statusCode(is(200))
      .and()
        .body(is("Isaac Asimov"));
  }
}
// end::adocSnippet[]
