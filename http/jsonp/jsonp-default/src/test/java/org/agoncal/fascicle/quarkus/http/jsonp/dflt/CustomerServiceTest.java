package org.agoncal.fascicle.quarkus.http.jsonp.dflt;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import jakarta.json.JsonArray;
import jakarta.json.JsonObject;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
  public void shouldGetCustomer() {
    JsonObject jsonObject = customerService.getCustomer();
    assertEquals("Antonio", jsonObject.getJsonString("firstName").getString());
    assertEquals("Goncalves", jsonObject.getJsonString("lastName").getString());
    assertEquals("agoncal.fascicle@gmail.com", jsonObject.getJsonString("email").getString());
  }

  @Test
  public void shouldGetCustomerDetails() {
    JsonObject jsonObject = customerService.getCustomerDetails();
    assertEquals("Antonio", jsonObject.getJsonString("firstName").getString());
    assertEquals("Goncalves", jsonObject.getJsonString("lastName").getString());
    assertEquals("agoncal.fascicle@gmail.com", jsonObject.getJsonString("email").getString());
    JsonObject address = jsonObject.getJsonObject("address");
    assertEquals("21 Ritherdon Rd", address.getJsonString("street").getString());
    assertEquals("Brighton", address.getJsonString("city").getString());
    assertEquals("UK", address.getJsonString("country").getString());
  }

  @Test
  public void shouldGetPhones() {
    JsonArray jsonObject = customerService.getPhones();
    assertEquals(2, jsonObject.size());
  }
}
