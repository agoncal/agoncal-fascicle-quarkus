package org.agoncal.fascicle.quarkus.faulttolerance.isbn;

import com.github.javafaker.Faker;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
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
  int secondsToSleep = 0;

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
