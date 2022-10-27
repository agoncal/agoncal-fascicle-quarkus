package org.agoncal.fascicle.quarkus.data.jpa.dflt;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Antonio Goncalves
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

    Book book = new Book().title("H2G2");
    em.persist(book);
    assertNotNull(book.getId(), "Id should not be null");
  }
}
