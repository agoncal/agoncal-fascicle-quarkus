package org.agoncal.fascicle.quarkus.reactive.messages.synch;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import org.agoncal.fascicle.quarkus.reactive.messages.synch.model.PurchaseOrder;
import static org.agoncal.fascicle.quarkus.reactive.messages.synch.model.Status.VALID;
import org.agoncal.fascicle.quarkus.reactive.messages.synch.service.PurchaseOrderService;
import org.jboss.logging.Logger;

import java.net.URI;

// tag::adocSnippet[]
@Path("/po")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class PurchaseOrderResource {

  private static final Logger logger = Logger.getLogger(PurchaseOrderResource.class);

  @Inject
  PurchaseOrderService purchaseOrderService;

  /**
   * curl -X POST -H "Content-Type: application/json" -d '{"id":"123"}' http://localhost:8080/po -v
   */
  @POST
  public Response create(PurchaseOrder po) throws InterruptedException {
    logger.info(">>>>>>>>>>>>");

    po = purchaseOrderService.create(po);

    if (po.status == VALID) {
      URI createdPo = UriBuilder.fromResource(PurchaseOrderResource.class).path(String.valueOf(po.id)).build();
      logger.info("<<<<<<<<<<<<");
      return Response.created(createdPo).build();

    } else {
      logger.info("<<<<<<<<<<<<");
      return Response.notModified().build();
    }
  }
}
// end::adocSnippet[]
