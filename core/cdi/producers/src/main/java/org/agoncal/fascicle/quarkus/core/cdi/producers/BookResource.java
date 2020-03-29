package org.agoncal.fascicle.quarkus.core.cdi.producers;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

// tag::adocSnippet[]
@Path("/books")
@Produces(MediaType.TEXT_PLAIN)
public class BookResource {

  @Inject
  @EightDigits
  NumberGenerator numberGenerator;

  @GET
  @Path("/issn")
  public String getISSN() {
    return numberGenerator.generateNumber();
  }
}
// end::adocSnippet[]
