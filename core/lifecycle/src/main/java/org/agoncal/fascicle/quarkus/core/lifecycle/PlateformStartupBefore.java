package org.agoncal.fascicle.quarkus.core.lifecycle;

import io.quarkus.runtime.Startup;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.interceptor.Interceptor;

@Startup(Interceptor.Priority.PLATFORM_BEFORE)
@ApplicationScoped
public class PlateformStartupBefore {

  private static final Logger LOGGER = Logger.getLogger(PlateformStartupBefore.class);

  public PlateformStartupBefore() {
    LOGGER.info("PLATFORM_BEFORE");
  }
}
