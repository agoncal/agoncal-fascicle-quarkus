package org.agoncal.fascicle.quarkus.reactive.messages.synch;

import org.agoncal.fascicle.quarkus.reactive.messages.synch.model.PurchaseOrder;
import org.agoncal.fascicle.quarkus.reactive.messages.synch.service.PurchaseOrderService;
import org.jboss.logging.Logger;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import java.net.URI;

import static org.agoncal.fascicle.quarkus.reactive.messages.synch.model.Status.VALID;

// tag::adocSnippet[]
@Path("/po")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class PurchaseOrderResource {

  private static final Logger LOGGER = Logger.getLogger(PurchaseOrderResource.class);

  @Inject
  PurchaseOrderService purchaseOrderService;

  /**
   * curl -X POST -H "Content-Type: application/json" -d '{"id":"123"}' http://localhost:8080/po -v
   */
  @POST
  public Response create(PurchaseOrder po) throws InterruptedException {
    LOGGER.info(">>>>>>>>>>>>");

    po = purchaseOrderService.create(po);

    if (po.status == VALID) {
      URI createdPo = UriBuilder.fromResource(PurchaseOrderResource.class).path(String.valueOf(po.id)).build();
      LOGGER.info("<<<<<<<<<<<<");
      return Response.created(createdPo).build();

    } else {
      LOGGER.info("<<<<<<<<<<<<");
      return Response.notModified().build();
    }
  }
}
// end::adocSnippet[]
