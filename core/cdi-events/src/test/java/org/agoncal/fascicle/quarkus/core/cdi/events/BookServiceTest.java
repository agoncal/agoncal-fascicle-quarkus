package org.agoncal.fascicle.quarkus.core.cdi.events;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
@QuarkusTest
public class BookServiceTest {

  @Inject
  BookService bookService;

  @Inject
  InventoryService inventoryService;

  @Test
  public void shouldCheckEvents() {
    assertEquals(0, inventoryService.inventory.size());
    Book book = bookService.createBook("H2G2", 12.5f, "Geeky scifi Book");
    assertTrue(book.getIsbn().startsWith("8"));
    assertEquals(1, inventoryService.inventory.size());
  }
}
