package org.agoncal.fascicle.quarkus.http.openapi.dflt;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import static io.restassured.RestAssured.given;
import static javax.ws.rs.core.HttpHeaders.ACCEPT;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.OK;
import static org.hamcrest.CoreMatchers.is;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// @formatter:off
@QuarkusTest
public class AuthorResourceTest {

  @Test
  public void shouldGetAnAuthor() {
    given()
      .pathParam("index", 0).
    when()
      .get("/authors/{index}").
    then()
      .statusCode(OK.getStatusCode())
      .body(is("Isaac Asimov"));
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

  @Test @Disabled
  void shouldWriteOpenAPIFile()throws Exception {
    String yamlFile = given()
      .header(ACCEPT, "application/yaml").
        when()
      .get("/q/openapi").
        then()
      .statusCode(OK.getStatusCode())
      .extract().asString();

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("openapi.yaml"))));
    yamlFile = yamlFile.substring(yamlFile.indexOf('\n')+1);
    bw.write(yamlFile);
    bw.close();
  }
}
