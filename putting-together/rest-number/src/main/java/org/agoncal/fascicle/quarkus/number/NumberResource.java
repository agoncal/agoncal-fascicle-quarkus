package org.agoncal.fascicle.quarkus.number;

import com.github.javafaker.Faker;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.logging.Logger;

// @formatter:off
// tag::adocSnippet[]
@Path("/api/numbers")
@Produces(MediaType.APPLICATION_JSON)
public class NumberResource {

  private final static Logger LOGGER = Logger.getLogger("NumberResource");

  // tag::adocConfig[]
  @ConfigProperty(name = "number.separator", defaultValue = "false")
  boolean separator;

  // end::adocConfig[]
  @GET
  // tag::adocOpenAPI[]
  @Operation(
         summary = "Generates ISBN numbers",
     description = "These ISBN numbers have several formats: ISBN 13 and ISBN 10")
  @APIResponse(
    responseCode = "200",
         content = @Content(mediaType = MediaType.APPLICATION_JSON,
          schema = @Schema(implementation = IsbnNumbers.class)))
  // end::adocOpenAPI[]
  public Response generateIsbnNumbers() {
    Faker faker = new Faker();
    IsbnNumbers isbnNumbers = new IsbnNumbers();
    isbnNumbers.setIsbn10(faker.code().isbn10(separator));
    isbnNumbers.setIsbn13(faker.code().isbn13(separator));
    LOGGER.info("ISBN numbers generated " + isbnNumbers);
    return Response.ok(isbnNumbers).build();
  }
}
// end::adocSnippet[]
