package org.agoncal.fascicle.quarkus.http.openapi.custom;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// @formatter:off
// tag::adocSnippet[]
@Path("/authors")
@Produces(MediaType.TEXT_PLAIN)
public class AuthorResource {

  String[] scifiAuthors = {"Isaac Asimov", "Ray Bradbury", "Douglas Adams"};

  @GET
  @Path("/{index}")
  @Operation(summary = "Returns an author for a given index")
  @APIResponse(responseCode = "204", description = "Author not found")
  @APIResponse(responseCode = "200",
               description  = "Author returned for a given index")
  public String getScifiAuthor(@PathParam("index") int index) {
    return scifiAuthors[index];
  }
}
// end::adocSnippet[]
