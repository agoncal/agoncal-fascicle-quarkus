package org.agoncal.fascicle.quarkus.observability.health.liveready;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;
import org.eclipse.microprofile.health.Startup;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

// tag::adocSnippet[]
@Startup
@Liveness
@ApplicationScoped
public class NumberResourceCheck implements HealthCheck {

  @Inject
  NumberResource numberResource;

  @Override
  public HealthCheckResponse call() {
    numberResource.generateRandom();
    return HealthCheckResponse.named("Invoke Number REST Endpoint").up().build();
  }
}
// end::adocSnippet[]
