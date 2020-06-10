package org.agoncal.fascicle.quarkus.core.cdi.alternatives;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
@QuarkusTest
public class BookServiceTest {

  @Inject
  BookService bookService;

  // ======================================
  // =              Methods               =
  // ======================================

  @Test
  public void shouldCheckNumberIsMock() {
    Book book = bookService.createBook("H2G2", 12.5f, "Geeky scifi Book");
    assertEquals("MOCK", book.getIsbn());
  }
}
