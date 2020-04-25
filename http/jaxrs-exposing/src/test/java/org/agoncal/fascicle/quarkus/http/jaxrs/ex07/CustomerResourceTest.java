package org.agoncal.fascicle.quarkus.http.jaxrs.ex07;

import io.quarkus.test.junit.QuarkusTest;
import org.agoncal.fascicle.quarkus.http.jaxrs.Customer;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import java.util.Date;

import static io.restassured.RestAssured.given;
import static javax.ws.rs.core.HttpHeaders.ACCEPT;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.APPLICATION_XML;
import static javax.ws.rs.core.MediaType.TEXT_PLAIN;
import static javax.ws.rs.core.Response.Status.OK;


/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
//@formatter:off
@QuarkusTest
public class CustomerResourceTest{

  public static final String CUSTOMER_TEXT = "Customer{id='null', firstName='John', lastName='Smith', email='null', phoneNumber='null'}";
  public static final String CUSTOMER_XML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><customer><firstName>John</firstName><lastName>Smith</lastName></customer>";
  public static final String CUSTOMER_JSON = "{\"firstName\":\"John\",\"lastName\":\"Smith\"}";

  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test
  public void shouldGetAsPlainText() {
//    Response response = target("/customers").request(MediaType.TEXT_PLAIN).get();
//    assertEquals(200, response.getStatus());
//    assertEquals("Customer{id=null, firstName='John', lastName='Smith', email='jsmith@gmail.com', phoneNumber='1234565'}", response.readEntity(String.class));
    given()
      .header(ACCEPT, TEXT_PLAIN).
      when()
      .get("/customer").
      then()
      .statusCode(OK.getStatusCode())
      .body(Is.is(CUSTOMER_TEXT));
  }

  @Test
  public void shouldGetMaximumBonusAllowed() {
//    Response response = target("/customers/max").request(MediaType.TEXT_PLAIN).get();
//    assertEquals(200, response.getStatus());
//    assertEquals((Object) 1234L, response.readEntity(Long.class));
    given()
      .header(ACCEPT, TEXT_PLAIN).
      when()
      .get("/customer/max").
      then()
      .statusCode(OK.getStatusCode())
      .body(Is.is("42"));
  }

  @Test
  public void shouldGetStringAsXML() {
//    Response response = target("/customers").request(APPLICATION_XML).get();
//    assertEquals(200, response.getStatus());
//    assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><customer><email>jsmith@gmail.com</email><firstName>John</firstName><lastName>Smith</lastName><phoneNumber>1234565</phoneNumber></customer>", response.readEntity(String.class));
    given()
      .header(ACCEPT, APPLICATION_XML).
      when()
      .get("/customer").
      then()
      .statusCode(OK.getStatusCode())
      .body(Is.is(CUSTOMER_XML));
  }

  @Test
  public void shouldGetAsJSon() {
//    Response response = target("/customers").request(APPLICATION_JSON).get();
//    assertEquals(200, response.getStatus());
//    assertEquals("{\"email\":\"jsmith@gmail.com\",\"firstName\":\"John\",\"lastName\":\"Smith\",\"phoneNumber\":\"1234565\"}", response.readEntity(String.class));
    given()
      .header(ACCEPT, APPLICATION_JSON).
      when()
      .get("/customer").
      then()
      .statusCode(OK.getStatusCode())
      .body(Is.is(CUSTOMER_JSON));
  }

  @Test
  public void shouldCheckResponse() {
    // tag::adocSnippet[]
    Response.ok().build();
    Response.ok().cookie(new NewCookie("SessionID", "5G79GDIFY09")).build();
    Response.ok("Plain Text").expires(new Date()).build();
    Response.ok(new Customer("John", "Smith", "jsmith@gmail.com", "1234565"), APPLICATION_JSON).build();
    Response.noContent().build();
    Response.accepted(new Customer("John", "Smith", "jsmith@gmail.com", "1234565")).build();
    Response.notModified().header("User-Agent", "Mozilla").build();
    // end::adocSnippet[]
  }
}
