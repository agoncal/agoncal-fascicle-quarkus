package org.agoncal.fascicle.quarkus.reactive.messages.service;

import com.github.javafaker.Faker;
import org.agoncal.fascicle.quarkus.reactive.messages.model.Address;
import org.agoncal.fascicle.quarkus.reactive.messages.model.CreditCard;
import org.agoncal.fascicle.quarkus.reactive.messages.model.Customer;
import org.agoncal.fascicle.quarkus.reactive.messages.model.OrderLine;
import org.agoncal.fascicle.quarkus.reactive.messages.model.PurchaseOrder;
import org.agoncal.fascicle.quarkus.reactive.messages.model.Status;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import java.time.LocalDate;

import static org.agoncal.fascicle.quarkus.reactive.messages.model.CreditCardType.MASTER_CARD;

@ApplicationScoped
public class PurchaseOrderService {

  private static final Logger LOGGER = Logger.getLogger(PurchaseOrderService.class);

  @Incoming("purchase-orders")
  @Outgoing("po-started")
  public PurchaseOrder start(PurchaseOrder po) {
    LOGGER.info("Start");
    return po;
  }

  @Incoming("po-started")
  @Outgoing("po-prepared")
  public PurchaseOrder prepare(PurchaseOrder po) {
    //PurchaseOrder po = new PurchaseOrder(123L, LocalDate.now());
    LOGGER.info("Preparing PO: " + po.id);
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

  @Incoming("po-prepared")
  //@Outgoing("po-validated")
  public void validate(PurchaseOrder po) throws InterruptedException {
    LOGGER.info("Validating PO: " + po.id);
    LOGGER.debug(po + "\n");

    if ((po.id & 1) == 0) {
      po.status = Status.VALID;
    } else {
      po.status = Status.INVALID;
    }
    Thread.sleep(500);
    //return po;
  }

  public void persist(PurchaseOrder po) {
    LOGGER.info("Persisting PO: " + po.id);
    LOGGER.debug(po + "\n");

    po.status = Status.CREATED;
  }

  public void invalidate(PurchaseOrder po) {
    LOGGER.info("Invalidating PO: " + po.id);
    LOGGER.debug(po + "\n");

    po.status = Status.INVALIDATED;
  }
}
