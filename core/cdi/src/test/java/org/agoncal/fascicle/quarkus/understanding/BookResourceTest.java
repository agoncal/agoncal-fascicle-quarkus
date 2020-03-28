package org.agoncal.fascicle.quarkus.understanding;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;

// @formatter:off
@QuarkusTest
public class BookResourceTest {

  @Test
  public void shouldGetISBN() {
    given().
    when().
      get("/books/isbn").
    then().
      assertThat().
        statusCode(is(200)).
      and().
        body(containsString("13"));
  }
}
// end::adocSnippet[]
