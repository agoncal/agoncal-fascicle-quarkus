package org.agoncal.fascicle.quarkus.test.mock.inject;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

// tag::adocSnippet[]
@Path("/api/numbers")
@ApplicationScoped
@RegisterRestClient
public interface IsbnServiceProxy {

  @GET
  IsbnNumbers generateIsbnNumbers();
}
// end::adocSnippet[]
