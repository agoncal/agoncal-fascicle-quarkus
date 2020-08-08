package org.agoncal.fascicle.quarkus.packaging.restpanache;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.get;
import static org.hamcrest.core.Is.is;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// @formatter:off
@QuarkusTest
public class PublisherResourceTest {

  @Test
  void shouldFindAll() {
    get("/publishers").
    then()
      .assertThat()
      .statusCode(is(200));
  }

  @Test
  void shouldFindById() {
    get("/publishers/1001").
    then()
      .assertThat()
      .statusCode(is(200))
      .and()
      .body(is("APress"));
  }

  @Test
  void shouldFindByName() {
  }

  @Test
  void shouldDeleteById() {
  }

  @Test
  void shouldDeleteByName() {
  }

  @Test
  void shouldPersist() {
  }
}
