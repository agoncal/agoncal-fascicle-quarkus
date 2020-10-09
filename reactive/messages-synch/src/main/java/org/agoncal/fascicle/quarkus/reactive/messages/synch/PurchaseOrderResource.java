package org.agoncal.fascicle.quarkus.reactive.messages.synch;

import org.agoncal.fascicle.quarkus.reactive.messages.synch.model.PurchaseOrder;
import org.agoncal.fascicle.quarkus.reactive.messages.synch.service.PurchaseOrderService;
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
