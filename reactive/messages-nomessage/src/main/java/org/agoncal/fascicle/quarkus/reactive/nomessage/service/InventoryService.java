package org.agoncal.fascicle.quarkus.reactive.nomessage.service;

import org.agoncal.fascicle.quarkus.reactive.nomessage.model.OrderLine;
import org.agoncal.fascicle.quarkus.reactive.nomessage.model.Status;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class InventoryService {

  private static final Logger LOGGER = Logger.getLogger(InventoryService.class);

  public void prepareItems(List<OrderLine> orderLines) throws InterruptedException {
    LOGGER.info("Preparing items");

    for (OrderLine orderLine : orderLines) {
      orderLine.status = Status.PREPARING;
    }
    Thread.sleep(1000);
  }
}
