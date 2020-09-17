package org.agoncal.fascicle.quarkus.reactive.nomessage.service;

import org.agoncal.fascicle.quarkus.reactive.nomessage.model.PurchaseOrder;
import org.agoncal.fascicle.quarkus.reactive.nomessage.model.Status;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CustomerService {

  private static final Logger LOGGER = Logger.getLogger(CustomerService.class);

  public void validate(PurchaseOrder po) throws InterruptedException {
    LOGGER.info("Validating Customer for PO: " + po.id);
    LOGGER.debug(po + "\n");

    if ((po.id & 1) == 0) {
      po.customer.status = Status.VALID;
    } else {
      po.customer.status = Status.INVALID;
    }
    Thread.sleep(1000);
  }
}
