package org.agoncal.fascicle.quarkus.test.testcontainers;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertTrue;

// tag::adocSnippet[]
@QuarkusTest
@Testcontainers
public class PingPostgreSQLTest {

  @Container
  public static PostgreSQLContainer pg = new PostgreSQLContainer<>("postgres:14.0")
    .withDatabaseName("vintageStoreDB")
    .withUsername("vintage")
    .withPassword("vintage")
    .withExposedPorts(5432);

  @Test
  public void shouldPingPostgreSQL() throws Exception {
    pg.start();

    try (Connection con = DriverManager.getConnection(pg.getJdbcUrl(), pg.getUsername(), pg.getPassword());
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery("SELECT VERSION()")) {

      if (rs.next()) {
        assertTrue(rs.getString(1).contains("PostgreSQL 14"));
      } else {
        throw new Exception();
      }
    }

    pg.stop();
  }
}
// end::adocSnippet[]
