package org.agoncal.fascicle.quarkus.test.mock.inject;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static jakarta.ws.rs.core.Response.Status.OK;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.core.Is.is;

// @formatter:off
// tag::adocSnippet[]
@QuarkusTest
public class BookResourceTest {

  @InjectMock @RestClient
  IsbnResourceProxy isbnServiceProxy;

  @BeforeEach
  void mockData() {
    Mockito
      .when(isbnServiceProxy.generateIsbnNumbers())
      .thenReturn(new IsbnNumbers("Dummy isbn 10", "Dummy isbn 13"));
  }

  @Test
  void shouldGetRandomBook() {
    given()
      .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON).
    when()
      .get("/api/books").
    then()
      .statusCode(OK.getStatusCode())
      .body("isbn_10", is("Dummy isbn 10"))
      .body("isbn_13", is("Dummy isbn 13"))
      .body("$", hasKey("title"))
      .body("$", hasKey("author"));
  }
}
// end::adocSnippet[]
