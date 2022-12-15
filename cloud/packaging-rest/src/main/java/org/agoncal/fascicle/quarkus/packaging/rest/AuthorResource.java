package org.agoncal.fascicle.quarkus.packaging.rest;

import io.quarkus.runtime.StartupEvent;

import jakarta.enterprise.event.Observes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.time.Duration;
import java.time.Instant;
import java.time.format.DateTimeFormatter;

@Path("/authors")
@Produces(MediaType.TEXT_PLAIN)
public class AuthorResource {

  private Instant startTimestamp;
  private final DateTimeFormatter formatter = DateTimeFormatter.ISO_INSTANT;

  String[] scifiAuthors = {"Isaac Asimov", "Nora Jemisin", "Douglas Adams"};

  @GET
  public String getAllScifiAuthors() {
    return String.join(", ", scifiAuthors);
  }

  @GET
  @Path("/{index}")
  public String getScifiAuthor(@PathParam("index") int index) {
    return scifiAuthors[index];
  }

  @GET
  @Path("/ping")
  public String ping() {
    Instant requestTimestamp = Instant.now();
    System.out.println("First request served at : " + formatter.format(requestTimestamp));
    Duration took = Duration.between(startTimestamp, requestTimestamp);
    System.out.println("\nTook : " + took.toMillis() + " ms");
    return requestTimestamp.toString();
  }

  void onStart(@Observes StartupEvent startup) {
    startTimestamp = Instant.now();
    System.out.println("\n\nStartup at : " + formatter.format(startTimestamp));
  }
}
