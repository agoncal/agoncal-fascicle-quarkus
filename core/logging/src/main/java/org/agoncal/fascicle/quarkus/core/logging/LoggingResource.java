package org.agoncal.fascicle.quarkus.core.logging;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.jboss.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

// @formatter:off
@Path("/logs")
public class LoggingResource {

  @GET
  public void displayLogs() {
    // tag::adocMultipleLoggers[]
    // tag::adocJBossLogger[]
    org.jboss.logging.Logger JBOSS_LOGGER =
      org.jboss.logging.Logger.getLogger(LoggingResource.class);
    // end::adocJBossLogger[]
    java.util.logging.Logger JUL_LOGGER =
      java.util.logging.Logger.getLogger(LoggingResource.class.getName());
    org.apache.commons.logging.Log COMMONS_LOGGING =
      org.apache.commons.logging.LogFactory.getLog(LoggingResource.class);
    org.slf4j.Logger SLF4J_LOGGER =
      org.slf4j.LoggerFactory.getLogger(LoggingResource.class);

    JBOSS_LOGGER.info("Trace produced by JBoss Logger");
    JUL_LOGGER.info("Trace produced by JUL");
    COMMONS_LOGGING.info("Trace produced by Commons Logging");
    SLF4J_LOGGER.info("Trace produced by SLF4J");
    // end::adocMultipleLoggers[]

    System.out.println("###########################################");

    Exception exception = new Exception();
    // tag::adocLevels[]
    Logger LOGGER = Logger.getLogger(LoggingResource.class);

    LOGGER.fatal("Fatal", exception);
    LOGGER.error("Error");
    LOGGER.warn("Warning");
    LOGGER.info("Information");
    LOGGER.debug("Debug");
    LOGGER.trace("Trace");
    // end::adocLevels[]

    System.out.println("###########################################");

    // tag::adocConfig[]
    Config config = ConfigProvider.getConfig();

    LOGGER.info(config.getValue("quarkus.log.level", String.class));
    LOGGER.info(config.getValue("quarkus.log.min-level", String.class));
    LOGGER.info(config.getValue("quarkus.log.console.json", Boolean.class));
    LOGGER.info(config.getValue("quarkus.log.console.json.pretty-print", Boolean.class));
    // end::adocConfig[]
  }
}
