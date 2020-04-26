package org.agoncal.fascicle.quarkus.data.jpa.service;

import io.quarkus.test.junit.QuarkusTest;
import org.agoncal.fascicle.quarkus.data.jpa.model.Musician;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import javax.inject.Inject;
import java.time.LocalDate;
import java.time.Month;
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
    nbMusicians = musicianService.findAllMusicians().size();
    assertTrue(nbMusicians > 0);
  }

  @Test
  @Order(2)
  void shouldAddAnMusician() {
    // Persists an musician
    Musician musician = new Musician();
    musician.setFirstName(DEFAULT_FIRST_NAME);
    musician.setLastName(DEFAULT_LAST_NAME);
    musician.setBio(DEFAULT_BIO);
    musician.setDateOfBirth(DEFAULT_DATE_OF_BIRTH);
    musician.setPreferredInstrument(DEFAULT_INSTRUMENT);

    musician = musicianService.persistMusician(musician);

    // Checks the musician has been created
    assertNotNull(musicianId);
    assertEquals(DEFAULT_FIRST_NAME, musician.getFirstName());
    assertEquals(DEFAULT_LAST_NAME, musician.getLastName());
    assertEquals(DEFAULT_BIO, musician.getBio());
    assertEquals(DEFAULT_DATE_OF_BIRTH, musician.getDateOfBirth());
    assertEquals(DEFAULT_INSTRUMENT, musician.getPreferredInstrument());

    // Checks there is an extra musician in the database
    assertEquals(nbMusicians + 1, musicianService.findAllMusicians().size());

    musicianId = musician.getId();
  }

  @Test
  @Order(3)
  void shouldUpdateAnMusician() {
    Musician musician = new Musician();
    musician.setId(musicianId);
    musician.setFirstName(UPDATED_FIRST_NAME);
    musician.setLastName(UPDATED_LAST_NAME);
    musician.setBio(UPDATED_BIO);
    musician.setDateOfBirth(UPDATED_DATE_OF_BIRTH);
    musician.setPreferredInstrument(UPDATED_INSTRUMENT);

    // Updates the previously created musician
    musicianService.updateMusician(musician);

    // Checks the musician has been updated
    musician = musicianService.findMusicianById(musicianId).get();
    assertEquals(UPDATED_FIRST_NAME, musician.getFirstName());
    assertEquals(UPDATED_LAST_NAME, musician.getLastName());
    assertEquals(UPDATED_BIO, musician.getBio());
    assertEquals(UPDATED_DATE_OF_BIRTH, musician.getDateOfBirth());
    assertEquals(UPDATED_INSTRUMENT, musician.getPreferredInstrument());

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
