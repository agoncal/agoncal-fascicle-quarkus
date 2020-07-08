package org.agoncal.fascicle.quarkus.faulttolerance.book;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

// tag::adocSnippet[]
@Path("/api/numbers")
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient
public interface NumberService {

  @GET
  @Path("/issn")
  JsonObject generateIssn();

  @GET
  @Path("/isbn")
  IsbnNumber generateIsbn(@QueryParam("separator") boolean separator);
}
// end::adocSnippet[]
