package org.agoncal.fascicle.quarkus.understanding;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.containsString;

// @formatter:off
// tag::adocSnippet[]
@QuarkusTest
public class CustomerResourceTest {

  @Test
  public void shouldGetJSonB() {
    given().
    when().
      get("/customers/jsonb").
    then().
      assertThat().
        statusCode(is(200)).
      and().
        body(containsString("Antonio"));
  }
}
// end::adocSnippet[]
