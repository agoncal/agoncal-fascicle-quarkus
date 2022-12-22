package org.agoncal.fascicle.quarkus.core.logging;

// tag::adocSnippet[]
import io.quarkus.logging.Log;

// end::adocSnippet[]
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

// tag::adocSnippet[]
@Path("/logs/simple")
public class SimplifiedLoggingResource {

  @GET
  public void displayLogs() {
    Log.info("Trace produced by Simplified Logging API");
  }
}
// end::adocSnippet[]
