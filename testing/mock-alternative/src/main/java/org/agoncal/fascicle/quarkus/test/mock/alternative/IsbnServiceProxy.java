package org.agoncal.fascicle.quarkus.test.mock.alternative;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

// tag::adocSnippet[]
@Path("/api/numbers")
@RegisterRestClient
public interface IsbnServiceProxy {

  @GET
  IsbnNumbers generateIsbnNumbers();
}
// end::adocSnippet[]
