package org.agoncal.fascicle.quarkus.core.configuration.quarkus;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.jboss.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/config/quarkus")
public class ConfigurationResource {

  private static final Logger LOGGER = Logger.getLogger(ConfigurationResource.class);

  @GET
  public void displayConfiguration() {
    Config config = ConfigProvider.getConfig();
    LOGGER.info("quarkus.application.name: " + config.getValue("quarkus.application.name", String.class));
    LOGGER.info("quarkus.application.version: " + config.getValue("quarkus.application.version", String.class));
    LOGGER.info("quarkus.banner.enabled: " + config.getValue("quarkus.banner.enabled", Boolean.class));
    LOGGER.info("quarkus.default-locale: " + config.getValue("quarkus.default-locale", String.class));
    LOGGER.info("quarkus.http.port: " + config.getValue("quarkus.http.port", String.class));
    LOGGER.info("quarkus.http.test-port: " + config.getValue("quarkus.http.test-port", String.class));
    LOGGER.info("quarkus.http.ssl.protocols: " + config.getValue("quarkus.http.ssl.protocols", String.class));
    LOGGER.info("quarkus.http.read-timeout: " + config.getValue("quarkus.http.read-timeout", String.class));
    LOGGER.info("quarkus.log.level: " + config.getValue("quarkus.log.level", String.class));
    LOGGER.info("quarkus.log.min-level: " + config.getValue("quarkus.log.min-level", String.class));
    // LOGGER.info("quarkus.banner.path: " + config.getValue("quarkus.banner.path", String.class));
    // LOGGER.info("quarkus.log.level: " + config.getValue("quarkus.log.level", String.class));
    // LOGGER.info("quarkus.servlet.default-charset: " + config.getValue("quarkus.servlet.default-charset", String.class));
    // LOGGER.info("quarkus.servlet.context-path: " + config.getValue("quarkus.servlet.context-path", String.class));
    // LOGGER.info("quarkus.package.output-name: " + config.getValue("quarkus.package.output-name", String.class));
    // LOGGER.info("quarkus.package.main-class: " + config.getValue("quarkus.package.main-class", String.class));
    // LOGGER.info("quarkus.package.type: " + config.getValue("quarkus.package.type", String.class));
    // LOGGER.info("quarkus.native.java-home: " + config.getValue("quarkus.native.java-home", String.class));
    // LOGGER.info("quarkus.live-reload.url: " + config.getValue("quarkus.live-reload.url", String.class));
  }

  @Path("/test")
  @GET
  public void displayConfigurationInTest() {
    // tag::adocSnippet[]
    Config config = ConfigProvider.getConfig();

    LOGGER.info(config.getValue("quarkus.banner.enabled", Boolean.class));
    LOGGER.info(config.getValue("quarkus.default-locale", String.class));
    LOGGER.info(config.getValue("quarkus.http.port", String.class));
    LOGGER.info(config.getValue("quarkus.http.test-port", String.class));
    LOGGER.info(config.getValue("quarkus.http.ssl.protocols", String.class));
    LOGGER.info(config.getValue("quarkus.http.read-timeout", String.class));
    LOGGER.info(config.getValue("quarkus.log.level", String.class));
    LOGGER.info(config.getValue("quarkus.log.min-level", String.class));
    // end::adocSnippet[]
  }
}
