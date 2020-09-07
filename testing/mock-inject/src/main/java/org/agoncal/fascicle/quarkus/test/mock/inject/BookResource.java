package org.agoncal.fascicle.quarkus.test.mock.inject;

import com.github.javafaker.Faker;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

// @formatter:off
// tag::adocSnippet[]
@Path("/api/books")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

  @Inject @RestClient
  IsbnResourceProxy isbnService;

//  final IsbnServiceProxy isbnService;
//
//  @Rest
//  public BookResource(IsbnServiceProxy isbnService) {
//    this.isbnService = isbnService;
//  }

  @GET
  public Response getRandomBook() {

    IsbnNumbers isbnNumbers = isbnService.generateIsbnNumbers();
    // ...
    // tag::adocSkip[]
    Faker faker = new Faker();
    JsonObject book = Json.createObjectBuilder()
      .add("isbn_13", isbnNumbers.getIsbn13())
      .add("isbn_10", isbnNumbers.getIsbn10())
      .add("title", faker.book().title())
      .add("author", faker.book().author())
      .build();

    return Response.ok(book).build();
    // end::adocSkip[]
  }
}
// end::adocSnippet[]
