package org.agoncal.fascicle.quarkus.faulttolerance.isbn;

import com.github.javafaker.Faker;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

// tag::adocSnippet[]
@Path("/api/numbers")
@Produces(MediaType.APPLICATION_JSON)
public class NumberResource {

  // tag::adocSkip[]
  private static final Logger LOGGER = Logger.getLogger(NumberResource.class);

  // end::adocSkip[]
  @ConfigProperty(name = "seconds.sleep", defaultValue = "0")
  int secondsToSleep;

  @GET
  @Path("/issn")
  public JsonObject generateIssn() throws InterruptedException {
    LOGGER.info("Waiting for " + secondsToSleep + " seconds");
    TimeUnit.SECONDS.sleep(secondsToSleep);
    JsonObject issnNumber = Json.createObjectBuilder()
      .add("isbn10", new Faker().code().isbn10())
      .add("generatedAt", String.valueOf(Instant.now()))
      .build();
    LOGGER.info("Generated ISSN number: " + issnNumber.toString());
    return issnNumber;
  }
  // tag::adocSkip[]

  @GET
  @Path("/isbn")
  public IsbnNumber generateIsbn(@DefaultValue("true") @QueryParam("separator") boolean separator) {
    IsbnNumber isbnNumber = new IsbnNumber();
    isbnNumber.isbn13 = new Faker().code().isbn13(separator);
    isbnNumber.gs1 = new Faker().code().isbnGs1();
    isbnNumber.generatedAt = Instant.now();
    LOGGER.info("Generated ISBN number: " + isbnNumber);
    return isbnNumber;
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
