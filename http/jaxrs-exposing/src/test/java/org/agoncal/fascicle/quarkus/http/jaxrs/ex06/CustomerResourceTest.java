package org.agoncal.fascicle.quarkus.http.jaxrs.ex06;

import io.quarkus.test.junit.QuarkusTest;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static javax.ws.rs.core.HttpHeaders.ACCEPT;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.APPLICATION_XML;
import static javax.ws.rs.core.MediaType.TEXT_HTML;
import static javax.ws.rs.core.MediaType.TEXT_PLAIN;
import static javax.ws.rs.core.Response.Status.OK;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
//@formatter:off
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
//    Response response = target("/customers").request(TEXT_PLAIN).get();
//    assertEquals(200, response.getStatus());
//    assertEquals(CUSTOMER_TEXT, response.readEntity(String.class));
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
//    Response response = target("/customers").request(TEXT_HTML).get();
//    assertEquals(200, response.getStatus());
//    assertEquals(CUSTOMER_HTML, response.readEntity(String.class));
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
//    Response response = target("/customers").request(APPLICATION_XML).get();
//    assertEquals(200, response.getStatus());
//    assertEquals(CUSTOMER_XML, response.readEntity(String.class));
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
//    Response response = target("/customers").request(APPLICATION_JSON).get();
//    assertEquals(200, response.getStatus());
//    assertEquals(CUSTOMER_JSON, response.readEntity(String.class));
    given()
      .header(ACCEPT, APPLICATION_JSON).
    when()
      .get("/api/customers").
    then()
      .statusCode(OK.getStatusCode())
      .body(Is.is(CUSTOMER_JSON));
  }
}
