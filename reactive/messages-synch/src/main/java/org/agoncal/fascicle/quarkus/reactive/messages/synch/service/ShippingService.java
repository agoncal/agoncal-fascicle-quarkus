package org.agoncal.fascicle.quarkus.reactive.messages.synch.service;

import org.agoncal.fascicle.quarkus.reactive.messages.synch.model.OrderLine;
import org.agoncal.fascicle.quarkus.reactive.messages.synch.model.PurchaseOrder;
import org.agoncal.fascicle.quarkus.reactive.messages.synch.model.Status;
import org.jboss.logging.Logger;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ShippingService {

  private static final Logger LOGGER = Logger.getLogger(ShippingService.class);

  public void prepareShipping(PurchaseOrder po) {
    LOGGER.info("Preparing shipping");

    for (OrderLine orderLine : po.orderLines) {
      orderLine.status = Status.SHIPPING;
    }
  }
}
