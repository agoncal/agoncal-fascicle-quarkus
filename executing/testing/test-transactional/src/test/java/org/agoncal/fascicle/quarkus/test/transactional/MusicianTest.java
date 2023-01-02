package org.agoncal.fascicle.quarkus.test.transactional;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import jakarta.transaction.Transactional;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
// @formatter:off

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
// tag::adocSnippet[]
@QuarkusTest
@Transactional
class MusicianTest {
  // tag::adocSkip[]
  private static long nbBooks;

  @Test
  @Order(1)
  void shouldGetInitialMusicians() {
    nbBooks = Musician.count();
    assertTrue(nbBooks >= 0);
  }
  // end::adocSkip[]

  @Test
  // tag::adocSkip[]
  @Order(2)
  // end::adocSkip[]
  void shouldPersistAMusician() {
    Musician musician = new Musician();
    musician.firstName = "Janis";
    musician.lastName = "Joplin";
    musician.dateOfBirth = LocalDate.of(1943, 01, 19);
    musician.preferredInstrument = "Voice";

    Musician.persist(musician);

    assertNotNull(musician.id);
  }
  // tag::adocSkip[]
  @Test
  @Order(3)
  void shouldGetMusiciansAfterPersist() {
    assertEquals(nbBooks + 1, Musician.count());
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
