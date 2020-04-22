package org.agoncal.fascicle.quarkus.number;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

// tag::adocSnippet[]
@Liveness
@ApplicationScoped
public class NumberResourceHealthCheck implements HealthCheck {

  @Inject
  NumberResource numberResource;

  @Override
  public HealthCheckResponse call() {
    numberResource.generateIsbnNumbers();
    return HealthCheckResponse.named("Ping Number REST Endpoint").up().build();
  }
}
// end::adocSnippet[]
