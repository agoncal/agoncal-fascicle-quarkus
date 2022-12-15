package org.agoncal.fascicle.quarkus.observability.health.liveready;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

import jakarta.enterprise.context.ApplicationScoped;

// tag::adocSnippet[]
@Readiness
@ApplicationScoped
public class ServerVariableCheck implements HealthCheck {

  @Override
  public HealthCheckResponse call() {
    if (System.getProperty("server.name") == null) {
      return HealthCheckResponse.named("System Variable Check").down().build();
    } else {
      return HealthCheckResponse.named("System Variable Check").up().build();
    }
  }
}
// end::adocSnippet[]
