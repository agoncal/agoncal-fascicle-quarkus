package org.agoncal.fascicle.quarkus.http.jaxrs.ex05;

import org.agoncal.fascicle.quarkus.http.jaxrs.Customer;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.MatrixParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import java.util.Date;
import java.util.List;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// @formatter:off
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
// tag::adocSnippet[]
@Path("/customers")
public class CustomerResource {

  @GET
  public List<Customer> getByZipCodeCity(@QueryParam("zip") Long zip,
                                         @QueryParam("city") String city) {
    // URI : /customer?zip=75012&city=Paris
    // tag::adocSkip1[]
    System.out.println("getCustomerByZipCodeCity : " + zip + " - " + city);
    return List.of(
      new Customer("John", "Smith", "jsmith@gmail.com", "1234565", new Date(), new Date()),
      new Customer("John", "Smith", "jsmith@gmail.com", "1234565", new Date(), new Date())
    );
    // end::adocSkip1[]
  }

  @GET
  @Path("search")
  public List<Customer> getByName(@MatrixParam("firstname") String firstname,
                                  @MatrixParam("surname") String surname) {
    // URI : /customer/search;firstname=Antonio;surname=Goncalves
    // tag::adocSkip2[]
    System.out.println("getCustomerByFirstnameName : " + firstname + " - " + surname);
    return List.of(
      new Customer("John", "Smith", "jsmith@gmail.com", "1234565", new Date(), new Date()),
      new Customer("John", "Smith", "jsmith@gmail.com", "1234565", new Date(), new Date())
    );
    // end::adocSkip2[]
  }
}
// end::adocSnippet[]
