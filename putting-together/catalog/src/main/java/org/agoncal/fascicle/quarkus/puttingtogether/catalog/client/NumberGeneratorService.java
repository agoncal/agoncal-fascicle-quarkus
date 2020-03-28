// tag::adocRestClient[]
package org.agoncal.fascicle.quarkus.puttingtogether.catalog.client;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api/numbers")
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient
public interface NumberGeneratorService {

    @GET
    @Path("/book")
    String generateBookNumber();
}
// end::adocRestClient[]
