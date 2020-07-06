package org.agoncal.fascicle.quarkus.restclient.isbn;

import io.quarkus.test.junit.QuarkusTest;
import io.vertx.core.json.JsonObject;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static javax.ws.rs.core.Response.Status.OK;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.not;

// @formatter:off
@QuarkusTest
public class IsbnResourceTest {

  @Test
  void shouldGenerateIsbnWithSeparator() {
    given()
      .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
      .queryParam("separator", true).
    when()
      .get("/api/isbn").
    then()
      .statusCode(OK.getStatusCode())
      .body("$", hasKey("isbn13"))
      .body("isbn13", containsString("-"))
      .body("$", hasKey("gs1"));
  }


  @Test
  void shouldGenerateIsbn() {
    given()
      .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON).
    when()
      .get("/api/isbn").
    then()
      .statusCode(OK.getStatusCode())
      .body("$", hasKey("isbn13"))
      .body("isbn13", containsString("-"))
      .body("$", hasKey("gs1"));
  }

  @Test
  void shouldGenerateIsbnWithoutSeparator() {
    given()
      .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
      .queryParam("separator", false).
    when()
      .get("/api/isbn").
    then()
      .statusCode(OK.getStatusCode())
      .body("$", hasKey("isbn13"))
      .body("isbn13", not(containsString("-")))
      .body("$", hasKey("gs1"));
  }

  @Test @Disabled("only for fascicle purpose")
  void shouldInvokeWithRESTClientAPI() {
  // tag::adocSnippet[]
  JsonObject isbnNumber = ClientBuilder
    .newClient()
    .target("http://localhost:9081/api/isbn?separator=true")
    .request()
    .get(JsonObject.class);

  String gs1 = isbnNumber.getString("gs1");
  String isbn13 = isbnNumber.getString("isbn13");
  // end::adocSnippet[]
  System.out.println(gs1);
  System.out.println(isbn13);
  }
}
