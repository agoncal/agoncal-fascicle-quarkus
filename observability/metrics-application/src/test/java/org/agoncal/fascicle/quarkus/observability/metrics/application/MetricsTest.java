package org.agoncal.fascicle.quarkus.observability.metrics.application;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static javax.ws.rs.core.HttpHeaders.ACCEPT;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.OK;

//@formatter:off
@QuarkusTest
public class MetricsTest {

  @Test
  void shouldPingMetrics() {
    given()
      .header(ACCEPT, APPLICATION_JSON).
    when()
      .get("/q/metrics").
    then()
      .statusCode(OK.getStatusCode());
  }

  @Test
  void shouldPingMetricsApplication() {
    given()
      .header(ACCEPT, APPLICATION_JSON).
    when()
      .get("/q/metrics/application").
    then()
      .statusCode(OK.getStatusCode());
  }

  @Test
  void shouldPingMetricsBase() {
    given()
      .header(ACCEPT, APPLICATION_JSON).
    when()
      .get("/q/metrics/base").
    then()
      .statusCode(OK.getStatusCode());
  }

  @Test
  void shouldPingMetricsVendor() {
    given()
      .header(ACCEPT, APPLICATION_JSON).
    when()
      .get("/q/metrics/vendor").
    then()
      .statusCode(OK.getStatusCode());
  }
}
