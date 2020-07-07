package org.agoncal.fascicle.quarkus.faulttolerance.book;

import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

// tag::adocSnippet[]
@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

  @Inject
  @RestClient
  NumberService isbnService;

  @GET
  @Path("/numbers")
  @Fallback(fallbackMethod = "fallbackGenerateBookNumbers")
  public JsonObject generateBookNumbers() {

    IsbnNumber isbnNumber = isbnService.generateIsbn(true);

    return Json.createObjectBuilder()
      .add("isbn13", isbnNumber.isbn13)
      .add("gs1", isbnNumber.gs1)
      .build();
  }

  private JsonObject fallbackGenerateBookNumbers() {
    return Json.createObjectBuilder()
      .add("isbn13", "dummy isbn")
      .add("gs1", "dummy gs1")
      .build();
  }
}
// end::adocSnippet[]
