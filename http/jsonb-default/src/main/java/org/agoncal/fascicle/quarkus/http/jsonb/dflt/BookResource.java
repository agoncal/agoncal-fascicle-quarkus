package org.agoncal.fascicle.quarkus.http.jsonb.dflt;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

// @formatter:off
@Path("/api/books")
public class BookResource {

  @Path("/string")
  // tag::adocGetBookAsString[]
  @GET
  @Produces(APPLICATION_JSON)
  public String getBookAsString() {

    Book book = new Book().title("H2G2").price(12.5F).isbn("1-84023-742-2");
    Jsonb jsonb = JsonbBuilder.create();
    String json = jsonb.toJson(book);

    return json;
  }
  // end::adocGetBookAsString[]

  @Path("/stringresp")
  // tag::adocGetBookAsResponseString[]
  @GET
  @Produces(APPLICATION_JSON)
  public Response getBookAsResponseString() {

    Book book = new Book().title("H2G2").price(12.5F).isbn("1-84023-742-2");
    Jsonb jsonb = JsonbBuilder.create();
    String json = jsonb.toJson(book);

    return Response.ok(json).build();
  }
  // end::adocGetBookAsResponseString[]

  @Path("/book")
  // tag::adocGetBook[]
  @GET
  @Produces(APPLICATION_JSON)
  public Book getBook() {

    Book book = new Book().title("H2G2").price(12.5F).isbn("1-84023-742-2");

    return book;
  }
  // end::adocGetBook[]

  @Path("/bookresp")
  // tag::adocGetBookResponse[]
  @GET
  @Produces(APPLICATION_JSON)
  public Response getBookAsResponse() {

    Book book = new Book().title("H2G2").price(12.5F).isbn("1-84023-742-2");

    return Response.ok(book).build();
  }
  // end::adocGetBookResponse[]
}
