package org.agoncal.fascicle.quarkus.reactive.messages.kafka;

import org.agoncal.fascicle.quarkus.reactive.messages.kafka.model.PurchaseOrder;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.Random;

/**
 * curl -X POST -H "Content-Type: application/json" -d '{"id":"123"}' http://localhost:8080/po -v
 *     emitter.send(po).whenComplete((x,e) -> {
 *         if (e != null ) e.printStackTrace();
 *     });
 */
// @formatter:off
// tag::adocSnippet[]
@Path("/po")
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class PurchaseOrderResource {
  // tag::adocSkip[]
  private static final Logger LOGGER = Logger.getLogger(PurchaseOrderResource.class);
  String tmpId = "tmp" + Math.abs(new Random().nextInt());
  // end::adocSkip[]

  @Inject @Channel("purchase-orders-write")
  Emitter<PurchaseOrder> emitter;

  @POST
  public Response create(PurchaseOrder po) {
    // tag::adocSkip[]
    LOGGER.info(">>>>>>>>>>>>");
    // end::adocSkip[]

    emitter.send(po);

    URI temporaryPO = UriBuilder.fromResource(PurchaseOrderResource.class)
                                .path(tmpId).build();
    // tag::adocSkip[]
    LOGGER.info("<<<<<<<<<<<<");
    // end::adocSkip[]
    return Response.temporaryRedirect(temporaryPO).build();
  }
}
// end::adocSnippet[]
