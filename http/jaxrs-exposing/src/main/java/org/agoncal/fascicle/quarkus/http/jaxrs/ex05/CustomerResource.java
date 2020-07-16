package org.agoncal.fascicle.quarkus.http.jaxrs.ex05;

import org.agoncal.fascicle.quarkus.http.jaxrs.Customer;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
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
    List<Customer> customers = new ArrayList<>();
    customers.add(new Customer("John", "Smith", "jsmith@gmail.com", "1234565", new Date(), new Date()));
    customers.add(new Customer("John", "Smith", "jsmith@gmail.com", "1234565", new Date(), new Date()));
    return customers;
    // end::adocSkip1[]
  }

  @GET
  @Path("search")
  public List<Customer> getByName(@MatrixParam("firstname") String firstname,
                                  @MatrixParam("surname") String surname) {
    // URI : /customer/search;firstname=Antonio;surname=Goncalves
    // tag::adocSkip2[]
    System.out.println("getCustomerByFirstnameName : " + firstname + " - " + surname);
    List<Customer> customers = new ArrayList<>();
    customers.add(new Customer("John", "Smith", "jsmith@gmail.com", "1234565", new Date(), new Date()));
    customers.add(new Customer("John", "Smith", "jsmith@gmail.com", "1234565", new Date(), new Date()));
    return customers;
    // end::adocSkip2[]
  }
}
// end::adocSnippet[]
