package org.agoncal.fascicle.quarkus.test.mock.alternative;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

// tag::adocSnippet[]
@Path("/api/numbers")
@RegisterRestClient
public interface IsbnResourceProxy {

  @GET
  IsbnNumbers generateIsbnNumbers();
}
// end::adocSnippet[]
