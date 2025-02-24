package org.agoncal.fascicle.quarkus.core.lifecycle;

import io.quarkus.runtime.Startup;
import org.jboss.logging.Logger;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.interceptor.Interceptor;

@Startup(Interceptor.Priority.LIBRARY_BEFORE + 10)
@ApplicationScoped
public class MyLibraryStartupBefore {

  private static final Logger logger = Logger.getLogger(MyLibraryStartupBefore.class);

  public MyLibraryStartupBefore() {
    logger.info("MY LIBRARY_BEFORE");
  }
}
