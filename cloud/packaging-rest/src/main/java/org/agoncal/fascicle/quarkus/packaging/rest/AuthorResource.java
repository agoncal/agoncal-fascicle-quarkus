package org.agoncal.fascicle.quarkus.packaging.rest;

import io.quarkus.runtime.StartupEvent;

import javax.enterprise.event.Observes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.time.Duration;
import java.time.Instant;
import java.time.format.DateTimeFormatter;

@Path("/authors")
@Produces(MediaType.TEXT_PLAIN)
public class AuthorResource {

  private Instant startTimestamp;
  private DateTimeFormatter formatter = DateTimeFormatter.ISO_INSTANT;

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
