package org.agoncal.fascicle.quarkus.observability.metrics.application;

import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Gauge;
import org.eclipse.microprofile.metrics.annotation.Metered;
import org.eclipse.microprofile.metrics.annotation.Timed;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import java.util.Optional;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;
import static jakarta.ws.rs.core.Response.Status.NOT_FOUND;

/**
 * curl -H "Accept: application/json " http://localhost:8080/q/metrics/application
 */
//@formatter:off
@Path("/books")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class BookResource {

  @Inject
  BookService service;

  /**
   * while true; do sleep 1; curl http://localhost:8080/books/random; echo; done
   */
  // tag::adocTimed[]
  @GET
  @Path("/random")
  @Counted(name = "countGetRandomBook",
           description = "Counts how many times the createBook method has been invoked")
  // tag::adocSkip[]
  @Timed(name = "timeGetRandomBook",
         description = "Times how long it takes to invoke the getRandomBook method",
         unit = MetricUnits.MILLISECONDS)
  // end::adocSkip[]
  public Response getRandomBook() {
    Book book = service.findRandomBook();
    return Response.ok(book).build();
  }
  // end::adocTimed[]

  /**
   * while true; do sleep 1; curl http://localhost:8080/books; echo; done
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
   * while true; do sleep 1; curl http://localhost:8080/books/1234; echo; done
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
