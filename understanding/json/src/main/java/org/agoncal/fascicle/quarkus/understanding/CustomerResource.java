package org.agoncal.fascicle.quarkus.understanding;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)
public class CustomerResource {

  // ======================================
  // =           Public Methods           =
  // ======================================

  @GET
  @Path("/jsonb")
  public Response getJSonB() {
    Customer customer = new Customer().firstName("Antonio").lastName("Goncalves").email("agoncal.fascicle@gmail.com ").phoneNumber("+33 123 456").dateOfBirth(LocalDate.now());
    return Response.ok(customer).build();
  }

  @Path("/jsonp")
  // tag::adocSnippet[]
  @GET
  public Response getJSonP() {
    JsonObject customer = Json.createObjectBuilder()
      .add("firstName", "Antonio")
      .add("lastName", "Goncalves")
      .add("email", "agoncal.fascicle@gmail.com")
      .add("address", Json.createObjectBuilder()
        .add("street", "21 Ritherdon Rd")
        .add("city", "Brighton")
        .add("country", "UK"))
      .add("phoneNumber", Json.createArrayBuilder()
        .add(Json.createObjectBuilder()
          .add("type", "mobile")
          .add("number", "+33 123 456"))
        .add(Json.createObjectBuilder()
          .add("type", "home")
          .add("number", "+33 646 555")))
      .build();
    return Response.ok(customer).build();
  }
  // end::adocSnippet[]
}
