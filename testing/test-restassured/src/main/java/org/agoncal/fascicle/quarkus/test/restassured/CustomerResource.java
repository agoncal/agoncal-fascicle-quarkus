package org.agoncal.fascicle.quarkus.test.restassured;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)
public class CustomerResource {

  private static Customers customers = new Customers();

  static {
    customers.addAll(List.of(
      new Customer().id(1L).firstName("John").lastName("Lennon"),
      new Customer().id(2L).firstName("Paul").lastName("McCartney"),
      new Customer().id(3L).firstName("George").lastName("Harrison"),
      new Customer().id(4L).firstName("Ringo").lastName("Starr")
    ));
  }

  /**
   * curl -X POST -H "Content-Type: application/json" -d '{"first-name":"value1", "last-name":"value2"}' http://localhost:8080/customers -v
   */
  @POST
  public Response createCustomer(@Context UriInfo uriInfo, Customer customer) {
    customer.setId((long) Math.random());
    customers.add(customer);
    URI uri = uriInfo.getAbsolutePathBuilder().path(customer.getId().toString()).build();
    return Response.created(uri).build();
  }

  /**
   * curl http://localhost:8080/customers
   * curl -X GET -H "Accept: application/json" http://localhost:8080/customers
   */
  @GET
  public Response getAllCustomers() {
    return Response.ok(customers).build();
  }

  /**
   * curl http://localhost:8080/customers/3
   * curl -X GET -H "Accept: application/json" http://localhost:8080/customers/3
   */
  @GET
  @Path("/{id}")
  public Response getCustomer(@PathParam("id") Long id) {
    Customer customer = customers.stream()
      .filter(a -> id.equals(a.getId()))
      .findFirst()
      .orElse(null);
    return Response.ok(customer).build();
  }

  /**
   * curl  http://localhost:8080/customers/count
   * curl -X GET -H "Accept: text/plain" http://localhost:8080/customers/count
   */
  @GET
  @Path("/count")
  @Produces(MediaType.TEXT_PLAIN)
  public Integer countCustomers() {
    return customers.size();
  }

  @DELETE
  @Path("/{id}")
  public Response deleteCustomer(@PathParam("id") Long id) {
    //customers.removeIf(x -> customers.contains(new Customer().id(id)));
    return Response.noContent().build();
  }
}
// end::adocsnippet[]
