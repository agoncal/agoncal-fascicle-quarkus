package org.agoncal.fascicle.quarkus.observability.health.liveready;

import com.github.javafaker.Faker;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.time.Instant;

@Path("/api/numbers")
@Produces(MediaType.APPLICATION_JSON)
public class NumberResource {

  @GET
  public JsonObject generateRandom() {
    return Json.createObjectBuilder()
      .add("isbn10", new Faker().code().isbn10())
      .add("generatedAt", String.valueOf(Instant.now()))
      .build();
  }
}
