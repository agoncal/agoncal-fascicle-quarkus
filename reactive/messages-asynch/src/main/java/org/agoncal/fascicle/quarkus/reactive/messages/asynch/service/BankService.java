package org.agoncal.fascicle.quarkus.reactive.messages.asynch.service;

import io.reactivex.Flowable;
import org.agoncal.fascicle.quarkus.reactive.messages.asynch.model.PurchaseOrder;
import org.agoncal.fascicle.quarkus.reactive.messages.asynch.model.Status;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@ApplicationScoped
public class BankService {

  private static final Logger LOGGER = Logger.getLogger(BankService.class);

  // tag::adocSnippet[]
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
  // end::adocSnippet[]

  private Random rate = new Random();

  // tag::adocMutiny[]
  @Outgoing("generated-conversation-rate")
  public Flowable<Float> generateConvertionRate() {
    return Flowable.interval(5, TimeUnit.SECONDS)
      .map(tick -> rate.nextFloat());
  }
  // end::adocMutiny[]

  private boolean complexValidationLogic(PurchaseOrder po) {
    return ((po.id & 1) == 0);
  }
}
