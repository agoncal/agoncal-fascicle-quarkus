package org.agoncal.fascicle.quarkus.reactive.messages.kafka.codecs;

import org.agoncal.fascicle.quarkus.reactive.messages.kafka.model.PurchaseOrder;
import io.quarkus.kafka.client.serialization.JsonbDeserializer;

// tag::adocSnippet[]
public class PurchaseOrderDeserializer extends JsonbDeserializer<PurchaseOrder> {
  public PurchaseOrderDeserializer() {
    super(PurchaseOrder.class);
  }
}
// end::adocSnippet[]
