package org.agoncal.fascicle.quarkus.test.mock.inject;

import com.github.javafaker.Faker;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.inject.Inject;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

// @formatter:off
// tag::adocSnippet[]
@Path("/api/books")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

  @Inject @RestClient
  IsbnResourceProxy isbnService;

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
