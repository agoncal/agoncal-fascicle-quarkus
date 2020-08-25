package org.agoncal.fascicle.quarkus.packaging.restpanache;

import io.quarkus.runtime.StartupEvent;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Path("/publishers")
@Produces(MediaType.APPLICATION_JSON)
public class PublisherResource {

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
    String date = new SimpleDateFormat("HH:mm:ss.SSS").format(new Date());
    System.out.println("First request served at : " + date);
    return date;
  }

  void onStart(@Observes StartupEvent startup) {
    String date = new SimpleDateFormat("HH:mm:ss.SSS").format(new Date());
    System.out.println("Startup at : " + date);
  }
}
