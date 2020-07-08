package org.agoncal.fascicle.quarkus.restclient.book;

import org.eclipse.microprofile.rest.client.RestClientBuilder;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.net.URI;
import java.net.URISyntaxException;

// tag::adocSnippet[]
@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
@ApplicationScoped
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

    IsbnNumber isbnNumber = isbnService.generateIsbn(true);
    String isbn13 = isbnNumber.isbn13;

    JsonObject issnJsonObject = issnService.generateIssn();
    String issn = issnJsonObject.getJsonString("issn").getString();

    return Json.createObjectBuilder()
      .add("isbn13", isbn13)
      .add("isbn10", issn)
      .build();
  }
  // tag::adocSkip[]

  @GET
  @Path("/numbers/prog")
  public JsonObject generateBookNumbersProgrammaticaly() throws URISyntaxException {

    // Invoking the Isbn Microservice
    // tag::adocProgrammatic[]
    IsbnService isbnService = RestClientBuilder.newBuilder()
      .baseUri(new URI("http://localhost:9081"))
      .build(IsbnService.class);

    IsbnNumber isbnNumber = isbnService.generateIsbn(false);
    // end::adocProgrammatic[]
    String isbn13 = isbnNumber.isbn13;

    // Invoking the Issn Microservice
    IssnService issnService = RestClientBuilder.newBuilder()
      .baseUri(new URI("http://localhost:9082"))
      .build(IssnService.class);
    JsonObject issnJsonObject = issnService.generateIssn();
    String issn = issnJsonObject.getJsonString("issn").getString();

    return Json.createObjectBuilder()
      .add("isbn13", isbn13)
      .add("isbn10", issn)
      .build();
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
