package org.agoncal.fascicle.quarkus.reactive.messages.kafka.service;

import org.agoncal.fascicle.quarkus.reactive.messages.kafka.model.OrderLine;
import org.agoncal.fascicle.quarkus.reactive.messages.kafka.model.PurchaseOrder;
import org.agoncal.fascicle.quarkus.reactive.messages.kafka.model.Status;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.jboss.logging.Logger;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ShippingService {

  private static final Logger LOGGER = Logger.getLogger(ShippingService.class);

  @Incoming("po-validated")
  public PurchaseOrder prepareShipping(PurchaseOrder po) {
    LOGGER.info("Preparing shipping");

    for (OrderLine orderLine : po.orderLines) {
      orderLine.status = Status.SHIPPING;
    }
    return po;
  }
}
