package org.agoncal.fascicle.quarkus.puttingtogether.generator;

import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

@ApplicationScoped
@Path("/numbers")
@Produces(TEXT_PLAIN)
public class NumberResource {

  private final Logger log = LoggerFactory.getLogger(NumberResource.class);

  @GET
  @Path("book")
  @Operation(summary = "Generates a book number")
  @APIResponse(responseCode = "200", content = @Content(mediaType = TEXT_PLAIN, schema = @Schema(implementation = String.class, required = true)))
  @Counted(name = "countGenerateBookNumber", description = "Counts how many times the generateBookNumber method has been invoked")
  @Timed(name = "timeGenerateBookNumber", description = "Times how long it takes to invoke the generateBookNumber method", unit = MetricUnits.MILLISECONDS)
  public Response generateBookNumber() {
    log.info("Generating a book number");
    return Response.ok("BK-" + Math.random()).build();
  }
}
