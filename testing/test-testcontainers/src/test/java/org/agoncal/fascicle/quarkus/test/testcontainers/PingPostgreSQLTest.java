package org.agoncal.fascicle.quarkus.test.testcontainers;

import org.junit.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertTrue;

// tag::adocSnippet[]
@Testcontainers
public class PingPostgreSQLTest {

  @Container
  public static PostgreSQLContainer postgreSQL = new PostgreSQLContainer<>("postgres:12.2")
    .withDatabaseName("books_database")
    .withUsername("book")
    .withPassword("book")
    .withExposedPorts(5432);

  @Test
  public void shouldPingPostgreSQL() throws Exception {
    postgreSQL.start();

    try (Connection con = DriverManager.getConnection(postgreSQL.getJdbcUrl(), postgreSQL.getUsername(), postgreSQL.getPassword());
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery("SELECT VERSION()")) {

      if (rs.next()) {
        assertTrue(rs.getString(1).contains("PostgreSQL 12"));
      } else {
        throw new Exception();
      }
    }

    postgreSQL.stop();
  }
}
// end::adocSnippet[]
