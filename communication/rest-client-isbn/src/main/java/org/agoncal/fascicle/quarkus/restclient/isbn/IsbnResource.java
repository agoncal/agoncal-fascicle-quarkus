package org.agoncal.fascicle.quarkus.restclient.isbn;

import com.github.javafaker.Faker;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

// @formatter:off
// tag::adocSnippet[]
@Path("/api/isbn")
@Produces(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class IsbnResource {

  @GET
  public IsbnNumber generateIsbn(
                    @DefaultValue("true")
                    @QueryParam("separator") boolean separator) {
    IsbnNumber isbnNumber = new IsbnNumber();
    isbnNumber.isbn13 = new Faker().code().isbn13(separator);
    isbnNumber.gs1 = new Faker().code().isbnGs1();
    return isbnNumber;
  }
}
// end::adocSnippet[]
