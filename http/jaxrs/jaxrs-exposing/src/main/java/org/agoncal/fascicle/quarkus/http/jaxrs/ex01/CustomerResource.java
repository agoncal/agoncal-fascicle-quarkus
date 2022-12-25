package org.agoncal.fascicle.quarkus.http.jaxrs.ex01;

import org.agoncal.fascicle.quarkus.http.jaxrs.Customer;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
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
