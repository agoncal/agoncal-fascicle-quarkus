package org.agoncal.fascicle.quarkus.core.logging;

import org.jboss.logging.Logger;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/logs/inject")
public class InjectedLoggingResource {

  // tag::adocSnippet[]
  @Inject
  Logger logger;

  @GET
  public void displayLogs() {
    logger.info("Trace produced by JBoss Logger");
  }
  // end::adocSnippet[]
}
