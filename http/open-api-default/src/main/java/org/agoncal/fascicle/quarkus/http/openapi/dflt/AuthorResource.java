package org.agoncal.fascicle.quarkus.http.openapi.dflt;

import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;

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
// tag::adocSnippet[]
@Path("/authors")
@Produces(MediaType.TEXT_PLAIN)
public class AuthorResource {

  String[] scifiAuthors = {"Isaac Asimov", "Ray Bradbury", "Douglas Adams"};

  @GET
  @Path("/{index}")
  public String getScifiAuthor(@Parameter(description = "Author index", required = true) @PathParam("index") int index) {
    return scifiAuthors[index];
  }
}
// end::adocSnippet[]
