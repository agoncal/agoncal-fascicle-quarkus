package org.agoncal.fascicle.quarkus.data.panache.service;

import io.quarkus.test.junit.QuarkusTest;
import org.agoncal.fascicle.quarkus.data.panache.model.Publisher;
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
    Optional<Publisher> publisher = publisherService.findPublisherById(randomId);
    assertFalse(publisher.isPresent());
  }

  @Test
  @Order(1)
  void shouldGetInitialPublishers() {
    List<Publisher> publishers = publisherService.findAllPublishers();
    assertTrue(publishers.size() > 0);
    nbPublishers = publishers.size();
  }

  @Test
  @Order(2)
  void shouldAddAnPublisher() {
    Publisher publisher = new Publisher();
    publisher.name = DEFAULT_NAME;
    publisher = publisherService.persistPublisher(publisher);

    // Checks the publisher has been created
    assertNotNull(publisherId);
    assertEquals(DEFAULT_NAME, publisher.name);

    // Checks there is an extra publisher in the database
    assertEquals(nbPublishers + 1, publisherService.findAllPublishers().size());

    publisherId = publisher.id;
  }

  @Test
  @Order(3)
  void shouldUpdateAnPublisher() {
    Publisher publisher = new Publisher();
    publisher.id = publisherId;
    publisher.name = UPDATED_NAME;

    // Updates the previously created publisher
    publisherService.updatePublisher(publisher);

    // Checks the publisher has been updated
    publisher = publisherService.findPublisherById(publisherId).get();
    assertEquals(UPDATED_NAME, publisher.name);

    // Checks there is no extra publisher in the database
    assertEquals(nbPublishers + 1, publisherService.findAllPublishers().size());
  }

  @Test
  @Order(4)
  void shouldRemoveAnPublisher() {
    // Deletes the previously created publisher
    publisherService.deletePublisher(publisherId);

    // Checks there is less a publisher in the database
    assertEquals(nbPublishers, publisherService.findAllPublishers().size());
  }
}
