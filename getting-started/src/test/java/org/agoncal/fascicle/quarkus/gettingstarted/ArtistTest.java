package org.agoncal.fascicle.quarkus.gettingstarted;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocBegin[]
@Disabled
public class ArtistTest {

  private static EntityManagerFactory emf;
  private static EntityManager em;
  private static EntityTransaction tx;

  @BeforeAll
  static void init() {
    emf = Persistence.createEntityManagerFactory("cdbookstorePU");
    em = emf.createEntityManager();
    tx = em.getTransaction();
  }

  @AfterAll
  static void close() {
    if (em != null) em.close();
    if (emf != null) emf.close();
  }
  // end::adocBegin[]

  // ======================================
  // =              Methods               =
  // ======================================

  @Test
  void shouldManageAnArtist() {

    // tag::shouldManageAnArtist[]
    Artist artist = new Artist().firstName("Adams").lastName("Douglas");
    assertNull(artist.getId(), "Id should be null");

    tx.begin();
    em.persist(artist);
    tx.commit();
    assertNotNull(artist.getId(), "Id should not be null");

    assertNotNull(em.find(Artist.class, artist.getId()), "Artist should have been persisted in DB");

    tx.begin();
    em.remove(artist);
    tx.commit();

    assertNull(em.find(Artist.class, artist.getId()), "Artist should have been removed from DB");
    // end::shouldManageAnArtist[]
  }

  @Test
  void shouldQueryArtists() {

    // tag::shouldQueryArtists[]
    assertEquals(0, em.createQuery("select a from Artist a").getResultList().size());

    Artist douglas = new Artist().firstName("Adams").lastName("Douglas");
    Artist lovecraft = new Artist().firstName("Howard").lastName("Lovecraft");
    tx.begin();
    em.persist(douglas);
    em.persist(lovecraft);
    tx.commit();

    assertEquals(2, em.createQuery("select a from Artist a").getResultList().size());
    assertEquals(1, em.createQuery("select a from Artist a where a.firstName = 'Adams' ").getResultList().size());
    // end::shouldQueryArtists[]
  }

  @Test
  void shouldNotCreateAnArtistWithNullFirstname() {

    // tag::shouldNotCreateAnArtistWithNullFirstname[]
    Artist artist = new Artist().firstName(null);
    tx.begin();
    em.persist(artist);
    assertThrows(RollbackException.class, () -> tx.commit());
    // end::shouldNotCreateAnArtistWithNullFirstname[]
  }
}
