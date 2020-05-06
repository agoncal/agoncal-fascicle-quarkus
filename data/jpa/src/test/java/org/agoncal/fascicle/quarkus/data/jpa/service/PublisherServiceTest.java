package org.agoncal.fascicle.quarkus.data.jpa.service;

import io.quarkus.test.junit.QuarkusTest;
import org.agoncal.fascicle.quarkus.data.jpa.model.Publisher;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import javax.inject.Inject;
import java.util.Optional;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PublisherServiceTest {

  @Inject
  PublisherService publisherService;

  private static final String DEFAULT_NAME = "Name";
  private static final String UPDATED_NAME = "Name (updated)";

  private static int nbPublishers;
  private static long publisherId;

  @Test
  void shouldNotGetUnknownPublisher() {
    Long randomId = new Random().nextLong();
    Optional<Publisher> publisher = publisherService.findByIdOptional(randomId);
    assertFalse(publisher.isPresent());
  }

  @Test
  @Order(1)
  void shouldGetInitialPublishers() {
    nbPublishers = publisherService.findAll().size();
    assertTrue(nbPublishers > 0);
  }

  @Test
  @Order(2)
  void shouldAddAnPublisher() throws StatisticsException {
    // Persists a publisher
    Publisher publisher = new Publisher();
    publisher.setName(DEFAULT_NAME);
    publisher = publisherService.persist(publisher);

    // Checks the publisher has been created
    assertNotNull(publisherId);
    assertEquals(DEFAULT_NAME, publisher.getName());

    // Checks there is an extra publisher in the database
    assertEquals(nbPublishers + 1, publisherService.findAll().size());

    publisherId = publisher.getId();
  }

  @Test
  @Order(3)
  void shouldFindThePublisherByName() {
    Publisher publisher = publisherService.findByName(DEFAULT_NAME).get();

    // Checks the publisher has been created
    assertNotNull(publisherId);
    assertEquals(DEFAULT_NAME, publisher.getName());
  }

  @Test
  @Order(4)
  void shouldUpdateAPublisher() {
    Publisher publisher = new Publisher();
    publisher.setId(publisherId);
    publisher.setName(UPDATED_NAME);

    // Updates the previously created publisher
    publisherService.update(publisher);

    // Checks the publisher has been updated
    publisher = publisherService.findByIdOptional(publisherId).get();
    assertEquals(UPDATED_NAME, publisher.getName());

    // Checks there is no extra publisher in the database
    assertEquals(nbPublishers + 1, publisherService.findAll().size());
  }

  @Test
  @Order(5)
  void shouldRemoveAPublisher() {
    // Deletes the previously created publisher
    publisherService.deleteById(publisherId);

    // Checks there is less a publisher in the database
    assertEquals(nbPublishers, publisherService.findAll().size());
  }

  @Test
  @Order(6)
  public void shouldDeleteByName() {
    assertTrue(publisherService.deleteByName("Wrox Press") == 1);
    // Checks there is less a publisher in the database
    assertEquals(nbPublishers - 1, publisherService.findAll().size());
  }
}
