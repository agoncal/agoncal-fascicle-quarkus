package org.agoncal.fascicle.quarkus.http.jaxrs.ex06;

import org.agoncal.fascicle.quarkus.http.jaxrs.Customer;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
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
@Path("/api/customers")
public class CustomerResource {

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public Response getAsPlainText() {
    // ...
    // tag::adocSkip1[]
    return Response.ok(new Customer("John", "Smith", "jsmith@gmail.com", "1234565").toString()).build();
    // end::adocSkip1[]
  }

  @GET
  @Produces(MediaType.TEXT_HTML)
  public Response getAsHtml() {
    // ...
    // tag::adocSkip2[]
    final StringBuilder sb = new StringBuilder();
    sb.append("<h1>Customer</h1><p>");
    sb.append(new Customer("John", "Smith", "jsmith@gmail.com", "1234565"));
    sb.append("</p><hr/>");
    return Response.ok(sb.toString()).build();
    // end::adocSkip2[]
  }

  @GET
  @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  public Response getAsJsonAndXML() {
    // ...
    // tag::adocSkip3[]
    return Response.ok(new Customer("John", "Smith", "jsmith@gmail.com", "1234565")).build();
    // end::adocSkip3[]
  }

  @PUT
  @Consumes(MediaType.TEXT_PLAIN)
  public void putName(String customer) {
    // ...
  }
}
// end::adocSnippet[]
