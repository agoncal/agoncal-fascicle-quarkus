package org.agoncal.fascicle.quarkus.reactive.messages.asynch;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import org.agoncal.fascicle.quarkus.reactive.messages.asynch.model.Address;
import org.agoncal.fascicle.quarkus.reactive.messages.asynch.model.CreditCard;
import org.agoncal.fascicle.quarkus.reactive.messages.asynch.model.Customer;
import org.agoncal.fascicle.quarkus.reactive.messages.asynch.model.OrderLine;
import org.agoncal.fascicle.quarkus.reactive.messages.asynch.model.PurchaseOrder;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.eclipse.microprofile.reactive.messaging.Metadata;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.time.LocalDate;

import static io.restassured.RestAssured.given;
import static javax.ws.rs.core.HttpHeaders.ACCEPT;
import static javax.ws.rs.core.HttpHeaders.CONTENT_TYPE;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.TEMPORARY_REDIRECT;
import static org.agoncal.fascicle.quarkus.reactive.messages.asynch.model.CreditCardType.AMERICAN_EXPRESS;
import static org.agoncal.fascicle.quarkus.reactive.messages.asynch.model.CreditCardType.MASTER_CARD;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// @formatter:off
@QuarkusTest
@TestHTTPEndpoint(PurchaseOrderMessageResource.class)
public class PurchaseOrderMessageResourceTest {

  private Jsonb jsonb = JsonbBuilder.create();

  @Disabled
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
      .statusCode(TEMPORARY_REDIRECT.getStatusCode());
  }

  @Disabled
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
      .statusCode(TEMPORARY_REDIRECT.getStatusCode());
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

  @Test
  public void shouldManipulateIntMessage() {
    // tag::adocSnippet[]
    Message<Integer> msg = Message.of(1);
    // tag::adocSkip[]
    assertEquals(1, msg.getPayload());
    // end::adocSkip[]
    // end::adocSnippet[]
  }

  @Test
  public void shouldManipulateStringMessage() {
    // tag::adocSnippet[]
    Message<String> msg = Message.of("Janis Joplin");
    // tag::adocSkip[]
    assertEquals("Janis Joplin", msg.getPayload());
    // end::adocSkip[]
    // end::adocSnippet[]
  }

  @Test
  public void shouldManipulateObjectMessage() {
    // tag::adocSnippet[]
    Message<CreditCard> msg = Message.of(new CreditCard("1234 5678", AMERICAN_EXPRESS));
    // tag::adocSkip[]
    assertEquals("1234 5678", msg.getPayload().number);
    // end::adocSkip[]
    // end::adocSnippet[]
  }

  @Test
  public void shouldManipulateObjectMessageWithMetadata() {
    // tag::adocSnippet[]
    Metadata metadata = Metadata.of(LocalDate.now());
    Message<String> msg = Message.of("Jimi Hendrix", metadata);
    // tag::adocSkip[]
    assertEquals("Jimi Hendrix", msg.getPayload());
    assertNotNull(msg.getMetadata());
    // end::adocSkip[]
    // end::adocSnippet[]
  }
}
