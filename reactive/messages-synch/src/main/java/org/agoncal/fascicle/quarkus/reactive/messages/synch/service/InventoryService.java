package org.agoncal.fascicle.quarkus.reactive.messages.synch.service;

import org.agoncal.fascicle.quarkus.reactive.messages.synch.model.OrderLine;
import org.agoncal.fascicle.quarkus.reactive.messages.synch.model.PurchaseOrder;
import org.agoncal.fascicle.quarkus.reactive.messages.synch.model.Status;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class InventoryService {

  private static final Logger LOGGER = Logger.getLogger(InventoryService.class);

  public void prepareItems(PurchaseOrder po) {
    LOGGER.info("Preparing items");

    for (OrderLine orderLine : po.orderLines) {
      orderLine.status = Status.PREPARING;
    }
    //Thread.sleep(2000);
  }
}
