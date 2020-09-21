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
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.Random;

// tag::adocSnippet[]
@Path("/po")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class PurchaseOrderResource {

  private static final Logger LOGGER = Logger.getLogger(PurchaseOrderResource.class);

  @Inject @Channel("purchase-orders")
  Emitter<PurchaseOrder> emitter;

  /**
   * curl -X POST -H "Content-Type: application/json" -d '{"id":"123"}' http://localhost:8080/po -v
   *     emitter.send(po).whenComplete((x,e) -> {
   *         if (e != null ) e.printStackTrace();
   *     });
   */
  @POST
  public Response create(PurchaseOrder po) {
    LOGGER.info(">>>>>>>>>>>>");
    String temporaryId = "tmp" + Math.abs(new Random().nextInt());

    emitter.send(po);

    URI temporaryPO = UriBuilder.fromResource(PurchaseOrderResource.class).path(temporaryId).build();
    LOGGER.info("<<<<<<<<<<<<");
    return Response.temporaryRedirect(temporaryPO).build();
  }
}
// end::adocSnippet[]
