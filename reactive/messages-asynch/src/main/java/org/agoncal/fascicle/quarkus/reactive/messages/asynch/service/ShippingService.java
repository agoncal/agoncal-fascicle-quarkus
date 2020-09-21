package org.agoncal.fascicle.quarkus.reactive.messages.asynch.service;

import org.agoncal.fascicle.quarkus.reactive.messages.asynch.model.OrderLine;
import org.agoncal.fascicle.quarkus.reactive.messages.asynch.model.PurchaseOrder;
import org.agoncal.fascicle.quarkus.reactive.messages.asynch.model.Status;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;

// tag::adocSnippet[]
@ApplicationScoped
public class ShippingService {
  // tag::adocSkip[]
  private static final Logger LOGGER = Logger.getLogger(ShippingService.class);
  // end::adocSkip[]

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

  // tag::adocSkip[]
  private void shipItems(PurchaseOrder po) {

  }
  // end::adocSkip[]
}
// end::adocSnippet[]
