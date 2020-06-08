package org.agoncal.fascicle.quarkus.core.profiles;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
