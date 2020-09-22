package org.agoncal.fascicle.quarkus.reactive.messages.synch.service;

import com.github.javafaker.Faker;
import org.agoncal.fascicle.quarkus.reactive.messages.synch.model.Address;
import org.agoncal.fascicle.quarkus.reactive.messages.synch.model.CreditCard;
import org.agoncal.fascicle.quarkus.reactive.messages.synch.model.Customer;
import org.agoncal.fascicle.quarkus.reactive.messages.synch.model.OrderLine;
import org.agoncal.fascicle.quarkus.reactive.messages.synch.model.PurchaseOrder;
import org.agoncal.fascicle.quarkus.reactive.messages.synch.model.Status;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.time.LocalDate;

import static org.agoncal.fascicle.quarkus.reactive.messages.synch.model.CreditCardType.MASTER_CARD;
import static org.agoncal.fascicle.quarkus.reactive.messages.synch.model.Status.VALID;

@ApplicationScoped
public class PurchaseOrderService {

  private static final Logger LOGGER = Logger.getLogger(PurchaseOrderService.class);

  @Inject
  BankService bankService;

  @Inject
  InventoryService inventoryService;

  @Inject
  ShippingService shippingService;

  // tag::adocSnippet[]
  public PurchaseOrder create(PurchaseOrder po) throws InterruptedException {
    // tag::adocSkip[]
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
    // end::adocSkip[]

    bankService.validate(po);

    if (po.creditCard.status == VALID) {
      po.status = VALID;

      inventoryService.prepareItems(po);

      shippingService.prepareShipping(po);
    } else {
      invalidate(po);
    }

    return po;
  }
  // end::adocSnippet[]

  public void invalidate(PurchaseOrder po) {
    po.status = Status.INVALIDATED;
    LOGGER.info("Invalidating PO: " + po.id);
    LOGGER.debug(po + "\n");
  }
}
