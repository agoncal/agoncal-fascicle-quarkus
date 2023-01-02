package org.agoncal.fascicle.quarkus.reactive.messages.asynch.service;

import io.reactivex.rxjava3.core.Flowable;
import io.smallrye.reactive.messaging.annotations.Broadcast;
import org.agoncal.fascicle.quarkus.reactive.messages.asynch.model.PurchaseOrder;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.jboss.logging.Logger;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.agoncal.fascicle.quarkus.reactive.messages.asynch.model.Status.AUTHORISED;
import static org.agoncal.fascicle.quarkus.reactive.messages.asynch.model.Status.INVALID;
import static org.agoncal.fascicle.quarkus.reactive.messages.asynch.model.Status.VALID;

@ApplicationScoped
public class BankService {

  private static final Logger LOGGER = Logger.getLogger(BankService.class);

  @Broadcast
  // tag::adocSnippet[]
  @Incoming("po-prepared")
  @Outgoing("bank-validated")
  public PurchaseOrder validate(PurchaseOrder po) {
    // tag::adocSkip[]
    LOGGER.info("Validating Credit Card for PO: " + po.id);
    LOGGER.debug(po + "\n");
    // end::adocSkip[]

    if (complexValidationLogic(po)) {
      po.creditCard.status = VALID;
    } else {
      po.creditCard.status = INVALID;
    }
    return po;
  }

  @Incoming("bank-validated")
  @Outgoing("bank-authorised")
  public PurchaseOrder authorise(PurchaseOrder po) {
    // tag::adocSkip[]
    LOGGER.info("Authorising Credit Card for PO: " + po.id);
    LOGGER.debug(po + "\n");
    // end::adocSkip[]
    po.creditCard.status = AUTHORISED;
    return po;
  }

  @Incoming("bank-authorised")
  public void pay(PurchaseOrder po) {
    // tag::adocSkip[]
    LOGGER.info("Paying with Credit Card for PO: " + po.id);
    LOGGER.debug(po + "\n");
    // end::adocSkip[]
    makePayment(po);
  }
  // end::adocSnippet[]

  private void makePayment(PurchaseOrder po) {
  }

  private Random rate = new Random();

  // tag::adocMutiny[]
  @Outgoing("generated-conversation-rate")
  public Flowable<Float> generateConvertionRate() {
    return Flowable.interval(5, TimeUnit.SECONDS)
      .map(tick -> rate.nextFloat());
  }
  // end::adocMutiny[]

  private Float euroRate = new Random().nextFloat();
  private Float poundRate = new Random().nextFloat();

  // tag::adocOutgoingMsg[]
  @Outgoing("euro-rate")
  public Message<Float> sendEuroRate() {
    return Message.of(euroRate);
  }
  // end::adocOutgoingMsg[]

  // tag::adocOutgoingPayload[]
  @Outgoing("pound-rate")
  public Float sendPoundRate() {
    return poundRate;
  }
  // end::adocOutgoingPayload[]

  @Incoming("euro-rate")
  public void receiveEuroRate(Float rate) {
    LOGGER.info("Received euro rate " + rate);
  }
  @Incoming("pound-rate")
  public void receivePoundRate(Float rate) {
    LOGGER.info("Received pound rate " + rate);
  }

  private boolean complexValidationLogic(PurchaseOrder po) {
    return ((po.id & 1) == 0);
  }
}
