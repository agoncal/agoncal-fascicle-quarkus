package org.agoncal.fascicle.quarkus.data.panache.rest;

import org.agoncal.fascicle.quarkus.data.panache.model.Publisher;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import java.util.List;
import java.util.Optional;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
@Path("/publishers")
public class PublisherResource {

  // ======================================
  // =           Public Methods           =
  // ======================================

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public Response create(Publisher publisher) {
    Publisher.persist(publisher);
    return Response.created(UriBuilder.fromResource(PublisherResource.class).path(String.valueOf(publisher.id)).build()).build();
  }

  @DELETE
  @Path("/{id:[0-9][0-9]*}")
  public Response deleteById(@PathParam("id") Long id) {
    Publisher publisher = Publisher.findById(id);
    if (publisher == null) {
      return Response.status(Status.NOT_FOUND).build();
    }
    publisher.delete();
    return Response.noContent().build();
  }

  @GET
  @Path("/{id:[0-9][0-9]*}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response findById(@PathParam("id") Long id) {
    Optional<Publisher> publisher = Publisher.findByIdOptional(id);
    if (publisher.isPresent()) {
      return Response.ok(publisher).build();
    } else {
      return Response.noContent().build();
    }
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<Publisher> listAll(@QueryParam("start") Integer startPosition, @QueryParam("max") Integer maxResult) {
    return Publisher.listAll();
  }

  @PUT
  @Path("/{id:[0-9][0-9]*}")
  @Consumes(MediaType.APPLICATION_JSON)
  public Response update(Publisher publisher) {
    Publisher entity = Publisher.findById(publisher.id);
    entity.name = publisher.name;
    return Response.ok(entity).build();
  }
}
