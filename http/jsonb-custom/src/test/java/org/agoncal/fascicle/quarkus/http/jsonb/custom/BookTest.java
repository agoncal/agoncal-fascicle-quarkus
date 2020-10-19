package org.agoncal.fascicle.quarkus.http.jsonb.custom;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import java.io.IOException;
import java.time.LocalDate;

import static org.agoncal.fascicle.quarkus.http.jsonb.custom.UtilTest.jsonPath;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class BookTest {

  private static Jsonb jsonb;

  @BeforeAll
  static void init() {
    JsonbConfig config = new JsonbConfig().withFormatting(true);
    jsonb = JsonbBuilder.create(config);
  }

//  static BufferedWriter bw;
//
//  @BeforeAll
//  static void initFile() throws FileNotFoundException {
//    bw = initBufferedWriter("src/main/java/org/agoncal/fascicle/quarkus/http/jsonb/custom/Book.json");
//  }
//
//  @AfterAll
//  static void closeFile() throws IOException {
//    bw.close();
//  }

  // ======================================
  // =              Methods               =
  // ======================================

  @Test
  void shouldMarshallACustomBook() throws IOException {

    Book book = new Book().title("H2G2").price(12.5F).isbn("1-84023-742-2").nbOfPages(354).illustrations(false).description("Best Sci-fi book ever").publicationDate(LocalDate.of(1999, 04, 28));

    String json = jsonb.toJson(book);

//    output(bw, json, "shouldMarshallACustomBook");

    assertEquals("H2G2", jsonPath(json, "$.book_title"));
    assertEquals("12.50", jsonPath(json, "$.price"));
    assertEquals("1-84023-742-2", jsonPath(json, "$.isbn"));
    assertEquals(354, jsonPath(json, "$.nb_of_pages"));
    assertEquals(Boolean.FALSE, jsonPath(json, "$.illustrations"));
  }
}
