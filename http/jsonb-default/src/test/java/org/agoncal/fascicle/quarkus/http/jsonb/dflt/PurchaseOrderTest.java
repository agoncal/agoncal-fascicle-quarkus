package org.agoncal.fascicle.quarkus.http.jsonb.dflt;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.time.LocalDate;

import static org.agoncal.fascicle.quarkus.http.jsonb.dflt.CreditCardType.VISA;
import static org.agoncal.fascicle.quarkus.http.jsonb.dflt.UtilTest.initBufferedWriter;
import static org.agoncal.fascicle.quarkus.http.jsonb.dflt.UtilTest.output;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocBegin[]
public class PurchaseOrderTest {

  private static Jsonb jsonb;

  @BeforeAll
  static void init() {
    JsonbConfig config = new JsonbConfig().withFormatting(true);
    jsonb = JsonbBuilder.create(config);
  }
  // end::adocBegin[]

  static BufferedWriter bw;

  @BeforeAll
  static void initFile() throws FileNotFoundException {
    bw = initBufferedWriter("src/main/java/org/agoncal/fascicle/quarkus/http/jsonb/dflt/PurchaseOrder.json");
  }

  @AfterAll
  static void closeFile() throws IOException {
    bw.close();
  }

  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test
  void shouldMarshallAPurchaseOrder() throws IOException {

    CreditCard creditCard = new CreditCard().number("2156 7655 1234 9876").expiryDate("10/23").controlNumber(372).creditCardType(VISA);
    Customer customer = new Customer().firstName("James").lastName("Rorrison").email("j.rorri@me.com").phoneNumber("+44 1234 1234");
    OrderLine o1 = new OrderLine().item("H2G2").quantity(1).unitPrice(23.5d);
    OrderLine o2 = new OrderLine().item("Harry Potter").quantity(2).unitPrice(34.99d);
    PurchaseOrder po = new PurchaseOrder().id(1234L).date(LocalDate.of(2019, 12, 07)).customer(customer).creditCard(creditCard);
    po.addOrderLine(o1);
    po.addOrderLine(o2);

    String json = jsonb.toJson(po);

    output(bw, json, "shouldMarshallAPurchaseOrder");

    JsonReader reader = Json.createReader(new StringReader(json));
    JsonObject jsonObject = reader.readObject();

    assertEquals("2019-12-07", jsonObject.getString("date"));
    assertEquals(1234, jsonObject.getInt("id"));
  }
}
