package org.agoncal.fascicle.quarkus.firstlook;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static jakarta.ws.rs.core.HttpHeaders.ACCEPT;
import static jakarta.ws.rs.core.MediaType.TEXT_PLAIN;
import static org.hamcrest.CoreMatchers.is;

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
        .body(is("Isaac Asimov, Nora Jemisin, Douglas Adams"));
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
