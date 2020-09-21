package org.agoncal.fascicle.quarkus.reactive.messages.asynch.service;

import com.github.javafaker.Faker;
import io.smallrye.reactive.messaging.annotations.Broadcast;
import org.agoncal.fascicle.quarkus.reactive.messages.asynch.model.Address;
import org.agoncal.fascicle.quarkus.reactive.messages.asynch.model.CreditCard;
import org.agoncal.fascicle.quarkus.reactive.messages.asynch.model.Customer;
import org.agoncal.fascicle.quarkus.reactive.messages.asynch.model.OrderLine;
import org.agoncal.fascicle.quarkus.reactive.messages.asynch.model.PurchaseOrder;
import org.agoncal.fascicle.quarkus.reactive.messages.asynch.model.Status;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.time.LocalDate;

import static org.agoncal.fascicle.quarkus.reactive.messages.asynch.model.CreditCardType.MASTER_CARD;
import static org.agoncal.fascicle.quarkus.reactive.messages.asynch.model.Status.INVALID;
import static org.agoncal.fascicle.quarkus.reactive.messages.asynch.model.Status.VALID;

// tag::adocSnippet[]
@ApplicationScoped
public class PurchaseOrderService {
  // tag::adocSkip[]
  private static final Logger LOGGER = Logger.getLogger(PurchaseOrderService.class);
  // end::adocSkip[]

  @Inject
  @Broadcast
  @Channel("po-validated")
  Emitter<PurchaseOrder> emitterForValidPO;

  @Inject
  @Channel("po-invalidated")
  Emitter<PurchaseOrder> emitterForInvalidPO;

  @Incoming("bank-validated")
  public void validate(PurchaseOrder po) {
    // tag::adocSkip[]
    LOGGER.info("Validating or Invalidating PO: " + po.id);
    LOGGER.debug(po + "\n");
    // end::adocSkip[]

    if (po.creditCard.status == VALID){
      po.status = VALID;
      emitterForValidPO.send(po);
    } else {
      po.status = INVALID;
      emitterForInvalidPO.send(po);
    }
  }

  @Incoming("purchase-orders")
  @Outgoing("po-prepared")
  public PurchaseOrder create(PurchaseOrder po) {
    LOGGER.info("Creating PO: " + po.id);
    LOGGER.debug(po + "\n");

    Faker fake = Faker.instance();
    po.status = Status.PREPARING;
    po.date = LocalDate.now();
    Address address = new Address(fake.address().streetAddress(), fake.address().city(), fake.address().zipCode());
    po.customer = new Customer(fake.name().firstName(), fake.name().lastName(), fake.internet().emailAddress(), fake.phoneNumber().phoneNumber(), address);
    po.creditCard = new CreditCard(fake.business().creditCardNumber(), fake.business().creditCardExpiry(), 123, MASTER_CARD);
    po.addOrderLine(new OrderLine(fake.book().title(), 2d, 1));
    po.addOrderLine(new OrderLine(fake.book().title(), 5d, 2));

    return po;
  }


  @Incoming("po-invalidated")
  public void invalidate(PurchaseOrder po) {
    po.status = Status.INVALIDATED;
    LOGGER.info("Invalidating PO: " + po.id);
    LOGGER.debug(po + "\n");
  }
}
// end::adocSnippet[]
