package org.agoncal.fascicle.quarkus.restclient.issn;

import com.github.javafaker.Faker;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

// tag::adocSnippet[]
@Path("/api/issn")
@Produces(MediaType.APPLICATION_JSON)
public class IssnResource {

  @GET
  public JsonObject generateIssn() {
    String issn = new Faker().code().isbn10();
    return Json.createObjectBuilder()
      .add("issn", issn)
      .build();
  }
}
// end::adocSnippet[]
