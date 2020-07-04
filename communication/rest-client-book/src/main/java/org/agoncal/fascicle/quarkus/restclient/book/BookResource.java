package org.agoncal.fascicle.quarkus.restclient.book;

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
  IsbnService isbnService;

  @Inject
  @RestClient
  IssnService issnService;

  @GET
  @Path("/numbers")
  public JsonObject generateBookNumbers() {

    IsbnNumber isbnNumber = isbnService.generateIsbn();
    String isbn13 = isbnNumber.isbn13;

    JsonObject issnJsonObject = issnService.generateIssn();
    String issn = issnJsonObject.getJsonString("issn").getString();

    return Json.createObjectBuilder()
      .add("isbn13", isbn13)
      .add("isbn10", issn)
      .build();
  }
}
// end::adocSnippet[]
