package org.agoncal.fascicle.quarkus.puttingtogether.catalog.health;

import org.agoncal.fascicle.quarkus.puttingtogether.catalog.BookResource;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@Liveness
@ApplicationScoped
public class PingBookResourceHealthCheck implements HealthCheck {

    @Inject
    BookResource villainResource;

    @Override
    public HealthCheckResponse call() {
        villainResource.findAll();
        return HealthCheckResponse.named("Ping Villain REST Endpoint").up().build();
    }
}
