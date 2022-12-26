package org.agoncal.fascicle.quarkus.faulttolerance.book;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.json.JsonObject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

// tag::adocSnippet[]
@Path("/api/numbers")
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient
public interface NumberProxy {

  @GET
  @Path("/issn")
  JsonObject generateIssn();

  @GET
  @Path("/isbn")
  IsbnNumber generateIsbn(@QueryParam("separator") boolean separator);
}
// end::adocSnippet[]
