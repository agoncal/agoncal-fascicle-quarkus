package org.agoncal.fascicle.quarkus.test.jvmnativemode;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
@Path("/artists")
@Produces(MediaType.APPLICATION_JSON)
public class ArtistResource {

  private static final List<Artist> artists = List.of(
    new Artist().id(1).firstName("John").lastName("Lennon"),
    new Artist().id(2).firstName("Paul").lastName("McCartney"),
    new Artist().id(3).firstName("George").lastName("Harrison"),
    new Artist().id(4).firstName("Ringo").lastName("Starr")
  );

  /**
   * curl http://localhost:8080/vintage-store/artists
   * curl http://localhost:8080/vintage-store/artists | jq
   * curl http://localhost:8080/vintage-store/artists -v
   * curl -X GET http://localhost:8080/vintage-store/artists -v
   * curl -X GET -H "Accept: application/json" http://localhost:8080/vintage-store/artists -v
   */
  @GET
  public Response getAllArtists() {
    return Response.ok(artists).build();
  }

  /**
   * curl http://localhost:8080/vintage-store/artists/1
   * curl http://localhost:8080/vintage-store/artists/1 | jq
   * curl http://localhost:8080/vintage-store/artists/1 -v
   * curl -X GET http://localhost:8080/vintage-store/artists/1 -v
   * curl -X GET -H "Accept: application/json" http://localhost:8080/vintage-store/artists/1 -v
   */
  @GET
  @Path("/{id}")
  public Response getArtist(@PathParam("id") Integer id) {
    Optional<Artist> artist = artists.stream().filter(a -> a.getId().equals(id)).findFirst();
    if (artist.isPresent()) {
      return Response.ok(artist.get()).build();
    } else {
      return Response.noContent().build();
    }
  }

  /**
   * curl http://localhost:8080/vintage-store/artists/count
   * curl http://localhost:8080/vintage-store/artists/count -v
   * curl -X GET -H "Accept: text/plain" http://localhost:8080/vintage-store/artists/count -v
   */
  @GET
  @Path("/count")
  @Produces(MediaType.TEXT_PLAIN)
  public Integer countArtists() {
    return artists.size();
  }
}
