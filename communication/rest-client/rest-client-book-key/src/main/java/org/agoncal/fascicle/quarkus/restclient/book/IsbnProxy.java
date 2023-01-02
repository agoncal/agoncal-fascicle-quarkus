package org.agoncal.fascicle.quarkus.restclient.book;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

// tag::adocSnippet[]
@Path("/api/isbn")
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient(configKey = "isbnProxy")
public interface IsbnProxy {

  @GET
  IsbnNumber generateIsbn(@QueryParam("separator") boolean separator);
}
// end::adocSnippet[]
