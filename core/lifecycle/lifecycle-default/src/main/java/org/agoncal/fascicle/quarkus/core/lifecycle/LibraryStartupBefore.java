package org.agoncal.fascicle.quarkus.core.lifecycle;

import org.jboss.logging.Logger;
import jakarta.enterprise.context.ApplicationScoped;

// tag::adocSnippet[]
import io.quarkus.runtime.Startup;
import jakarta.interceptor.Interceptor;

@Startup(Interceptor.Priority.LIBRARY_BEFORE)
@ApplicationScoped
public class LibraryStartupBefore {

  private static final Logger logger = Logger.getLogger(LibraryStartupBefore.class);

  public LibraryStartupBefore() {
    logger.info("LIBRARY_BEFORE");
  }
}
// end::adocSnippet[]
