package org.agoncal.fascicle.quarkus.observability.health.liveready;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

import javax.enterprise.context.ApplicationScoped;
import java.io.File;

// tag::adocSnippet[]
@Liveness
@ApplicationScoped
public class DiskCheck implements HealthCheck {

  @Override
  public HealthCheckResponse call() {

    File file = new File("/");
    long freeSpace = file.getFreeSpace() / 1024 / 1024;

    return HealthCheckResponse
      .named(DiskCheck.class.getSimpleName() + "Liveness")
      .withData("remainingSpace", freeSpace)
      .state(freeSpace > 100)
      .build();
  }
}
// end::adocSnippet[]
