package org.agoncal.fascicle.quarkus.gettingstarted;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
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
@Consumes(MediaType.APPLICATION_JSON)
public class ArtistResource {

  private static ArrayList<Artist> artists = new ArrayList<>(Arrays.asList(
    new Artist(UUID.randomUUID(), "John", "Lennon"),
    new Artist(UUID.randomUUID(), "Paul", "McCartney"),
    new Artist(UUID.randomUUID(), "George", "Harrison"),
    new Artist(UUID.randomUUID(), "Ringo", "Starr")
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
   * curl http://localhost:8080/cdbookstore/artists/e3d65ee3-7580-4dc1-b975-250cf7b8a456
   * curl http://localhost:8080/cdbookstore/artists/e3d65ee3-7580-4dc1-b975-250cf7b8a456 | jq
   * curl http://localhost:8080/cdbookstore/artists/e3d65ee3-7580-4dc1-b975-250cf7b8a456 -v
   * curl -X GET http://localhost:8080/cdbookstore/artists/e3d65ee3-7580-4dc1-b975-250cf7b8a456
   */
  // end::adocSkip[]
  @GET
  @Path("/{id}")
  public Response getArtist(@PathParam("id") UUID id) {
    Artist artist = artists.stream()
      .filter(a -> id.equals(a.getId()))
      .findFirst()
      .orElse(null);
    return Response.ok(artist).build();
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

  /**
   * curl -d '{"id":"8b3445fe-a0f8-4189-b39c-4c35dcd685b2", "firstName":"George", "lastName":"Martin"}' -X POST -H "Content-Type: application/json" http://localhost:8080/cdbookstore/artists -v
   */
// tag::adocCreateDelete[]
  @POST
  public Response createArtist(@Context UriInfo uriInfo, Artist artist) {
    artist.setId(UUID.randomUUID());
    artists.add(artist);
    URI uri = uriInfo.getAbsolutePathBuilder().path(artist.getId().toString()).build();
    return Response.created(uri).build();
  }

  // tag::adocSkip[]
  /**
   * curl -X DELETE http://localhost:8080/cdbookstore/artists/e3d65ee3-7580-4dc1-b975-250cf7b8a456
   * curl -X DELETE http://localhost:8080/cdbookstore/artists/e3d65ee3-7580-4dc1-b975-250cf7b8a456 -v
   */
  // tag::adocSkip[]
  @DELETE
  @Path("/{id}")
  public Response deleteArtist(@PathParam("id") UUID id) {
    artists.remove((new Artist(id)));
    return Response.noContent().build();
  }
  // end::adocCreateDelete[]
}
// end::adocSnippet[]
