package org.agoncal.fascicle.quarkus.core.lifecycle;

import io.quarkus.runtime.Startup;
import org.jboss.logging.Logger;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.interceptor.Interceptor;

@Startup(Interceptor.Priority.LIBRARY_BEFORE + 10)
@ApplicationScoped
public class MyLibraryStartupBefore {

  private static final Logger LOGGER = Logger.getLogger(MyLibraryStartupBefore.class);

  @PostConstruct
  void init() {
    LOGGER.info("MY LIBRARY_BEFORE");
  }

}
