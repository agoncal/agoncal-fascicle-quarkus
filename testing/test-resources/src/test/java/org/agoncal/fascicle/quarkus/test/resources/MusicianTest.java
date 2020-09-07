package org.agoncal.fascicle.quarkus.test.resources;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.ldap.LdapServerTestResource;
import org.junit.jupiter.api.Test;

import javax.transaction.Transactional;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

// tag::adocSnippet[]
@QuarkusTest
@QuarkusTestResource(LdapServerTestResource.class)
@Transactional
class MusicianTest {

  @Test
  void shouldPersistAMusician() {
    Musician musician = new Musician();
    musician.firstName = "Janis";
    musician.lastName = "Joplin";
    musician.dateOfBirth = LocalDate.of(1943, 01, 19);
    musician.preferredInstrument = "Voice";

    Musician.persist(musician);

    assertNotNull(musician.id);
  }
}
// end::adocSnippet[]
