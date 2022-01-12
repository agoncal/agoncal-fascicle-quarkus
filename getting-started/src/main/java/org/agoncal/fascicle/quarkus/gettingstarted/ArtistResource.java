package org.agoncal.fascicle.quarkus.gettingstarted;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.quarkus.runtime.annotations.RegisterForReflection;

import java.util.List;
import java.util.UUID;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
@Path("/artists")
public class ArtistResource {

  private static final List<Artist> artists = List.of(
    new Artist().id(UUID.randomUUID()).firstName("John").lastName("Lennon"),
    new Artist().id(UUID.randomUUID()).firstName("Paul").lastName("McCartney"),
    new Artist().id(UUID.randomUUID()).firstName("George").lastName("Harrison"),
    new Artist().id(UUID.randomUUID()).firstName("Ringo").lastName("Starr")
  );

  // tag::adocSkip[]
  /**
   * curl http://localhost:8080/vintage-store/artists
   * curl http://localhost:8080/vintage-store/artists | jq
   * curl http://localhost:8080/vintage-store/artists -v
   * curl -X GET http://localhost:8080/vintage-store/artists -v
   * curl -X GET -H "Accept: application/json" http://localhost:8080/vintage-store/artists -v
   */
  // end::adocSkip[]
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAllArtists() {
    // The Artist class must have an annotation @RegisterForReflection to work in native mode
    // Other Option is to directly return List<Artist>, in that case Quarkus know to enable reflection
    // see https://quarkus.io/guides/rest-json#conclusion for reference
    return Response.ok(artists).build();
  }

  // tag::adocSkip[]
  /**
   * curl http://localhost:8080/vintage-store/artists/count
   * curl http://localhost:8080/vintage-store/artists/count -v
   * curl -X GET -H "Accept: text/plain" http://localhost:8080/vintage-store/artists/count -v
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
