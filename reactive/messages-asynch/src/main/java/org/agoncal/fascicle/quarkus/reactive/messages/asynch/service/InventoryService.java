package org.agoncal.fascicle.quarkus.reactive.messages.asynch.service;

import org.agoncal.fascicle.quarkus.reactive.messages.asynch.model.OrderLine;
import org.agoncal.fascicle.quarkus.reactive.messages.asynch.model.PurchaseOrder;
import org.agoncal.fascicle.quarkus.reactive.messages.asynch.model.Status;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class InventoryService {

  private static final Logger LOGGER = Logger.getLogger(InventoryService.class);

  @Incoming("po-validated")
  public void prepareItems(PurchaseOrder po) throws InterruptedException {
    LOGGER.info("Preparing items");

    for (OrderLine orderLine : po.orderLines) {
      orderLine.status = Status.PREPARING;
    }
    Thread.sleep(2000);
  }
}
