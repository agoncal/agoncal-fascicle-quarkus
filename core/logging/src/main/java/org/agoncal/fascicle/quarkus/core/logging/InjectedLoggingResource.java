package org.agoncal.fascicle.quarkus.core.logging;

import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/logs/inject")
public class InjectedLoggingResource {

  // tag::adocSnippet[]
  @Inject
  Logger JBOSS_LOGGER;

  @GET
  public void displayLogs() {
    JBOSS_LOGGER.info("Trace produced by JBoss Logger");
  }
  // end::adocSnippet[]
}
