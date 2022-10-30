package org.agoncal.fascicle.quarkus.faulttolerance.book;

import net.datafaker.Faker;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.time.Instant;

// @formatter:off
// tag::adocSnippet[]
@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class BookResource {

  // tag::adocSkip[]
  private static final Logger LOGGER = Logger.getLogger(BookResource.class);

  private Faker faker = new Faker();
  // end::adocSkip[]
  @RestClient
  NumberProxy numberProxy;

  // tag::adocFallback[]
  @GET
  @Path("/numbers")
  @Fallback(fallbackMethod = "fallbackGenerateBookNumbers")
  public JsonObject generateBookNumbers() {

    // tag::adocSkip[]
    LOGGER.info("Generating book numbers");
    // end::adocSkip[]
    // Invoking microservices
    IsbnNumber isbnNumber = numberProxy.generateIsbn(true);
    JsonObject issnNumber = numberProxy.generateIssn();

    return Json.createObjectBuilder()
      .add("isbn13", isbnNumber.isbn13)
      .add("gs1", isbnNumber.gs1)
      .add("isbn10", issnNumber.getJsonString("isbn10").getString())
      .build();
  }

  private JsonObject fallbackGenerateBookNumbers() {
    // tag::adocSkip[]
    LOGGER.warn("Falling back on generating book numbers");
    // end::adocSkip[]
    return Json.createObjectBuilder()
      .add("isbn13", "dummy isbn")
      .add("gs1", "dummy gs1")
      .add("isbn10", "dummy issn")
      .build();
  }
  // end::adocFallback[]
  // tag::adocTimeout[]
  @POST
  @Timeout(250)
  @Fallback(fallbackMethod = "fallbackCreateBook")
  public Book createBook() {
    // tag::adocSkip[]
    LOGGER.info("Creating book");
    // end::adocSkip[]

    // Invoking microservice
    JsonObject issnNumber = numberProxy.generateIssn();

    Book book = new Book();
    book.title = faker.book().title();
    book.issn = issnNumber.getString("isbn10");
    book.generatedAt = Instant.now();

    return book;
  }

  private Book fallbackCreateBook() {
    // tag::adocSkip[]
    LOGGER.warn("Falling back on creating a book");
    // end::adocSkip[]
    Book book = new Book();
    book.title = "dummy title";
    book.issn = "dummy issn";
    book.generatedAt = Instant.now();
    return book;
  }
  // end::adocTimeout[]
  // tag::adocSkip[]
  @Path("/legacy")
  @Timeout(250)
  // end::adocSkip[]
  // tag::adocCircuitBreaker[]
  @POST
  @Fallback(fallbackMethod = "fallbackCreateLegacyBook")
  @CircuitBreaker(requestVolumeThreshold = 4, failureRatio = 0.5,
                  delay = 2000, successThreshold = 2)
  public Book createLegacyBook() {
    // tag::adocSkip[]
    LOGGER.info("Creating a legacy book");
    // end::adocSkip[]

    // Invoking microservice
    JsonObject issnNumber = numberProxy.generateIssn();

    Book book = new Book();
    book.title = faker.book().title();
    book.issn = issnNumber.getString("isbn10");
    book.generatedAt = Instant.now();

    return book;
  }

  private Book fallbackCreateLegacyBook() {
    // tag::adocSkip[]
    LOGGER.warn("Falling back on creating a legacy book");
    // end::adocSkip[]
    Book book = new Book();
    book.title = "dummy legacy title";
    book.issn = "dummy legacy issn";
    book.generatedAt = Instant.now();
    return book;
  }
  // end::adocCircuitBreaker[]
}
// end::adocSnippet[]
