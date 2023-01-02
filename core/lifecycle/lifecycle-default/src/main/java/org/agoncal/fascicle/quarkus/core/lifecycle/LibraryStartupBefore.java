package org.agoncal.fascicle.quarkus.core.lifecycle;

// tag::adocSnippet[]
import io.quarkus.runtime.Startup;

// end::adocSnippet[]
import org.jboss.logging.Logger;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.interceptor.Interceptor;

// tag::adocSnippet[]
@Startup(Interceptor.Priority.LIBRARY_BEFORE)
@ApplicationScoped
public class LibraryStartupBefore {

  private static final Logger LOGGER = Logger.getLogger(LibraryStartupBefore.class);

  public LibraryStartupBefore() {
    LOGGER.info("LIBRARY_BEFORE");
  }
}
// end::adocSnippet[]
