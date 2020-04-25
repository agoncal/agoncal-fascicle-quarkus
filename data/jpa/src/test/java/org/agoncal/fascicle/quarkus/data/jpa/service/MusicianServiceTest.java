package org.agoncal.fascicle.quarkus.data.jpa.service;

import io.quarkus.test.junit.QuarkusTest;
import org.agoncal.fascicle.quarkus.data.jpa.model.Musician;
import org.agoncal.fascicle.quarkus.data.jpa.service.MusicianService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import javax.inject.Inject;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MusicianServiceTest {

  @Inject
  MusicianService musicianService;

  private static final String DEFAULT_FIRST_NAME = "First Name";
  private static final String UPDATED_FIRST_NAME = "First Name (updated)";
  private static final String DEFAULT_LAST_NAME = "Last Name";
  private static final String UPDATED_LAST_NAME = "Last Name (updated)";
  private static final String DEFAULT_BIO = "Bio";
  private static final String UPDATED_BIO = "Bio (updated)";
  private static final LocalDate DEFAULT_DATE_OF_BIRTH = LocalDate.of(1970, Month.FEBRUARY, 1);
  private static final LocalDate UPDATED_DATE_OF_BIRTH = LocalDate.of(1980, Month.APRIL, 2);
  private static final String DEFAULT_INSTRUMENT = "Instrument";
  private static final String UPDATED_INSTRUMENT = "Instrument (udpated)";

  private static int nbMusicians;
  private static long musicianId;

  @Test
  void shouldNotGetUnknownMusician() {
    Long randomId = new Random().nextLong();
    Optional<Musician> musician = musicianService.findMusicianById(randomId);
    assertFalse(musician.isPresent());
  }

  @Test
  @Order(1)
  void shouldGetInitialMusicians() {
    List<Musician> musicians = musicianService.findAllMusicians();
    assertTrue(musicians.size() > 0);
    nbMusicians = musicians.size();
  }

  @Test
  @Order(2)
  void shouldAddAnMusician() {
    // Persists an musician
    Musician musician = new Musician();
    musician.firstName = DEFAULT_FIRST_NAME;
    musician.lastName = DEFAULT_LAST_NAME;
    musician.bio = DEFAULT_BIO;
    musician.dateOfBirth = DEFAULT_DATE_OF_BIRTH;
    musician.preferredInstrument = DEFAULT_INSTRUMENT;

    assertFalse(musician.isPersistent());
    musician = musicianService.persistMusician(musician);

    // Checks the musician has been created
    assertNotNull(musicianId);
    assertEquals(DEFAULT_FIRST_NAME, musician.firstName);
    assertEquals(DEFAULT_LAST_NAME, musician.lastName);
    assertEquals(DEFAULT_BIO, musician.bio);
    assertEquals(DEFAULT_DATE_OF_BIRTH, musician.dateOfBirth);
    assertEquals(DEFAULT_INSTRUMENT, musician.preferredInstrument);

    // Checks there is an extra musician in the database
    assertEquals(nbMusicians + 1, musicianService.findAllMusicians().size());

    musicianId = musician.id;
  }

  @Test
  @Order(3)
  void shouldUpdateAnMusician() {
    Musician musician = new Musician();
    musician.id = musicianId;
    musician.firstName = UPDATED_FIRST_NAME;
    musician.lastName = UPDATED_LAST_NAME;
    musician.bio = UPDATED_BIO;
    musician.dateOfBirth = UPDATED_DATE_OF_BIRTH;
    musician.preferredInstrument = UPDATED_INSTRUMENT;

    // Updates the previously created musician
    musicianService.updateMusician(musician);

    // Checks the musician has been updated
    musician = musicianService.findMusicianById(musicianId).get();
    assertTrue(musician.isPersistent());
    assertEquals(UPDATED_FIRST_NAME, musician.firstName);
    assertEquals(UPDATED_LAST_NAME, musician.lastName);
    assertEquals(UPDATED_BIO, musician.bio);
    assertEquals(UPDATED_DATE_OF_BIRTH, musician.dateOfBirth);
    assertEquals(UPDATED_INSTRUMENT, musician.preferredInstrument);

    // Checks there is no extra musician in the database
    assertEquals(nbMusicians + 1, musicianService.findAllMusicians().size());
  }

  @Test
  @Order(4)
  void shouldRemoveAnMusician() {
    // Deletes the previously created musician
    musicianService.deleteMusician(musicianId);

    // Checks there is less a musician in the database
    assertEquals(nbMusicians, musicianService.findAllMusicians().size());
  }
}
