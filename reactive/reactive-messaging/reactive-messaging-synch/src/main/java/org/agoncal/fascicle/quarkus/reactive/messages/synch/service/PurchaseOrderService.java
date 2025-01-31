package org.agoncal.fascicle.quarkus.reactive.messages.synch.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import net.datafaker.Faker;
import org.agoncal.fascicle.quarkus.reactive.messages.synch.model.Address;
import org.agoncal.fascicle.quarkus.reactive.messages.synch.model.CreditCard;
import static org.agoncal.fascicle.quarkus.reactive.messages.synch.model.CreditCardType.MASTER_CARD;
import org.agoncal.fascicle.quarkus.reactive.messages.synch.model.Customer;
import org.agoncal.fascicle.quarkus.reactive.messages.synch.model.OrderLine;
import org.agoncal.fascicle.quarkus.reactive.messages.synch.model.PurchaseOrder;
import org.agoncal.fascicle.quarkus.reactive.messages.synch.model.Status;
import static org.agoncal.fascicle.quarkus.reactive.messages.synch.model.Status.VALID;
import org.jboss.logging.Logger;

import java.time.LocalDate;

@ApplicationScoped
public class PurchaseOrderService {

  private static final Logger logger = Logger.getLogger(PurchaseOrderService.class);

  @Inject
  BankService bankService;

  @Inject
  InventoryService inventoryService;

  @Inject
  ShippingService shippingService;

  // tag::adocSnippet[]
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
    logger.info("Invalidating PO: " + po.id);
    logger.debug(po + "\n");
  }
}
