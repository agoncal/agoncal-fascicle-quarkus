package org.agoncal.fascicle.quarkus.understanding;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @book Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
@Disabled
public class BookTest {

  private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("cdbookstorePU");
  private static EntityManager em;
  private static EntityTransaction tx;

  @BeforeAll
  static void init() {
    em = emf.createEntityManager();
    tx = em.getTransaction();
  }

  @AfterAll
  static void close() {
    if (em != null) em.close();
  }

  // ======================================
  // =              Methods               =
  // ======================================

  @Test
  void shouldCreateABook() {

    Book book = new Book().title("H2G2");
    tx.begin();
    em.persist(book);
    tx.commit();
    assertNotNull(book.getId(), "Id should not be null");
  }
}
