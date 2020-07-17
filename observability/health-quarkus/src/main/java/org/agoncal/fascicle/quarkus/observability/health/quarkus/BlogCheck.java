package org.agoncal.fascicle.quarkus.observability.health.quarkus;

import io.smallrye.health.checks.UrlHealthCheck;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.Liveness;

import javax.enterprise.context.ApplicationScoped;

// tag::adocSnippet[]
@ApplicationScoped
public class BlogCheck {

  @Liveness
  HealthCheck checkURL() {
    return new UrlHealthCheck("https://antoniogoncalves.org").name("Blog Check");
  }
}
// end::adocSnippet[]
