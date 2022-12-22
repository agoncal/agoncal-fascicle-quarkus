package org.agoncal.fascicle.quarkus.core.logging;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.jboss.logging.Logger;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

// @formatter:off
@Path("/logs")
public class LoggingResource {

  @GET
  public void displayLogs() {
    Logger LOGGER = Logger.getLogger(LoggingResource.class);
    LOGGER.info("Trace produced by JBoss Logger");

    // tag::adocConfig[]
    Config config = ConfigProvider.getConfig();

    LOGGER.info(config.getValue("quarkus.log.level", String.class));
    LOGGER.info(config.getValue("quarkus.log.min-level", String.class));
    LOGGER.info(config.getValue("quarkus.log.console.json", Boolean.class));
    LOGGER.info(config.getValue("quarkus.log.console.json.pretty-print", Boolean.class));
    // end::adocConfig[]
  }
}
