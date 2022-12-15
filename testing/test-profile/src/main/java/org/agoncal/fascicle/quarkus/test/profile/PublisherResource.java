package org.agoncal.fascicle.quarkus.test.profile;

import io.quarkus.runtime.StartupEvent;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.time.Duration;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Path("/publishers")
@Produces(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class PublisherResource {

  private Instant startTimestamp;
  private final DateTimeFormatter formatter = DateTimeFormatter.ISO_INSTANT;

  @Inject
  PublisherService service;

  @GET
  public List<Publisher> findAll() {
    return service.findAll();
  }

  @GET
  @Path("/{id:\\d{3,5}}")
  public Optional<Publisher> findById(@PathParam("id") Long id) {
    return service.findByIdOptional(id);
  }

  @GET
  @Path("/{name: [a-zA-Z]*}")
  public Optional<Publisher> findByName(@PathParam("name") String name) {
    return service.findByName(name);
  }

  @DELETE
  @Path("/{id:\\d{3,5}}")
  public void deleteById(@PathParam("id") Long id) {
    service.deleteById(id);
  }

  @DELETE
  @Path("/{name: [a-zA-Z]*}")
  public void deleteByName(@PathParam("name") String name) {
    service.deleteByName(name);
  }

  @PUT
  public Publisher persist(Publisher publisher) {
    return service.persist(publisher);
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
