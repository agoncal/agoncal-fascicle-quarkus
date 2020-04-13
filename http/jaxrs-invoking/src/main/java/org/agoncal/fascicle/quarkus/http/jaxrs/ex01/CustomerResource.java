package org.agoncal.fascicle.quarkus.http.jaxrs.ex01;

import org.agoncal.fascicle.quarkus.http.jaxrs.Customer;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
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
