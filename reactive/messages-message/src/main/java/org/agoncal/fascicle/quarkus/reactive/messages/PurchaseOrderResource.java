package org.agoncal.fascicle.quarkus.reactive.messages;

import org.agoncal.fascicle.quarkus.reactive.messages.model.PurchaseOrder;
import org.agoncal.fascicle.quarkus.reactive.messages.service.PurchaseOrderService;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.json.bind.Jsonb;
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

  @Inject
  Jsonb jsonb;

  @Inject
  PurchaseOrderService purchaseOrderService;

  @POST
  public Response create(PurchaseOrder po) {
    LOGGER.info("############");
    String temporaryId = "tpm" + Math.abs(new Random().nextInt());
    LOGGER.info("Creating temporary PO: " + temporaryId);

    emitter.send(po).whenComplete((x,e) -> {
        if (e != null ) e.printStackTrace();
    });
    //purchaseOrderService.prepare();

    URI temporaryPO = UriBuilder.fromResource(PurchaseOrderResource.class).path(temporaryId).build();
    return Response.temporaryRedirect(temporaryPO).build();
  }
}
// end::adocSnippet[]
