package org.agoncal.fascicle.quarkus.restclient.numbers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

// tag::adocSnippet[]
@Path("/numbers")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

  @GET
  public BookNumbers generateBookNumbers() {

    BookNumbers bookNumbers = new BookNumbers();
    bookNumbers.isbn10 = "10";
    bookNumbers.isbn13 = "13";

    return bookNumbers;
  }
}
// end::adocSnippet[]
