package org.agoncal.fascicle.quarkus.core.cdi.qualifiers;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import jakarta.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
@QuarkusTest
public class LegacyBookServiceTest {

  @Inject
  LegacyBookService legacyBookService;

  // ======================================
  // =              Methods               =
  // ======================================

  @Test
  public void shouldCheckNumberIsEightDigits() {
    Book book = legacyBookService.createBook("H2G2", 12.5f, "Geeky scifi Book");
    assertTrue(book.getIsbn().startsWith("8"));
  }
}
