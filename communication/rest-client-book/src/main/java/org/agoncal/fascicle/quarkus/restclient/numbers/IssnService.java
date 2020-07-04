package org.agoncal.fascicle.quarkus.restclient.numbers;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

// tag::adocSnippet[]
@Path("/api/issn")
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient
public interface IssnService {

  @GET
  JsonObject generateIssn();
}
// end::adocSnippet[]
