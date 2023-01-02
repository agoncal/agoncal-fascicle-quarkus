package org.agoncal.fascicle.quarkus.restclient.book;

import org.eclipse.microprofile.rest.client.RestClientBuilder;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.net.URI;
import java.net.URISyntaxException;

// tag::adocSnippet[]
@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class BookResource {

  @RestClient
  IsbnProxy isbnProxy;

  @RestClient
  IssnProxy issnProxy;

  @GET
  @Path("/numbers")
  public JsonObject generateBookNumbers() {

    IsbnNumber isbnNumber = isbnProxy.generateIsbn(true);
    String isbn13 = isbnNumber.isbn13;

    JsonObject issnJsonObject = issnProxy.generateIssn();
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
    IsbnProxy isbnProxy = RestClientBuilder.newBuilder()
      .baseUri(new URI("http://localhost:9081"))
      .build(IsbnProxy.class);

    IsbnNumber isbnNumber = isbnProxy.generateIsbn(false);
    // end::adocProgrammatic[]
    String isbn13 = isbnNumber.isbn13;

    // Invoking the Issn Microservice
    IssnProxy issnProxy = RestClientBuilder.newBuilder()
      .baseUri(new URI("http://localhost:9082"))
      .build(IssnProxy.class);
    JsonObject issnJsonObject = issnProxy.generateIssn();
    String issn = issnJsonObject.getJsonString("issn").getString();

    return Json.createObjectBuilder()
      .add("isbn13", isbn13)
      .add("isbn10", issn)
      .build();
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
