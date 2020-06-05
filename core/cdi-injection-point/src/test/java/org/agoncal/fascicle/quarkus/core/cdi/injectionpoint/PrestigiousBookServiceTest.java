package org.agoncal.fascicle.quarkus.core.cdi.injectionpoint;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
@QuarkusTest
public class PrestigiousBookServiceTest {

  @Inject
  PrestigiousBookService bookService;

  // ======================================
  // =              Methods               =
  // ======================================

  @Test
  public void shouldCheckNumberIsThirteenDigits() {
    Book book = bookService.createBook("H2G2", 12.5f, "Geeky scifi Book");
    assertTrue(book.getIsbn().startsWith("13"));
  }
}
