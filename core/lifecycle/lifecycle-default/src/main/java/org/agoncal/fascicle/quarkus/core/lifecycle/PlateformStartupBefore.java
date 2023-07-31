package org.agoncal.fascicle.quarkus.core.lifecycle;

import io.quarkus.runtime.Startup;
import org.jboss.logging.Logger;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.interceptor.Interceptor;

@Startup(Interceptor.Priority.PLATFORM_BEFORE)
@ApplicationScoped
public class PlateformStartupBefore {

  private static final Logger LOGGER = Logger.getLogger(PlateformStartupBefore.class);

  @PostConstruct
  void init() {
    LOGGER.info("PLATFORM_BEFORE");
  }

}
