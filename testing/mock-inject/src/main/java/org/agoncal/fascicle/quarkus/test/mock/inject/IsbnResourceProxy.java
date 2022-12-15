package org.agoncal.fascicle.quarkus.test.mock.inject;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

// tag::adocSnippet[]
@Path("/api/numbers")
@ApplicationScoped
@RegisterRestClient
public interface IsbnResourceProxy {

  @GET
  IsbnNumbers generateIsbnNumbers();
}
// end::adocSnippet[]
