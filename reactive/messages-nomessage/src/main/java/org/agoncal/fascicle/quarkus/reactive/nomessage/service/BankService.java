package org.agoncal.fascicle.quarkus.reactive.nomessage.service;

import org.agoncal.fascicle.quarkus.reactive.nomessage.model.PurchaseOrder;
import org.agoncal.fascicle.quarkus.reactive.nomessage.model.Status;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BankService {

  private static final Logger LOGGER = Logger.getLogger(BankService.class);

  public void validate(PurchaseOrder po) {
    LOGGER.info("Validating Credit Card for PO: " + po.id);
    LOGGER.debug(po + "\n");

    if ((po.id & 1) == 0) {
      po.creditCard.status = Status.VALID;
    } else {
      po.creditCard.status = Status.INVALID;
    }
  }
}
