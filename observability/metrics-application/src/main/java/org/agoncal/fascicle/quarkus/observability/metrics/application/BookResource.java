package org.agoncal.fascicle.quarkus.observability.metrics.application;

import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Gauge;
import org.eclipse.microprofile.metrics.annotation.Metered;
import org.eclipse.microprofile.metrics.annotation.Timed;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.Optional;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;

/**
 * curl -H "Accept: application/json " http://localhost:8080/metrics/application
 */
@Path("/books")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class BookResource {

  @Inject
  BookService service;

  /**
   * curl http://localhost:8080/books/random
   */
  // tag::adocTimed[]
  @GET
  @Path("/random")
  @Counted(name = "countGetRandomBook",
    description = "Counts how many times the createBook method has been invoked")
  @Timed(name = "timeGetRandomBook",
    description = "Times how long it takes to invoke the getRandomBook method",
    unit = MetricUnits.MILLISECONDS)
  public Response getRandomBook() {
    Book book = service.findRandomBook();
    return Response.ok(book).build();
  }
  // end::adocTimed[]

  /**
   * curl http://localhost:8080/books
   */
  // tag::adocGauge[]
  @GET
  @Gauge(name = "gaugeCountAllBooks",
    description = "Instantaneous time of the countAllBooks method",
    unit = "correctness")
  public Long countAllBooks() {
    return service.countAllBooks();
  }
  // end::adocGauge[]

  /**
   * curl http://localhost:8080/books/1234
   */
  // tag::adocMetered[]
  @GET
  @Path("/{id}")
  @Metered(name = "meteredGetBook",
    description = "Measures throughput of the getBook method")
  public Response getBook(@PathParam("id") Long id) {
    Optional<Book> book = service.findBookById(id);
    if (book.isPresent()) {
      return Response.ok(book).build();
    } else {
      return Response.status(NOT_FOUND).build();
    }
  }
  // end::adocMetered[]
}
