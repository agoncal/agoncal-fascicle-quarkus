package org.agoncal.fascicle.quarkus.core.profiles;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
@Path("/numbers")
@Produces(MediaType.TEXT_PLAIN)
public class NumberGeneratorResource {

  @Inject
  NumberGenerator numberGenerator;

  @GET
  public Response getAllArtists() {
    return Response.ok(numberGenerator.generateNumber()).build();
  }

}
