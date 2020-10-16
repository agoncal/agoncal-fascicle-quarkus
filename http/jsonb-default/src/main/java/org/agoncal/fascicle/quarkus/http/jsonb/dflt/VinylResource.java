package org.agoncal.fascicle.quarkus.http.jsonb.dflt;

import javax.inject.Inject;
import javax.json.bind.Jsonb;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

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
