package org.agoncal.fascicle.quarkus.core.lifecycle;

import io.quarkus.runtime.Startup;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.interceptor.Interceptor;

@Startup(Interceptor.Priority.APPLICATION)
@ApplicationScoped
public class ApplicationStartupBefore {

  private static final Logger LOGGER = Logger.getLogger(ApplicationStartupBefore.class);

  public ApplicationStartupBefore() {
    LOGGER.info("APPLICATION");
  }
}
