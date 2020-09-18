package org.agoncal.fascicle.quarkus.reactive.messages.service;

import org.agoncal.fascicle.quarkus.reactive.messages.model.Address;
import org.agoncal.fascicle.quarkus.reactive.messages.model.OrderLine;
import org.agoncal.fascicle.quarkus.reactive.messages.model.PurchaseOrder;
import org.agoncal.fascicle.quarkus.reactive.messages.model.Status;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ShippingService {

  private static final Logger LOGGER = Logger.getLogger(ShippingService.class);

  public void prepareShipping(List<OrderLine> orderLines, Address shippingAddress) {
    LOGGER.info("Preparing shipping");

    for (OrderLine orderLine : orderLines) {
      orderLine.status = Status.SHIPPING;
    }
  }

  public void ship(PurchaseOrder po) {
    LOGGER.info("Shipping");
    po.status = Status.SHIPPED;
    LOGGER.debug(po );
    LOGGER.info("########");
  }
}
