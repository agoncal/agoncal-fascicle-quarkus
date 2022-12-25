package org.agoncal.fascicle.quarkus.http.jsonp.dflt;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import jakarta.json.JsonArray;
import jakarta.json.JsonObject;

import java.io.IOException;

// @formatter:off
@QuarkusTest
public class CustomerServiceTest {

  @Inject
  CustomerService customerService;

//  static BufferedWriter bw;
//
//  @BeforeAll
//  static void initFile() throws FileNotFoundException {
//    bw = initBufferedWriter("src/main/java/org/agoncal/fascicle/quarkus/http/jsonp/Customer.json");
//  }
//
//  @AfterAll
//  static void closeFile() throws IOException {
//    bw.close();
//  }

  @Test
  public void shouldGenerateJSon() throws IOException {
    JsonObject customer = customerService.getCustomer();
    JsonObject customerDetails = customerService.getCustomerDetails();
    JsonArray phones = customerService.getPhones();

//    output(bw, customer.toString(), "adocGetCustomer");
//    output(bw, customerDetails.toString(), "getCustomerDetails");
//    output(bw, phones.toString(), "adocGetPhones");
  }

  @Test
  public void shouldGetCustomer() {
    JsonObject customer = customerService.getCustomer();

//    given()
//      .header(ACCEPT, APPLICATION_JSON).
//    when()
//      .get("/customers/getCustomer").
//    then()
//      .statusCode(OK.getStatusCode())
//      .body("firstName", Is.is("Antonio"))
//      .body("lastName", Is.is("Goncalves"))
//      .body("email", Is.is("agoncal.fascicle@gmail.com"))
//      .body("$",  not(hasKey("address.street")))
//      .body("$",  not(hasKey("address.city")))
//      .body("$",  not(hasKey("address.country")));
  }

  @Test
  public void shouldGetCustomerDetails() {
    JsonObject customerDetails = customerService.getCustomerDetails();

//    given()
//      .header(ACCEPT, APPLICATION_JSON).
//    when()
//      .get("/customers/getCustomerDetails").
//    then()
//      .statusCode(OK.getStatusCode())
//      .body("firstName", Is.is("Antonio"))
//      .body("lastName", Is.is("Goncalves"))
//      .body("email", Is.is("agoncal.fascicle@gmail.com"))
//      .body("address.street", Is.is("21 Ritherdon Rd"))
//      .body("address.city", Is.is("Brighton"))
//      .body("address.country", Is.is("UK"));
  }

  @Test
  public void shouldGetPhones() {
    JsonArray phones = customerService.getPhones();

//    given()
//      .header(ACCEPT, APPLICATION_JSON).
//    when()
//      .get("/customers/getPhones").
//    then()
//      .statusCode(OK.getStatusCode())
//      .body("type", hasItem("mobile"))
//      .body("type", hasItem("home"))
//      .body("number", hasItem("+33 123 456"))
//      .body("number", hasItem("+33 646 555"));
  }
}
