package org.agoncal.fascicle.quarkus.http.jsonb.jaxrs;

import jakarta.inject.Inject;
import jakarta.json.bind.Jsonb;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

// @formatter:off
// tag::adocSnippet[]
@Path("/api/vinyl")
public class VinylResource {

  @Inject
  Jsonb jsonb;

  @GET
  @Produces(APPLICATION_JSON)
  public String getVinyl() {

    Vinyl vinyl = new Vinyl().title("Horses").artist("Patti Smith")
                                             .musicCompany("Arista Records");
    return jsonb.toJson(vinyl);
  }
}
// end::adocSnippet[]
