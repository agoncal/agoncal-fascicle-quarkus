package org.agoncal.fascicle.quarkus.core.lifecycle;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import org.jboss.logging.Logger;

import javax.enterprise.event.Observes;

// tag::adocSnippet[]
public class AppLifecycleBean {

  private static final Logger LOGGER = Logger.getLogger(AppLifecycleBean.class);

  void onStart(@Observes StartupEvent ev) {
    LOGGER.info("The application is starting...");
  }

  void onStop(@Observes ShutdownEvent ev) {
    LOGGER.info("The application is stopping...");
  }
}
// end::adocSnippet[]
