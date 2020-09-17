package org.agoncal.fascicle.quarkus.reactive.nomessage;

import org.agoncal.fascicle.quarkus.reactive.nomessage.model.PurchaseOrder;
import org.agoncal.fascicle.quarkus.reactive.nomessage.service.BankService;
import org.agoncal.fascicle.quarkus.reactive.nomessage.service.CustomerService;
import org.agoncal.fascicle.quarkus.reactive.nomessage.service.InventoryService;
import org.agoncal.fascicle.quarkus.reactive.nomessage.service.PurchaseOrderService;
import org.agoncal.fascicle.quarkus.reactive.nomessage.service.ShippingService;
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

import static org.agoncal.fascicle.quarkus.reactive.nomessage.model.Status.VALID;

// tag::adocSnippet[]
@Path("/po")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class PurchaseOrderResource {

  private static final Logger LOGGER = Logger.getLogger(PurchaseOrderResource.class);

  @Inject
  PurchaseOrderService purchaseOrderService;

  @Inject
  CustomerService customerService;

  @Inject
  BankService bankService;

  @Inject
  InventoryService inventoryService;

  @Inject
  ShippingService shippingService;

  /**
   * curl -X POST -H "Content-Type: application/json" -d '{"id":"123"}' http://localhost:8080/po -v
   */
  @POST
  public Response create(PurchaseOrder po) throws InterruptedException {
    LOGGER.info("############");
    LOGGER.info("Creating PO: " + po.id);

    purchaseOrderService.prepare(po);

    purchaseOrderService.validate(po);

    customerService.validate(po);

    bankService.validate(po);

    if (po.status == VALID && po.customer.status == VALID && po.creditCard.status == VALID) {
      purchaseOrderService.persist(po);

      inventoryService.prepareItems(po.orderLines);

      shippingService.prepareShipping(po.orderLines, po.customer.shippingAddress);

      shippingService.ship(po);

      URI createdPo = UriBuilder.fromResource(PurchaseOrderResource.class).path(String.valueOf(po.id)).build();
      return Response.created(createdPo).build();

    } else {
      purchaseOrderService.invalidate(po);
      return Response.notModified().build();
    }
  }
}
// end::adocSnippet[]
