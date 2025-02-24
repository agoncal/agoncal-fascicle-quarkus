package org.agoncal.fascicle.quarkus.reactive.messages.synch.service;

import org.agoncal.fascicle.quarkus.reactive.messages.synch.model.PurchaseOrder;
import org.agoncal.fascicle.quarkus.reactive.messages.synch.model.Status;
import org.jboss.logging.Logger;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BankService {

  private static final Logger logger = Logger.getLogger(BankService.class);

  public void validate(PurchaseOrder po) {
    logger.info("Validating Credit Card for PO: " + po.id);
    logger.debug(po + "\n");

    if ((po.id & 1) == 0) {
      po.creditCard.status = Status.VALID;
    } else {
      po.creditCard.status = Status.INVALID;
    }
  }
}
