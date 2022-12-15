package org.agoncal.fascicle.quarkus.http.openapi.advanced;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import static io.restassured.RestAssured.given;
import static jakarta.ws.rs.core.HttpHeaders.ACCEPT;
import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;
import static jakarta.ws.rs.core.Response.Status.OK;
import static org.hamcrest.CoreMatchers.is;

//@formatter:off
@QuarkusTest
public class BookResourceTest {

  @Test
  public void shouldSayPing() {
    given()
      .when().get("/api/books/ping")
      .then()
      .statusCode(OK.getStatusCode())
      .body(is("ping"));
  }

  @Test
  void shouldPingOpenAPI() {
    given()
      .header(ACCEPT, APPLICATION_JSON).
    when()
      .get("/q/openapi").
    then()
      .statusCode(OK.getStatusCode());
  }

  @Test
  void shouldPingSwaggerUI() {
    given().
    when()
      .get("/q/swagger-ui").
    then()
      .statusCode(OK.getStatusCode());
  }

  @Test @Disabled("The test works, it is just deactivated because it takes time")
  void shouldWriteOpenAPIFile()throws Exception {
    String yamlFile = given()
      .header(ACCEPT, "application/yaml").
        when()
      .get("/q/openapi").
        then()
      .statusCode(OK.getStatusCode())
      .extract().asString();

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("open-dummy.yaml"))));
    yamlFile = yamlFile.substring(yamlFile.indexOf('\n')+1);
    bw.write(yamlFile);
    bw.close();
  }
}
