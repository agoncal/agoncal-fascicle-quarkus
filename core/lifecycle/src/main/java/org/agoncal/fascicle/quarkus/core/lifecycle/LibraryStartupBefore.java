package org.agoncal.fascicle.quarkus.core.lifecycle;

import io.quarkus.runtime.Startup;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.interceptor.Interceptor;

@Startup(Interceptor.Priority.LIBRARY_BEFORE)
@ApplicationScoped
public class LibraryStartupBefore {

  private static final Logger LOGGER = Logger.getLogger(LibraryStartupBefore.class);

  public LibraryStartupBefore() {
    LOGGER.info("LIBRARY_BEFORE");
  }
}
