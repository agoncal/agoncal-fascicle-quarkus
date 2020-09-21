package org.agoncal.fascicle.quarkus.reactive.messages.asynch.service;

import org.agoncal.fascicle.quarkus.reactive.messages.asynch.model.PurchaseOrder;
import org.agoncal.fascicle.quarkus.reactive.messages.asynch.model.Status;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;

// tag::adocSnippet[]
@ApplicationScoped
public class BankService {
  // tag::adocSkip[]
  private static final Logger LOGGER = Logger.getLogger(BankService.class);
  // end::adocSkip[]

  @Incoming("po-prepared")
  @Outgoing("bank-validated")
  public PurchaseOrder validate(PurchaseOrder po) {
    // tag::adocSkip[]
    LOGGER.info("Validating Credit Card for PO: " + po.id);
    LOGGER.debug(po + "\n");
    // end::adocSkip[]

    if (complexValidationLogic(po)) {
      po.creditCard.status = Status.VALID;
    } else {
      po.creditCard.status = Status.INVALID;
    }
    return po;
  }
  // tag::adocSkip[]
  private boolean complexValidationLogic(PurchaseOrder po) {
    return ((po.id & 1) == 0);
    }
  // end::adocSkip[]
}
// end::adocSnippet[]
