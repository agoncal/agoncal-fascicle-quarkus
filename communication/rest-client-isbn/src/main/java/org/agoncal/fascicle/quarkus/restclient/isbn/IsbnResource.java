package org.agoncal.fascicle.quarkus.restclient.isbn;

import com.github.javafaker.Faker;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

// tag::adocSnippet[]
@Path("/api/isbn")
@Produces(MediaType.APPLICATION_JSON)
public class IsbnResource {

  @GET
  public IsbnNumber generateIsbn() {
    IsbnNumber isbnNumber = new IsbnNumber();
    isbnNumber.isbn13 = new Faker().code().isbn13();
    isbnNumber.gs1 = new Faker().code().isbnGs1();
    return isbnNumber;
  }
}
// end::adocSnippet[]
