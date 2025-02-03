package org.agoncal.fascicle.quarkus.http.openapi.custom;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

// @formatter:off
// tag::adocSnippet[]
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

@Path("/authors")
@Produces(MediaType.TEXT_PLAIN)
public class AuthorResource {

  String[] scifiAuthors = {"Isaac Asimov", "Nora Jemisin", "Douglas Adams"};

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
