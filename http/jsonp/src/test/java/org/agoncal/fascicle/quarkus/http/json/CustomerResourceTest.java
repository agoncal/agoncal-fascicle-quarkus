package org.agoncal.fascicle.quarkus.http.json;

import io.quarkus.test.junit.QuarkusTest;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static javax.ws.rs.core.HttpHeaders.ACCEPT;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.OK;
import static org.hamcrest.Matchers.hasItem;

// @formatter:off
@QuarkusTest
public class CustomerResourceTest {

  @Test
  public void shouldGetCustomer() {
    given()
      .header(ACCEPT, APPLICATION_JSON).
    when()
      .get("/customers/getCustomer").
    then()
      .statusCode(OK.getStatusCode())
      .body("firstName", Is.is("Antonio"))
      .body("lastName", Is.is("Goncalves"))
      .body("email", Is.is("agoncal.fascicle@gmail.com"))
      .body("address.street", Is.is("21 Ritherdon Rd"))
      .body("address.city", Is.is("Brighton"))
      .body("address.country", Is.is("UK"));
  }

  @Test
  public void shouldGetPhones() {
    given()
      .header(ACCEPT, APPLICATION_JSON).
    when()
      .get("/customers/getPhones").
    then()
      .statusCode(OK.getStatusCode())
      .body("type", hasItem("mobile"))
      .body("type", hasItem("home"))
      .body("number", hasItem("+33 123 456"))
      .body("number", hasItem("+33 646 555"));
  }
}
