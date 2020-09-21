package org.agoncal.fascicle.quarkus.reactive.messages.synch;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import org.agoncal.fascicle.quarkus.reactive.messages.synch.model.Address;
import org.agoncal.fascicle.quarkus.reactive.messages.synch.model.CreditCard;
import org.agoncal.fascicle.quarkus.reactive.messages.synch.model.Customer;
import org.agoncal.fascicle.quarkus.reactive.messages.synch.model.OrderLine;
import org.agoncal.fascicle.quarkus.reactive.messages.synch.model.PurchaseOrder;
import org.junit.jupiter.api.Test;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.time.LocalDate;

import static io.restassured.RestAssured.given;
import static javax.ws.rs.core.HttpHeaders.ACCEPT;
import static javax.ws.rs.core.HttpHeaders.CONTENT_TYPE;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.CREATED;
import static javax.ws.rs.core.Response.Status.NOT_MODIFIED;
import static org.agoncal.fascicle.quarkus.reactive.messages.synch.model.CreditCardType.MASTER_CARD;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// @formatter:off
@QuarkusTest
@TestHTTPEndpoint(PurchaseOrderResource.class)
public class PurchaseOrderResourceTest {

  private Jsonb jsonb = JsonbBuilder.create();

  @Test
  public void shouldCreateValidPurchaseOrder() {
    PurchaseOrder po = newPO();
    po.id = 2L;

    given()
      .body(jsonb.toJson(po))
      .header(CONTENT_TYPE, APPLICATION_JSON)
      .header(ACCEPT, APPLICATION_JSON).
    when()
      .post().
    then()
      .statusCode(CREATED.getStatusCode());
  }

  @Test
  public void shouldCreateInvalidPurchaseOrder() {
    PurchaseOrder po = newPO();
    po.id = 1L;

    given()
      .body(jsonb.toJson(po))
      .header(CONTENT_TYPE, APPLICATION_JSON)
      .header(ACCEPT, APPLICATION_JSON).
    when()
      .post().
    then()
      .statusCode(NOT_MODIFIED.getStatusCode());
  }

  private PurchaseOrder newPO() {
    PurchaseOrder po = new PurchaseOrder(1234L, LocalDate.now());
    Address address = new Address("street", "city", "zip");
    Customer customer = new Customer("first name", "last name", "email", "phone", address);
    CreditCard creditCard = new CreditCard("number", "date", 123, MASTER_CARD);
    po.customer = customer;
    po.creditCard = creditCard;
    po.addOrderLine(new OrderLine("item 1", 2d, 1));
    po.addOrderLine(new OrderLine("item 2", 5d, 2));
    return po;
  }
}
