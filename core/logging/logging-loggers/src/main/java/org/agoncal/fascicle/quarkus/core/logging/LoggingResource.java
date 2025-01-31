package org.agoncal.fascicle.quarkus.core.logging;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.jboss.logging.Logger;

// @formatter:off
@Path("/logs")
public class LoggingResource {

  @GET
  public void displayLogs() {
    // tag::adocMultipleLoggers[]
    // JBoss Logging
    // tag::adocJBossLogger[]
    org.jboss.logging.Logger jbossLogger =
      org.jboss.logging.Logger.getLogger(LoggingResource.class);
    // end::adocJBossLogger[]
    jbossLogger.info("Trace produced by JBoss Logger");

    // JUL
    java.util.logging.Logger julLogger =
      java.util.logging.Logger.getLogger(LoggingResource.class.getName());
    julLogger.info("Trace produced by JUL");

    // Commons Logging
    org.apache.commons.logging.Log commonsLogging =
      org.apache.commons.logging.LogFactory.getLog(LoggingResource.class);
    commonsLogging.info("Trace produced by Commons Logging");

    // SLF4J
    org.slf4j.Logger slf4JLogger =
      org.slf4j.LoggerFactory.getLogger(LoggingResource.class);
    slf4JLogger.info("Trace produced by SLF4J");

    // Log4J
    org.apache.logging.log4j.Logger log4JLogger =
      org.apache.logging.log4j.LogManager.getLogger();
    log4JLogger.info("Trace produced by Log4J");
    // end::adocMultipleLoggers[]

    System.out.println("###########################################");

    Exception exception = new Exception();
    // tag::adocLevels[]
    Logger logger = Logger.getLogger(LoggingResource.class);

    logger.fatal("Fatal", exception);
    logger.error("Error");
    logger.warn("Warning");
    logger.info("Information");
    logger.debug("Debug");
    logger.trace("Trace");
    // end::adocLevels[]
  }
}
