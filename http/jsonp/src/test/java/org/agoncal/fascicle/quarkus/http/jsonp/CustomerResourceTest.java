package org.agoncal.fascicle.quarkus.http.jsonp;

import io.quarkus.test.junit.QuarkusTest;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.json.JsonArray;
import javax.json.JsonObject;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static javax.ws.rs.core.HttpHeaders.ACCEPT;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.OK;
import static org.agoncal.fascicle.quarkus.http.jsonp.UtilTest.initBufferedWriter;
import static org.agoncal.fascicle.quarkus.http.jsonp.UtilTest.output;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.not;

// @formatter:off
@QuarkusTest
public class CustomerResourceTest {

  static BufferedWriter bw;

  @BeforeAll
  static void initFile() throws FileNotFoundException {
    bw = initBufferedWriter("src/main/java/org/agoncal/fascicle/quarkus/http/jsonp/Customer.json");
  }

  @AfterAll
  static void closeFile() throws IOException {
    bw.close();
  }

  @Test
  public void shouldGenerateJSon()throws IOException {
    CustomerResource resource = new CustomerResource();
    JsonObject customer = resource.getCustomer();
    JsonObject customerDetails = resource.getCustomerDetails();
    JsonArray phones = resource.getPhones();

    output(bw, customer.toString(), "adocGetCustomer");
    output(bw, customerDetails.toString(), "getCustomerDetails");
    output(bw, phones.toString(), "adocGetPhones");
  }

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
      .body("$",  not(hasKey("address.street")))
      .body("$",  not(hasKey("address.city")))
      .body("$",  not(hasKey("address.country")));
  }

  @Test
  public void shouldGetCustomerDetails() {
    given()
      .header(ACCEPT, APPLICATION_JSON).
    when()
      .get("/customers/getCustomerDetails").
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
