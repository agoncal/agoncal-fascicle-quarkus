package org.agoncal.fascicle.quarkus.data.panache.repository;

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
class PublisherRepositoryTest {

  @Inject
  PublisherRepository publisherRepository;

  private static final String DEFAULT_NAME = "Name";
  private static final String UPDATED_NAME = "Name (updated)";

  private static int nbPublishers;
  private static long publisherId;

  @Test
  void shouldNotGetUnknownPublisher() {
    Long randomId = new Random().nextLong();
    Optional<Publisher> publisher = publisherRepository.findByIdOptional(randomId);
    assertFalse(publisher.isPresent());
  }

  @Test
  @Order(1)
  void shouldGetInitialPublishers() {
    List<Publisher> publishers = publisherRepository.findAll().list();
    assertTrue(publishers.size() > 0);
    nbPublishers = publishers.size();
  }

  @Test
  @Order(2)
  void shouldAddAnPublisher() {
    // Persists a publisher
    Publisher publisher = new Publisher();
    publisher.name = DEFAULT_NAME;
    publisherRepository.persist(publisher);

    // Checks the publisher has been created
    assertNotNull(publisherId);
    assertEquals(DEFAULT_NAME, publisher.name);

    // Checks there is an extra publisher in the database
    assertEquals(nbPublishers + 1, publisherRepository.findAll().list().size());

    publisherId = publisher.id;
  }

  @Test
  @Order(3)
  void shouldUpdateAnPublisher() {
    Publisher publisher = new Publisher();
    publisher.id = publisherId;
    publisher.name = UPDATED_NAME;

    // Updates the previously created publisher
    publisherRepository.updatePublisher(publisher);

    // Checks the publisher has been updated
    publisher = publisherRepository.findByIdOptional(publisherId).get();
    assertEquals(UPDATED_NAME, publisher.name);

    // Checks there is no extra publisher in the database
    assertEquals(nbPublishers + 1, publisherRepository.findAll().list().size());
  }

  @Test
  @Order(4)
  void shouldRemoveAPublisher() {
    // Deletes the previously created publisher
    publisherRepository.delete(publisherRepository.findById(publisherId));

    // Checks there is less a publisher in the database
    assertEquals(nbPublishers, publisherRepository.findAll().list().size());
  }

  @Test
  @Order(5)
  public void shouldDeleteApress() {
    assertNotNull(publisherRepository.findByName("APress"));
  }
}
