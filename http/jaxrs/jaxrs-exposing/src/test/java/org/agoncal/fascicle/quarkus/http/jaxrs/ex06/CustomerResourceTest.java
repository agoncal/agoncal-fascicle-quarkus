package org.agoncal.fascicle.quarkus.http.jaxrs.ex06;

import io.quarkus.test.junit.QuarkusTest;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static jakarta.ws.rs.core.HttpHeaders.ACCEPT;
import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;
import static jakarta.ws.rs.core.MediaType.APPLICATION_XML;
import static jakarta.ws.rs.core.MediaType.TEXT_HTML;
import static jakarta.ws.rs.core.MediaType.TEXT_PLAIN;
import static jakarta.ws.rs.core.Response.Status.OK;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// @formatter:off
@QuarkusTest
public class CustomerResourceTest {

  // ======================================
  // =             Attributes             =
  // ======================================

  public static final String CUSTOMER_TEXT = "Customer{id='null', firstName='John', lastName='Smith', email='jsmith@gmail.com', phoneNumber='1234565'}";
  public static final String CUSTOMER_HTML = "<h1>Customer</h1><p>Customer{id='null', firstName='John', lastName='Smith', email='jsmith@gmail.com', phoneNumber='1234565'}</p><hr/>";
  public static final String CUSTOMER_XML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><customer><email>jsmith@gmail.com</email><firstName>John</firstName><lastName>Smith</lastName><phoneNumber>1234565</phoneNumber></customer>";
  public static final String CUSTOMER_JSON = "{\"email\":\"jsmith@gmail.com\",\"firstName\":\"John\",\"lastName\":\"Smith\",\"phoneNumber\":\"1234565\"}";

  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test
  public void shouldGetCustomerAsPlainText() {
    given()
      .header(ACCEPT, TEXT_PLAIN).
    when()
      .get("/api/customers").
    then()
      .statusCode(OK.getStatusCode())
      .body(Is.is(CUSTOMER_TEXT));
  }

  @Test
  public void shouldGetCustomerAsHTML() {
    given()
      .header(ACCEPT, TEXT_HTML).
    when()
      .get("/api/customers").
    then()
      .statusCode(OK.getStatusCode())
      .body(Is.is(CUSTOMER_HTML));
  }

  @Test
  public void shouldGetCustomerAsXML() {
    given()
      .header(ACCEPT, APPLICATION_XML).
    when()
      .get("/api/customers").
    then()
      .statusCode(OK.getStatusCode())
      .body(Is.is(CUSTOMER_XML));
  }

  @Test
  public void shouldGetCustomerAsJSON() {
    given()
      .header(ACCEPT, APPLICATION_JSON).
    when()
      .get("/api/customers").
    then()
      .statusCode(OK.getStatusCode())
      .body(Is.is(CUSTOMER_JSON));
  }
}
