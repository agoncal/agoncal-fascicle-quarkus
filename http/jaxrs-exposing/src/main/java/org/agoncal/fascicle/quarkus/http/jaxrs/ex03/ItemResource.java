package org.agoncal.fascicle.quarkus.http.jaxrs.ex03;

import org.agoncal.fascicle.quarkus.http.jaxrs.Book;
import org.agoncal.fascicle.quarkus.http.jaxrs.CD;
import org.agoncal.fascicle.quarkus.http.jaxrs.Item;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
// tag::adocSnippet[]
@Path("/items")
public class ItemResource {

  @GET
  public List<Item> getItems() {
    // URI : /items
    // tag::adocSkip1[]
    return List.of(new Book("The Hitchhiker's Guide to the Galaxy", 12.5F, "Science fiction comedy book", "1-84023-742-2", 354, false));
    // end::adocSkip1[]
  }

  @GET
  @Path("/cds")
  public List<CD> getCDs() {
    // URI : /items/cds
    // tag::adocSkip2[]
    return List.of(new CD("Help", 12.5F, "Best Beatles album", "EMI", 1, 45.6F, "Pop"));
    // end::adocSkip2[]
  }

  @GET
  @Path("/books")
  public List<Book> getBooks() {
    // URI : /items/books
    // tag::adocSkip3[]
    return List.of(new Book("The Hitchhiker's Guide to the Galaxy", 12.5F, "Science fiction comedy book", "1-84023-742-2", 354, false));
    // end::adocSkip3[]
  }

  @POST
  @Path("/books")
  public Response createBook(Book book) throws URISyntaxException {
    // URI : /items/book
    // tag::adocSkip4[]
    return Response.created(new URI("http://localhost:8080/items/book/1234")).build();
    // end::adocSkip4[]
  }
}
// end::adocSnippet[]
