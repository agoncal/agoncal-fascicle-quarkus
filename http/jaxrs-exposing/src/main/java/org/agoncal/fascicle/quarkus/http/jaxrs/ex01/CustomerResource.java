package org.agoncal.fascicle.quarkus.http.jaxrs.ex01;

import org.agoncal.fascicle.quarkus.http.jaxrs.Customer;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.List;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
// tag::adocSnippet[]
@Path("/customers")
public class CustomerResource {

  @GET
  public Response getCustomers() {
    // tag::adocSkip1[]
    System.out.println("getCustomers");
    List<Customer> customers = List.of(
      new Customer("John", "Smith", "jsmith@gmail.com", "1234565"),
      new Customer("John", "Smith", "jsmith@gmail.com", "1234565")
    );
    // end::adocSkip1[]
    // ...
    return Response.ok(customers).build();
  }

  @GET
  @Path("{customerId}")
  public Response getCustomer(@PathParam("customerId") String customerId) {
    // tag::adocSkip2[]
    System.out.println("getCustomer " + customerId);
    Customer customer = new Customer("John", "Smith", "jsmith@gmail.com", "1334565");
    // end::adocSkip2[]
    // ...
    return Response.ok(customer).build();
  }

  @POST
  public Response createCustomer(Customer customer) {
    // tag::adocSkip3[]
    System.out.println("createCustomer " + customer);
    URI createdCustomerURI = UriBuilder.fromResource(CustomerResource.class).path("1334").build();
    // end::adocSkip3[]
    // ...
    return Response.created(createdCustomerURI).build();
  }

  @PUT
  public Response updateCustomer(Customer customer) {
    // tag::adocSkip4[]
    System.out.println("updateCustomer " + customer);
    customer = new Customer("JohnUpdated", "Smith", "jsmith@gmail.com", "1334565");
    // end::adocSkip4[]
    // ...
    return Response.ok(customer).build();
  }

  @DELETE
  @Path("{customerId}")
  public Response deleteCustomer(@PathParam("customerId") String customerId) {
    // tag::adocSkip5[]
    System.out.println("getCustomer " + customerId);
    // end::adocSkip5[]
    // ...
    return Response.noContent().build();
  }
}
// end::adocSnippet[]
