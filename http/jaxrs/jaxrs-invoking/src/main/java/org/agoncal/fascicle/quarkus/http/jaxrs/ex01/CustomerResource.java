package org.agoncal.fascicle.quarkus.http.jaxrs.ex01;

import org.agoncal.fascicle.quarkus.http.jaxrs.Customer;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import java.net.URI;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
@Path("/customers")
public class CustomerResource {

  // ======================================
  // =           Public Methods           =
  // ======================================

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String ping() {
    return "ping";
  }

  @POST
  @Consumes("custom/format")
  public Response createCustomerCustom(Customer customer) {
    URI customerURI = UriBuilder.fromResource(CustomerResource.class).path(customer.getId()).build();
    return Response.created(customerURI).build();
  }
}
