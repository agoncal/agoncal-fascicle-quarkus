package org.agoncal.fascicle.quarkus.observability.health.liveready;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Startup;

// tag::adocSnippet[]
@Startup
@ApplicationScoped
public class InjectionCheck implements HealthCheck {

  @Inject
  NumberResource numberResource;

  @Override
  public HealthCheckResponse call() {
    if (numberResource == null) {
      return HealthCheckResponse.named("Injecting Number Resource").down().build();
    } else {
      return HealthCheckResponse.named("Injecting Number Resource").up().build();
    }
  }
}
// end::adocSnippet[]
