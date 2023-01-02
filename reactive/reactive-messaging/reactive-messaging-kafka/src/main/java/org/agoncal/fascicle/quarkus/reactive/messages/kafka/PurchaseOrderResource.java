package org.agoncal.fascicle.quarkus.reactive.messages.kafka;

import org.agoncal.fascicle.quarkus.reactive.messages.kafka.model.PurchaseOrder;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.jboss.logging.Logger;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
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

  @Inject @Channel("po-write")
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
