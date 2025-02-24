package org.agoncal.fascicle.quarkus.core.lifecycle;

import io.quarkus.runtime.Startup;
import org.jboss.logging.Logger;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.interceptor.Interceptor;

@Startup(Interceptor.Priority.PLATFORM_BEFORE)
@ApplicationScoped
public class PlateformStartupBefore {

  private static final Logger logger = Logger.getLogger(PlateformStartupBefore.class);

  public PlateformStartupBefore() {
    logger.info("PLATFORM_BEFORE");
  }
}
