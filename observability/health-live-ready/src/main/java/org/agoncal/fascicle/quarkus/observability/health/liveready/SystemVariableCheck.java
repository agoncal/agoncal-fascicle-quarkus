package org.agoncal.fascicle.quarkus.observability.health.liveready;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

import javax.enterprise.context.ApplicationScoped;

// tag::adocSnippet[]
@Readiness
@ApplicationScoped
public class SystemVariableCheck implements HealthCheck {

  @Override
  public HealthCheckResponse call() {
    if (System.getProperty("server.name") == null) {
      return HealthCheckResponse
        .named(SystemVariableCheck.class.getSimpleName() + "Readiness")
        .withData("server", "not available")
        .down()
        .build();
    }
    return HealthCheckResponse
      .named(SystemVariableCheck.class.getSimpleName() + "Readiness")
      .withData("default server", "available")
      .up()
      .build();
  }
}
// end::adocSnippet[]
