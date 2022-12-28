package org.agoncal.fascicle.quarkus.reactive.messages.asynch.service;

import org.agoncal.fascicle.quarkus.reactive.messages.asynch.model.OrderLine;
import org.agoncal.fascicle.quarkus.reactive.messages.asynch.model.PurchaseOrder;
import org.agoncal.fascicle.quarkus.reactive.messages.asynch.model.Status;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.jboss.logging.Logger;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ShippingService {

  private static final Logger LOGGER = Logger.getLogger(ShippingService.class);

  // tag::adocSnippet[]
  @Incoming("po-validated")
  public void prepareShipping(PurchaseOrder po) {
    // tag::adocSkip[]
    LOGGER.info("Preparing shipping");
    // end::adocSkip[]

    for (OrderLine orderLine : po.orderLines) {
      orderLine.status = Status.SHIPPING;
    }

    shipItems(po);
  }
  // end::adocSnippet[]

  private void shipItems(PurchaseOrder po) {

  }
}
