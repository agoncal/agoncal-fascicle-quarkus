package org.agoncal.fascicle.quarkus.reactive.messages.kafka.service;

import io.smallrye.reactive.messaging.annotations.Broadcast;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import net.datafaker.Faker;
import org.agoncal.fascicle.quarkus.reactive.messages.kafka.model.Address;
import org.agoncal.fascicle.quarkus.reactive.messages.kafka.model.CreditCard;
import static org.agoncal.fascicle.quarkus.reactive.messages.kafka.model.CreditCardType.MASTER_CARD;
import org.agoncal.fascicle.quarkus.reactive.messages.kafka.model.Customer;
import org.agoncal.fascicle.quarkus.reactive.messages.kafka.model.OrderLine;
import org.agoncal.fascicle.quarkus.reactive.messages.kafka.model.PurchaseOrder;
import org.agoncal.fascicle.quarkus.reactive.messages.kafka.model.Status;
import static org.agoncal.fascicle.quarkus.reactive.messages.kafka.model.Status.INVALID;
import static org.agoncal.fascicle.quarkus.reactive.messages.kafka.model.Status.VALID;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.jboss.logging.Logger;

import java.time.LocalDate;

@ApplicationScoped
public class PurchaseOrderService {

  private static final Logger logger = Logger.getLogger(PurchaseOrderService.class);

  @Inject
  @Broadcast
  @Channel("po-validated")
  Emitter<PurchaseOrder> emitterForValidPO;

  @Inject
  @Channel("po-invalidated")
  Emitter<PurchaseOrder> emitterForInvalidPO;

  @Outgoing("po-prepared-write")
  // tag::adocSnippet[]
  @Incoming("po-read")
  public PurchaseOrder create(PurchaseOrder po) {
    // tag::adocSkip[]
    logger.info("Creating PO: " + po.id);
    logger.debug(po + "\n");

    Faker fake = new Faker();
    po.status = Status.PREPARING;
    po.date = LocalDate.now();
    Address address = new Address(fake.address().streetAddress(), fake.address().city(), fake.address().zipCode());
    po.customer = new Customer(fake.name().firstName(), fake.name().lastName(), fake.internet().emailAddress(), fake.phoneNumber().phoneNumber(), address);
    po.creditCard = new CreditCard(fake.business().creditCardNumber(), fake.business().creditCardExpiry(), 123, MASTER_CARD);
    po.addOrderLine(new OrderLine(fake.book().title(), 2d, 1));
    po.addOrderLine(new OrderLine(fake.book().title(), 5d, 2));
    // end::adocSkip[]

    // Create a PO
    return po;
  }
  // end::adocSnippet[]

  @Incoming("bank-validated")
  public void validate(PurchaseOrder po) {
    logger.info("Validating or Invalidating PO: " + po.id);
    logger.debug(po + "\n");

    if (po.creditCard.status == VALID){
      po.status = VALID;
      emitterForValidPO.send(po);
    } else {
      po.status = INVALID;
      emitterForInvalidPO.send(po);
    }
  }

  @Incoming("po-invalidated")
  public void invalidate(PurchaseOrder po) {
    po.status = Status.INVALIDATED;
    logger.info("Invalidating PO: " + po.id);
    logger.debug(po + "\n");
  }
}
