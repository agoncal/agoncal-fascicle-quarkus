package org.agoncal.fascicle.quarkus.reactive.messages;

import org.agoncal.fascicle.quarkus.reactive.messages.model.PurchaseOrder;
import org.agoncal.fascicle.quarkus.reactive.messages.service.BankService;
import org.agoncal.fascicle.quarkus.reactive.messages.service.CustomerService;
import org.agoncal.fascicle.quarkus.reactive.messages.service.InventoryService;
import org.agoncal.fascicle.quarkus.reactive.messages.service.PurchaseOrderService;
import org.agoncal.fascicle.quarkus.reactive.messages.service.ShippingService;

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

import static org.agoncal.fascicle.quarkus.reactive.messages.model.Status.VALID;

// tag::adocSnippet[]
@Path("/po")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class PurchaseOrderResource {

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

  @POST
  public Response create(PurchaseOrder po) {

    purchaseOrderService.validate(po);

    customerService.validate(po);

    bankService.validate(po);

    if (po.status == VALID && po.customer.status == VALID && po.creditCard.status == VALID) {
      purchaseOrderService.persist(po);

      inventoryService.prepareItems(po.orderLines);

      shippingService.shipItems(po.orderLines, po.customer.shippingAddress);

      URI createdPo = UriBuilder.fromResource(PurchaseOrderResource.class).path(String.valueOf(po.id)).build();
      return Response.created(createdPo).build();

    } else {
      purchaseOrderService.invalidate(po);
      return Response.notModified().build();
    }
  }
}
// end::adocSnippet[]
