package org.agoncal.fascicle.quarkus.http.jsonp;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonWriter;
import javax.json.JsonWriterFactory;
import javax.json.stream.JsonGenerator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// @formatter:off
public class CustomerReaderWriter {

  JsonObject customer = Json.createObjectBuilder()
    .add("firstName", "Antonio")
    .add("lastName", "Goncalves")
    .add("email", "agoncal.fascicle@gmail.com")
    .add("address", Json.createObjectBuilder()
      .add("street", "21 Ritherdon Rd")
      .add("city", "Brighton")
      .add("country", "UK"))
    .add("phoneNumbers", Json.createArrayBuilder()
      .add(Json.createObjectBuilder()
        .add("type", "mobile")
        .add("number", "+33 123 456"))
      .add(Json.createObjectBuilder()
        .add("type", "home")
        .add("number", "+33 646 555")))
    .build();

  public void writeCustomer() throws IOException {

    // tag::adocWriteCustomer[]
    File file = new File("src/main/resources/customer.json");
    try (OutputStream outputStream = new FileOutputStream(file);
         JsonWriter jsonWriter = Json.createWriter(outputStream)) {

      jsonWriter.write(customer);
    }
    // end::adocWriteCustomer[]
  }

  public void writeCustomerWithConfig() throws IOException {

    // tag::adocWriteCustomerWithConfig[]
    Map<String, Boolean> config = new HashMap<>();
    config.put(JsonGenerator.PRETTY_PRINTING, true);
    JsonWriterFactory writerFactory = Json.createWriterFactory(config);

    File file = new File("src/main/resources/customer.json");
    try (OutputStream outputStream = new FileOutputStream(file);
         JsonWriter jsonWriter = writerFactory.createWriter(outputStream)) {

      jsonWriter.write(customer);
    }
    // end::adocWriteCustomerWithConfig[]
  }

  public JsonObject readString() throws FileNotFoundException {
    // tag::adocReadCustomer
    StringReader string = new StringReader("{\"hello\":\"world\"}");
    JsonReader reader = Json.createReader(string);

    // end::adocReadCustomer[]
    JsonObject jsonObject = reader.readObject();
    return jsonObject;
  }

  public JsonObject readCustomer() throws FileNotFoundException {
    // tag::adocReadCustomer
    FileReader file = new FileReader("src/main/resources/customer.json");
    JsonReader reader = Json.createReader(file);
    JsonObject jsonObject = reader.readObject();
    // end::adocReadCustomer[]
    return jsonObject;
  }
}
