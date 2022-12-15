package org.agoncal.fascicle.quarkus.http.jaxrs.ex07;

import org.agoncal.fascicle.quarkus.http.jaxrs.Customer;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
// tag::adocSnippet[]
@Path("/customer")
public class CustomerResource {

  @GET
  public String getAsPlainText() {
    return new Customer("John", "Smith").toString();
  }

  @GET
  @Path("max")
  public Integer getMaximumAge() {
    return 42;
  }

  @GET
  @Produces(MediaType.APPLICATION_XML)
  public Customer getAsXML() {
    Customer customer = new Customer("John", "Smith");
    return customer;
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAsJson() {
    Customer customer = new Customer("John", "Smith");
    return Response.ok(customer).encoding("utf-8").build();
  }
}
// end::adocSnippet[]
