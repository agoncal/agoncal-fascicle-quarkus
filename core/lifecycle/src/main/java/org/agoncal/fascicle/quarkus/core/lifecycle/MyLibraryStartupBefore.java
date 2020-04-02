package org.agoncal.fascicle.quarkus.core.lifecycle;

import io.quarkus.runtime.Startup;
import org.jboss.logging.Logger;

import javax.annotation.Priority;
import javax.enterprise.context.ApplicationScoped;
import javax.interceptor.Interceptor;

@Startup(Interceptor.Priority.LIBRARY_BEFORE + 10)
@ApplicationScoped
public class MyLibraryStartupBefore {

  private static final Logger LOGGER = Logger.getLogger(MyLibraryStartupBefore.class);

  public MyLibraryStartupBefore() {
    LOGGER.info("MY LIBRARY_BEFORE");
  }
}
