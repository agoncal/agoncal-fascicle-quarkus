package org.agoncal.fascicle.quarkus.http.jaxrs.ex07;

import org.agoncal.fascicle.quarkus.http.jaxrs.Customer;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
    return new Customer("John", "Smith");
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAsJson() {
    return Response.ok(new Customer("John", "Smith"), MediaType.APPLICATION_JSON).build();
  }
}
// end::adocSnippet[]
