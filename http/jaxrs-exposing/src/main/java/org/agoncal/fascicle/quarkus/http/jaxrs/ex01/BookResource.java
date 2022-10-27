package org.agoncal.fascicle.quarkus.http.jaxrs.ex01;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
@Path("/book")
public class BookResource {

  @GET
  @Produces("text/plain")
  public String getBookTitle() {
    return "H2G2";
  }
}
// end::adocSnippet[]
