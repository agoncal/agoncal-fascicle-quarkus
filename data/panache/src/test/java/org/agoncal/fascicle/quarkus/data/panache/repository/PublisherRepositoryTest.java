package org.agoncal.fascicle.quarkus.data.panache.repository;

import io.quarkus.test.junit.QuarkusTest;
import org.agoncal.fascicle.quarkus.data.panache.model.Publisher;
import org.junit.jupiter.api.Disabled;
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

@Disabled("https://github.com/quarkusio/quarkus/issues/7188")
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
    nbPublishers = publisherRepository.findAll().list().size();
    assertTrue(nbPublishers > 0);
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
  void shouldFindThePublisherByName() {
    Publisher publisher = publisherRepository.findByName(DEFAULT_NAME).get();

    // Checks the publisher has been created
    assertNotNull(publisherId);
    assertEquals(DEFAULT_NAME, publisher.name);
  }

  @Test
  @Order(4)
  void shouldUpdateAPublisher() {
    Publisher publisher = new Publisher();
    publisher.id = publisherId;
    publisher.name = UPDATED_NAME;

    // Updates the previously created publisher
    publisherRepository.update(publisher);

    // Checks the publisher has been updated
    publisher = publisherRepository.findByIdOptional(publisherId).get();
    assertEquals(UPDATED_NAME, publisher.name);

    // Checks there is no extra publisher in the database
    assertEquals(nbPublishers + 1, publisherRepository.findAll().list().size());
  }

  @Test
  @Order(5)
  void shouldRemoveAPublisher() {
    // Deletes the previously created publisher
    publisherRepository.deleteById(publisherId);

    // Checks there is less a publisher in the database
    assertEquals(nbPublishers, publisherRepository.findAll().list().size());
  }

  @Test
  @Order(6)
  public void shouldDeleteByName() {
    assertTrue(publisherRepository.deleteByName("Wrox Press") == 1);
    // Checks there is less a publisher in the database
    assertEquals(nbPublishers - 1, publisherRepository.findAll().list().size());
  }
}
