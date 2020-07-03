package org.agoncal.fascicle.quarkus.http.jsonp;

import org.junit.jupiter.api.Test;

import javax.json.JsonObject;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerParserGeneratorTest {

  @Test
  void parseEvents() throws IOException {
    CustomerParserGenerator parser = new CustomerParserGenerator();
    parser.parseEvents();
  }

  @Test
  void parseCustomer() throws IOException {
    CustomerParserGenerator parser = new CustomerParserGenerator();
    String email = parser.parseCustomer();

    assertEquals("agoncal.fascicle@gmail.com", email);
  }

  @Test
  void parseString() throws FileNotFoundException {
    CustomerParserGenerator parser = new CustomerParserGenerator();
    JsonObject jsonObject = parser.parseString();

    assertEquals("world", jsonObject.getJsonString("hello").getString());
  }

  @Test
  void parseStringWithConfig() throws FileNotFoundException {
    CustomerParserGenerator parser = new CustomerParserGenerator();
    JsonObject jsonObject = parser.parseStringWithConfig();

    assertEquals("world", jsonObject.getJsonString("hello").getString());
  }
}
