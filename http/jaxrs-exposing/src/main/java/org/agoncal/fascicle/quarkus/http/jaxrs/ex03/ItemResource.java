package org.agoncal.fascicle.quarkus.http.jaxrs.ex03;

import org.agoncal.fascicle.quarkus.http.jaxrs.Book;
import org.agoncal.fascicle.quarkus.http.jaxrs.Books;
import org.agoncal.fascicle.quarkus.http.jaxrs.CD;
import org.agoncal.fascicle.quarkus.http.jaxrs.CDs;
import org.agoncal.fascicle.quarkus.http.jaxrs.Items;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
  public Items getItems() {
    // URI : /items
    // tag::adocSkip1[]
    Items items = new Items();
    items.add(new Book("The Hitchhiker's Guide to the Galaxy", 12.5F, "Science fiction comedy book", "1-84023-742-2", 354, false));
    return items;
    // end::adocSkip1[]
  }

  @GET
  @Path("/cds")
  public CDs getCDs() {
    // URI : /items/cds
    // tag::adocSkip2[]
    CDs cds = new CDs();
    cds.add(new CD("Help", 12.5F, "Best Beatles album", "EMI", 1, 45.6F, "Pop"));
    return cds;
    // end::adocSkip2[]
  }

  @GET
  @Path("/books")
  public Books getBooks() {
    // URI : /items/books
    // tag::adocSkip3[]
    Books books = new Books();
    books.add(new Book("The Hitchhiker's Guide to the Galaxy", 12.5F, "Science fiction comedy book", "1-84023-742-2", 354, false));
    return books;
    // end::adocSkip3[]
  }

  @POST
  @Path("/books")
  public Response createBook(Book book) {
    // URI : /items/book
    // tag::adocSkip4[]
    return Response.created(null).build();
    // end::adocSkip4[]
  }
}
// end::adocSnippet[]
