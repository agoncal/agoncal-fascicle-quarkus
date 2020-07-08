package org.agoncal.fascicle.quarkus.faulttolerance.book;

import com.github.javafaker.Faker;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.time.Instant;

// tag::adocSnippet[]
@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class BookResource {

  // tag::adocSkip[]
  private static final Logger LOGGER = Logger.getLogger(BookResource.class);

  private Faker faker = new Faker();
  // end::adocSkip[]
  @Inject
  @RestClient
  NumberService numberService;

  // tag::adocFallback[]
  @GET
  @Path("/numbers")
  @Fallback(fallbackMethod = "fallbackGenerateBookNumbers")
  public JsonObject generateBookNumbers() {

    // tag::adocSkip[]
    LOGGER.info("Generating book numbers");
    // end::adocSkip[]
    // Invoking microservices
    IsbnNumber isbnNumber = numberService.generateIsbn(true);
    JsonObject issnNumber = numberService.generateIssn();

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
    JsonObject issnNumber = numberService.generateIssn();

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
  @Path("/legacy")
  // tag::adocCircuitBreaker[]
  @POST
  @Timeout(250)
  @Fallback(fallbackMethod = "fallbackCreateLegacyBook")
  @CircuitBreaker(requestVolumeThreshold = 4, failureRatio = 0.5, delay = 2000, successThreshold = 2)
  public Book createLegacyBook() {
    // tag::adocSkip[]
    LOGGER.info("Creating a legacy book");
    // end::adocSkip[]
    // Invoking microservice
    JsonObject issnNumber = numberService.generateIssn();

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
