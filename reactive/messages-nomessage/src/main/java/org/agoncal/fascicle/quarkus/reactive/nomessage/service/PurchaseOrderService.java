package org.agoncal.fascicle.quarkus.reactive.nomessage.service;

import com.github.javafaker.Faker;
import org.agoncal.fascicle.quarkus.reactive.nomessage.model.Address;
import org.agoncal.fascicle.quarkus.reactive.nomessage.model.CreditCard;
import org.agoncal.fascicle.quarkus.reactive.nomessage.model.Customer;
import org.agoncal.fascicle.quarkus.reactive.nomessage.model.OrderLine;
import org.agoncal.fascicle.quarkus.reactive.nomessage.model.PurchaseOrder;
import org.agoncal.fascicle.quarkus.reactive.nomessage.model.Status;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import java.time.LocalDate;

import static org.agoncal.fascicle.quarkus.reactive.nomessage.model.CreditCardType.MASTER_CARD;

@ApplicationScoped
public class PurchaseOrderService {

  private static final Logger LOGGER = Logger.getLogger(PurchaseOrderService.class);

  public void validate(PurchaseOrder po) throws InterruptedException {
    LOGGER.info("Validating PO: " + po.id);
    LOGGER.debug(po + "\n");

    if ((po.id & 1) == 0) {
      po.status = Status.VALID;
    } else {
      po.status = Status.INVALID;
    }
    Thread.sleep(500);
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

  public void prepare(PurchaseOrder po) {
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
  }
}
