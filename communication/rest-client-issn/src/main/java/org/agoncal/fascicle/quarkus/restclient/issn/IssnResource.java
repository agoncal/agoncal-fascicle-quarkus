package org.agoncal.fascicle.quarkus.restclient.issn;

import com.github.javafaker.Faker;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

// tag::adocSnippet[]
@Path("/api/issn")
@Produces(MediaType.APPLICATION_JSON)
@ApplicationScoped
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
