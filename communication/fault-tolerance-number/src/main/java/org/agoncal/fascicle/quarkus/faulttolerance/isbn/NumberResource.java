package org.agoncal.fascicle.quarkus.faulttolerance.isbn;

import com.github.javafaker.Faker;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

// @formatter:off
// tag::adocSnippet[]
@Path("/api/numbers")
@Produces(MediaType.APPLICATION_JSON)
public class NumberResource {

  @GET
  @Path("/isbn")
  public IsbnNumber generateIsbn(
                    @DefaultValue("true")
                    @QueryParam("separator") boolean separator) {
    IsbnNumber isbnNumber = new IsbnNumber();
    isbnNumber.isbn13 = new Faker().code().isbn13(separator);
    isbnNumber.gs1 = new Faker().code().isbnGs1();
    return isbnNumber;
  }

  @GET
  @Path("/issn")
  public JsonObject generateIssn() {
    return Json.createObjectBuilder()
      .add("isbn10", new Faker().code().isbn10())
      .build();
  }
}
// end::adocSnippet[]
