package org.agoncal.fascicle.quarkus.test.resources;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.h2.H2DatabaseTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import jakarta.transaction.Transactional;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

// tag::adocSnippet[]
@QuarkusTest
@QuarkusTestResource(H2DatabaseTestResource.class)
@Transactional
class MusicianTest {

  @Test
  void shouldPersistAMusician() {
    // ...
    // tag::adocSkip[]
    Musician musician = new Musician();
    musician.firstName = "Janis";
    musician.lastName = "Joplin";
    musician.dateOfBirth = LocalDate.of(1943, 01, 19);
    musician.preferredInstrument = "Voice";

    Musician.persist(musician);

    assertNotNull(musician.id);
    // end::adocSkip[]
  }
}
// end::adocSnippet[]
