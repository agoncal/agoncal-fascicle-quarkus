package org.agoncal.fascicle.quarkus.book;

import com.github.javafaker.Faker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDateTime;
import java.util.logging.Logger;

@Path("/api/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookResource {

  private final static Logger LOGGER = Logger.getLogger(BookResource.class.getName());

  @Inject
  @RestClient
  IsbnNumbersService isbnNumbersService;

  @GET
  @Fallback(fallbackMethod = "fallbackGetRandomBook")
  public Response getRandomBook() {

    IsbnNumbers isbnNumbers = isbnNumbersService.generateIsbnNumbers();

    Faker faker = new Faker();
    JsonObject book = Json.createObjectBuilder()
      .add("isbn_13", isbnNumbers.getIsbn13())
      .add("isbn_10", isbnNumbers.getIsbn10())
      .add("title", faker.book().title())
      .add("author", faker.book().author())
      .add("genre", faker.book().genre())
      .add("publisher", faker.book().publisher())
      .add("timestamp", String.valueOf(LocalDateTime.now()))
      .build();

    LOGGER.info("Random book " + book);
    return Response.ok(book).build();
  }

  private Response fallbackGetRandomBook() {
    LOGGER.warning("Falling back on creating a book");
    JsonObject dummyBook = Json.createObjectBuilder()
      .add("title", "Dummy book")
      .add("timestamp", String.valueOf(LocalDateTime.now()))
      .build();
    return Response.ok(dummyBook).build();
  }
}
