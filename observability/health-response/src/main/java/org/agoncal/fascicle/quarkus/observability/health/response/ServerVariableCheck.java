package org.agoncal.fascicle.quarkus.observability.health.response;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.HealthCheckResponseBuilder;
import org.eclipse.microprofile.health.Liveness;

import javax.enterprise.context.ApplicationScoped;

// tag::adocSnippet[]
@Liveness
@ApplicationScoped
public class ServerVariableCheck implements HealthCheck {

  @Override
  public HealthCheckResponse call() {

    HealthCheckResponseBuilder builder = HealthCheckResponse
      .named(ServerVariableCheck.class.getSimpleName() + "Liveness")
      .withData("variable", "server.name");

    if (System.getProperty("server.name") == null) {
      return builder
        .withData("server", "not available")
        .down()
        .build();
    } else {
      return builder
        .withData("server", "available")
        .up()
        .build();
    }
  }
}
// end::adocSnippet[]
