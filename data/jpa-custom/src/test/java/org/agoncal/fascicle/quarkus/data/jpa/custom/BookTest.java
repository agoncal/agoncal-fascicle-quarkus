package org.agoncal.fascicle.quarkus.data.jpa.custom;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @book Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
@QuarkusTest
public class BookTest {

  @Inject
  EntityManager em;

  // ======================================
  // =              Methods               =
  // ======================================

  @Test
  @Transactional
  void shouldCreateABook() {

    Book book = new Book().title("H2G2").nbOfPages(123);
    em.persist(book);
    assertNotNull(book.getId(), "Id should not be null");
  }
}
