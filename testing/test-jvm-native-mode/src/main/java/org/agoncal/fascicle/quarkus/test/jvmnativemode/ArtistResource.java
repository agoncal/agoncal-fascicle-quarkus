package org.agoncal.fascicle.quarkus.test.jvmnativemode;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
@Path("/artists")
@Produces(MediaType.APPLICATION_JSON)
public class ArtistResource {

  private static ArrayList<Artist> artists = new ArrayList<>(Arrays.asList(
    new Artist().id(UUID.randomUUID()).firstName("John").lastName("Lennon"),
    new Artist().id(UUID.randomUUID()).firstName("Paul").lastName("McCartney"),
    new Artist().id(UUID.randomUUID()).firstName("George").lastName("Harrison"),
    new Artist().id(UUID.randomUUID()).firstName("Ringo").lastName("Starr")
  ));

  // tag::adocSkip[]
  /**
   * curl http://localhost:8080/cdbookstore/artists
   * curl http://localhost:8080/cdbookstore/artists | jq
   * curl http://localhost:8080/cdbookstore/artists -v
   * curl -X GET http://localhost:8080/cdbookstore/artists -v
   * curl -X GET -H "Accept: application/json" http://localhost:8080/cdbookstore/artists -v
   */
  // end::adocSkip[]
  @GET
  public Response getAllArtists() {
    return Response.ok(artists).build();
  }

  // tag::adocSkip[]
  /**
   * curl http://localhost:8080/cdbookstore/artists/count
   * curl http://localhost:8080/cdbookstore/artists/count -v
   * curl -X GET -H "Accept: text/plain" http://localhost:8080/cdbookstore/artists/count -v
   */
  // end::adocSkip[]
  @GET
  @Path("/count")
  @Produces(MediaType.TEXT_PLAIN)
  public Integer countArtists() {
    return artists.size();
  }
}
// end::adocSnippet[]
