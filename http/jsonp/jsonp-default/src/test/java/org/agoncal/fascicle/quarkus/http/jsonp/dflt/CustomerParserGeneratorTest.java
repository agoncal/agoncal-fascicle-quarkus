package org.agoncal.fascicle.quarkus.http.jsonp.dflt;

import org.agoncal.fascicle.quarkus.http.jsonp.dflt.CustomerParserGenerator;
import org.junit.jupiter.api.Test;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.json.stream.JsonParser;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

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
  }

  @Test
  void parseString() throws FileNotFoundException {
    CustomerParserGenerator parser = new CustomerParserGenerator();
    JsonParser.Event event = parser.parseString();

    assertEquals("START_OBJECT", event.name());
  }

  @Test
  void parseStringWithConfig() throws FileNotFoundException {
    CustomerParserGenerator parser = new CustomerParserGenerator();
    JsonParser.Event event = parser.parseStringWithConfig();

    assertEquals("START_OBJECT", event.name());
  }

  @Test
  void generateCustomer() throws FileNotFoundException {
    CustomerParserGenerator parser = new CustomerParserGenerator();
    StringWriter writer = parser.generateCustomer();

    JsonReader reader = Json.createReader(new StringReader(writer.toString()));
    JsonObject jsonObject = reader.readObject();

    assertEquals("Antonio", jsonObject.getJsonString("firstName").getString());
    assertEquals("Goncalves", jsonObject.getJsonString("lastName").getString());
    assertEquals("agoncal.fascicle@gmail.com", jsonObject.getJsonString("email").getString());
    JsonObject address = jsonObject.getJsonObject("address");
    assertEquals("21 Ritherdon Rd", address.getJsonString("street").getString());
    assertEquals("Brighton", address.getJsonString("city").getString());
    assertEquals("UK", address.getJsonString("country").getString());
    JsonArray phones = jsonObject.getJsonArray("phoneNumbers");
    assertEquals(2, phones.size());
  }
}
