package org.agoncal.fascicle.quarkus.core.logging;

import io.quarkus.logging.Log;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/logs/simple")
public class SimplifiedLoggingResource {

  // tag::adocSnippet[]
  @GET
  public void displayLogs() {
    Log.info("Trace produced by Simplified Logging API");
  }
  // end::adocSnippet[]
}
