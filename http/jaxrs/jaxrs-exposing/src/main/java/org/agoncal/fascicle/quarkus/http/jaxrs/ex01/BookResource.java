package org.agoncal.fascicle.quarkus.http.jaxrs.ex01;

// @formatter:off
// tag::adocSnippet[]
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("/book")
public class BookResource {

  @GET
  @Produces("text/plain")
  public String getBookTitle() {
    return "H2G2";
  }
}
// end::adocSnippet[]
