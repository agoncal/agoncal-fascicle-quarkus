package org.agoncal.fascicle.quarkus.observability.health.response;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

import javax.enterprise.context.ApplicationScoped;
import java.io.File;

// tag::adocSnippet[]
@Readiness
@ApplicationScoped
public class DiskCheck implements HealthCheck {

  @Override
  public HealthCheckResponse call() {

    File file = new File("/");
    long totalSpace = file.getTotalSpace() / 1024 / 1024;
    long freeSpace = file.getFreeSpace() / 1024 / 1024;

    return HealthCheckResponse
      .named(DiskCheck.class.getSimpleName() + "Readiness")
      .withData("totalSpace", totalSpace)
      .withData("remainingSpace", freeSpace)
      .state(freeSpace > 100)
      .build();
  }
}
// end::adocSnippet[]
