package org.agoncal.fascicle.quarkus.http.jaxrs.ex02;

import org.agoncal.fascicle.quarkus.http.jaxrs.Book;
import org.agoncal.fascicle.quarkus.http.jaxrs.Item;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
// tag::adocSnippet[]
@Path("/items/toprated")
public class ItemResource {

  @GET
  public List<Item> getItems() {
    // ...
    // tag::adocSkip[]
    return List.of(
      new Book("The Hitchhiker's Guide to the Galaxy", 12.5F, "Science fiction comedy book", "1-84023-742-2", 354, false),
      new Book("The Hitchhiker's Guide to the Galaxy", 12.5F, "Science fiction comedy book", "1-84023-742-2", 354, false)
    );
    // end::adocSkip[]
  }
}
// end::adocSnippet[]
