package org.agoncal.fascicle.quarkus.data.jpa.service;

import io.quarkus.test.junit.QuarkusTest;
import org.agoncal.fascicle.quarkus.data.jpa.model.CD;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import javax.inject.Inject;
import java.util.List;
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
    Optional<CD> cd = cdService.findCDById(randomId);
    assertFalse(cd.isPresent());
  }

  @Test
  @Order(1)
  void shouldGetInitialCDs() {
    List<CD> cds = cdService.findAllCDs();
    assertTrue(cds.size() > 0);
    nbCDs = cds.size();
  }

  @Test
  @Order(2)
  void shouldAddAnCD() {
    // Persists a cd
    CD cd = new CD();
    cd.setTitle( DEFAULT_TITLE);
    cd.setDescription( DEFAULT_DESCRIPTION);
    cd.setUnitCost( DEFAULT_UNIT_COST);
    cd.setTotalDuration( DEFAULT_TOTAL_DURATION);
    cd.setMusicCompany( DEFAULT_MUSIC_COMPANY);
    cd.setGenre( DEFAULT_GENRE);

    cd = cdService.persistCD(cd);

    // Checks the cd has been created
    assertNotNull(cdId);
    assertEquals(DEFAULT_TITLE, cd.getTitle());
    assertEquals(DEFAULT_DESCRIPTION, cd.getDescription());
    assertEquals(DEFAULT_UNIT_COST, cd.getUnitCost());
    assertEquals(DEFAULT_TOTAL_DURATION, cd.getTotalDuration());
    assertEquals(DEFAULT_MUSIC_COMPANY, cd.getMusicCompany());
    assertEquals(DEFAULT_GENRE, cd.getGenre());

    // Checks there is an extra cd in the database
    assertEquals(nbCDs + 1, cdService.findAllCDs().size());

    cdId = cd.getId();
  }

  @Test
  @Order(3)
  void shouldUpdateAnCD() {
    CD cd = new CD();
    cd.setId( cdId);
    cd.setTitle( UPDATED_TITLE);
    cd.setDescription( UPDATED_DESCRIPTION);
    cd.setUnitCost( UPDATED_UNIT_COST);
    cd.setTotalDuration( UPDATED_TOTAL_DURATION);
    cd.setMusicCompany( UPDATED_MUSIC_COMPANY);
    cd.setGenre( UPDATED_GENRE);

    // Updates the previously created cd
    cdService.updateCD(cd);

    // Checks the cd has been updated
    cd = cdService.findCDById(cdId).get();
    assertEquals(UPDATED_TITLE, cd.getTitle());
    assertEquals(UPDATED_DESCRIPTION, cd.getDescription());
    assertEquals(UPDATED_UNIT_COST, cd.getUnitCost());
    assertEquals(UPDATED_TOTAL_DURATION, cd.getTotalDuration());
    assertEquals(UPDATED_MUSIC_COMPANY, cd.getMusicCompany());
    assertEquals(UPDATED_GENRE, cd.getGenre());

    // Checks there is no extra cd in the database
    assertEquals(nbCDs + 1, cdService.findAllCDs().size());
  }

  @Test
  @Order(4)
  void shouldRemoveAnCD() {
    // Deletes the previously created cd
    cdService.deleteCD(cdId);

    // Checks there is less a cd in the database
    assertEquals(nbCDs, cdService.findAllCDs().size());
  }

  @Test
  void shouldFindGenre() {
    assertEquals(1, cdService.findLikeGenre("Jazz").size());
    assertEquals(4, cdService.findLikeGenre("Pop").size());
    assertEquals(3, cdService.findLikeGenre("Pop Rock").size());
  }
}
