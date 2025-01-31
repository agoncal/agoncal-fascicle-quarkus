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
    Logger logger = Logger.getLogger(LoggingResource.class);
    logger.info("Trace produced by JBoss Logger");

    // tag::adocConfig[]
    Config config = ConfigProvider.getConfig();

    logger.info(config.getValue("quarkus.log.level", String.class));
    logger.info(config.getValue("quarkus.log.min-level", String.class));
    logger.info(config.getValue("quarkus.log.console.json", Boolean.class));
    logger.info(config.getValue("quarkus.log.console.json.pretty-print", Boolean.class));
    // end::adocConfig[]
  }
}
