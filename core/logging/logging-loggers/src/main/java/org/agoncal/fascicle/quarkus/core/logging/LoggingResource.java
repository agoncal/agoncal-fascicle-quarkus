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
    // tag::adocMultipleLoggers[]
    // JBoss Logging
    // tag::adocJBossLogger[]
    org.jboss.logging.Logger JBOSS_LOGGER =
      org.jboss.logging.Logger.getLogger(LoggingResource.class);
    // end::adocJBossLogger[]
    JBOSS_LOGGER.info("Trace produced by JBoss Logger");

    // JUL
    java.util.logging.Logger JUL_LOGGER =
      java.util.logging.Logger.getLogger(LoggingResource.class.getName());
    JUL_LOGGER.info("Trace produced by JUL");

    // Commons Logging
    org.apache.commons.logging.Log COMMONS_LOGGING =
      org.apache.commons.logging.LogFactory.getLog(LoggingResource.class);
    COMMONS_LOGGING.info("Trace produced by Commons Logging");

    // SLF4J
    org.slf4j.Logger SLF4J_LOGGER =
      org.slf4j.LoggerFactory.getLogger(LoggingResource.class);
    SLF4J_LOGGER.info("Trace produced by SLF4J");

    // Log4J
    org.apache.logging.log4j.Logger LOG4J_LOGGER =
      org.apache.logging.log4j.LogManager.getLogger();
    SLF4J_LOGGER.info("Trace produced by Log4J");
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
  }
}
