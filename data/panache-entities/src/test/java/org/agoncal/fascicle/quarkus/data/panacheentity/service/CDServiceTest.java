package org.agoncal.fascicle.quarkus.data.panacheentity.service;

import io.quarkus.test.junit.QuarkusTest;
import org.agoncal.fascicle.quarkus.data.panacheentity.model.CD;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import jakarta.inject.Inject;
import java.util.Optional;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CDServiceTest {

  @Inject
  CDService cdService;

  private static final String DEFAULT_TITLE = "Title";
  private static final String UPDATED_TITLE = "Title (updated)";
  private static final String DEFAULT_DESCRIPTION = "Description";
  private static final String UPDATED_DESCRIPTION = "Description (updated)";
  private static final Float DEFAULT_UNIT_COST = 1f;
  private static final Float UPDATED_UNIT_COST = 2f;
  private static final Float DEFAULT_TOTAL_DURATION = 1f;
  private static final Float UPDATED_TOTAL_DURATION = 2f;
  private static final String DEFAULT_MUSIC_COMPANY = "Music company";
  private static final String UPDATED_MUSIC_COMPANY = "Music company (updated)";
  private static final String DEFAULT_GENRE = "Genre";
  private static final String UPDATED_GENRE = "Genre (updated)";

  private static int nbCDs;
  private static long cdId;

  @Test
  void shouldNotGetUnknownCD() {
    Long randomId = new Random().nextLong();
    Optional<CD> cd = cdService.findByIdOptional(randomId);
    assertFalse(cd.isPresent());
  }

  @Test
  @Order(1)
  void shouldGetInitialCDs() {
    nbCDs = cdService.findAll().size();
    assertTrue(nbCDs > 0);
  }

  @Test
  @Order(2)
  void shouldAddAnCD() {
    // Persists a cd
    CD cd = new CD();
    cd.title = DEFAULT_TITLE;
    cd.description = DEFAULT_DESCRIPTION;
    cd.unitCost = DEFAULT_UNIT_COST;
    cd.totalDuration = DEFAULT_TOTAL_DURATION;
    cd.musicCompany = DEFAULT_MUSIC_COMPANY;
    cd.genre = DEFAULT_GENRE;

    assertFalse(cd.isPersistent());
    cd = cdService.persist(cd);

    // Checks the cd has been created
    assertNotNull(cdId);
    assertEquals(DEFAULT_TITLE, cd.title);
    assertEquals(DEFAULT_DESCRIPTION, cd.description);
    assertEquals(DEFAULT_UNIT_COST, cd.unitCost);
    assertEquals(DEFAULT_TOTAL_DURATION, cd.totalDuration);
    assertEquals(DEFAULT_MUSIC_COMPANY, cd.musicCompany);
    assertEquals(DEFAULT_GENRE, cd.genre);

    // Checks there is an extra cd in the database
    assertEquals(nbCDs + 1, cdService.findAll().size());

    cdId = cd.id;
  }

  @Test
  @Order(3)
  void shouldUpdateAnCD() {
    CD cd = new CD();
    cd.id = cdId;
    cd.title = UPDATED_TITLE;
    cd.description = UPDATED_DESCRIPTION;
    cd.unitCost = UPDATED_UNIT_COST;
    cd.totalDuration = UPDATED_TOTAL_DURATION;
    cd.musicCompany = UPDATED_MUSIC_COMPANY;
    cd.genre = UPDATED_GENRE;

    // Updates the previously created cd
    cdService.update(cd);

    // Checks the cd has been updated
    cd = cdService.findByIdOptional(cdId).get();
    assertTrue(cd.isPersistent());
    assertEquals(UPDATED_TITLE, cd.title);
    assertEquals(UPDATED_DESCRIPTION, cd.description);
    assertEquals(UPDATED_UNIT_COST, cd.unitCost);
    assertEquals(UPDATED_TOTAL_DURATION, cd.totalDuration);
    assertEquals(UPDATED_MUSIC_COMPANY, cd.musicCompany);
    assertEquals(UPDATED_GENRE, cd.genre);

    // Checks there is no extra cd in the database
    assertEquals(nbCDs + 1, cdService.findAll().size());
  }

  @Test
  @Order(4)
  void shouldRemoveAnCD() {
    // Deletes the previously created cd
    cdService.deleteById(cdId);

    // Checks there is less a cd in the database
    assertEquals(nbCDs, cdService.findAll().size());
  }

  @Test
  void shouldFindGenre() {
    assertEquals(1, cdService.findLikeGenre("Ja").size());
    assertEquals(1, cdService.findLikeGenre("zz").size());
    assertEquals(1, cdService.findLikeGenre("Jazz").size());
    assertEquals(4, cdService.findLikeGenre("Pop").size());
    assertEquals(3, cdService.findLikeGenre("Pop Rock").size());
  }
}
