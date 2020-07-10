package org.agoncal.fascicle.quarkus.http.jaxrs.ex02;

import org.agoncal.fascicle.quarkus.http.jaxrs.Book;
import org.agoncal.fascicle.quarkus.http.jaxrs.Item;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
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
    List<Item> items = new ArrayList<>();
    items.add(new Book("The Hitchhiker's Guide to the Galaxy", 12.5F, "Science fiction comedy book", "1-84023-742-2", 354, false));
    items.add(new Book("The Hitchhiker's Guide to the Galaxy", 12.5F, "Science fiction comedy book", "1-84023-742-2", 354, false));
    return items;
    // end::adocSkip[]
  }
}
// end::adocSnippet[]
