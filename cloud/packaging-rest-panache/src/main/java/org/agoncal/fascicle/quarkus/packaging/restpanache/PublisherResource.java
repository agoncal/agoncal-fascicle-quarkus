package org.agoncal.fascicle.quarkus.packaging.restpanache;

import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
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
