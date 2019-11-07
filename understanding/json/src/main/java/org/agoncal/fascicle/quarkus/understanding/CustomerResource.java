package org.agoncal.fascicle.quarkus.understanding;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)
public class CustomerResource {

  // ======================================
  // =           Public Methods           =
  // ======================================

  @GET
  @Path("/jsonb")
  public Response getJSonB() {
    Customer customer = new Customer().firstName("Antonio").lastName("Goncalves").email("agoncal.fascicle@gmail.com ").phoneNumber("+33 123 456").dateOfBirth(LocalDate.now());
    return Response.ok(customer).build();
  }

  @GET
  @Path("/jsonp")
  public Response getJSonP() {
    Customer customer = new Customer().firstName("Antonio").lastName("Goncalves").email("agoncal.fascicle@gmail.com ").dateOfBirth(LocalDate.now());
    return Response.ok(customer).build();
  }
}
