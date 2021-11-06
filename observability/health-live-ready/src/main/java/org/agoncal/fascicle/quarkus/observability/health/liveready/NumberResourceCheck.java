package org.agoncal.fascicle.quarkus.observability.health.liveready;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

// tag::adocSnippet[]
@Liveness
@ApplicationScoped
public class NumberResourceCheck implements HealthCheck {

  @Inject
  NumberResource numberResource;

  @Override
  public HealthCheckResponse call() {
    numberResource.generateIssn();
    return HealthCheckResponse.named("Ping Number REST Endpoint").up().build();
  }
}
// end::adocSnippet[]
