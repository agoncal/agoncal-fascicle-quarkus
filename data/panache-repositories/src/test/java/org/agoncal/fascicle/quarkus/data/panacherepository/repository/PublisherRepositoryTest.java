package org.agoncal.fascicle.quarkus.data.panacherepository.repository;

import io.quarkus.test.junit.QuarkusTest;
import org.agoncal.fascicle.quarkus.data.panacherepository.model.Publisher;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.wildfly.common.Assert.assertFalse;

// @formatter:off
@QuarkusTest
@Transactional
class PublisherRepositoryTest {

  // tag::adocSnippet[]
  @Inject
  PublisherRepository publisherRepository;

  // tag::adocSkip[]
  @Test
  // end::adocSkip[]
  void shouldManagePublishers() {

    // Creates a publisher
    Publisher publisher = new Publisher();
    publisher.name = "AGoncal Fascicle";

    // Persists it
    publisherRepository.persist(publisher);
    // tag::adocSkip[]
    Long publisherId = publisher.id;
    assertNotNull(publisherId);
    // end::adocSkip[]

    // Gets a list of all publisher entities
    List<Publisher> allPublishers = publisherRepository.listAll();
    // tag::adocSkip[]
    assertTrue(allPublishers.size() > 1);
    // end::adocSkip[]

    // Finds a specific publisher by ID
    publisher = publisherRepository.findById(publisherId);
    // tag::adocSkip[]
    assertEquals("AGoncal Fascicle", publisher.name);
    // end::adocSkip[]

    // Finds a specific publisher by ID via an Optional
    Optional<Publisher> optional = publisherRepository.findByIdOptional(publisherId);
    publisher = optional.orElseThrow(EntityNotFoundException::new);

    // Counts all publishers
    long countAll = publisherRepository.count();
    // tag::adocSkip[]
    assertTrue(countAll > 1);
    // end::adocSkip[]

    // Checks if it's persistent
    if (publisherRepository.isPersistent(publisher)) {
      // delete it
      publisherRepository.delete(publisher);
    }

    // Deletes by id
    boolean deleted = publisherRepository.deleteById(publisherId);
    // tag::adocSkip[]
    assertFalse(deleted);
    // end::adocSkip[]

    // Deletes all publishers
    // tag::adocSkip[]
    assertThrows(PersistenceException.class, () -> {
    // end::adocSkip[]
    publisherRepository.deleteAll();
    // tag::adocSkip[]
    });
    // end::adocSkip[]
  }
  // end::adocSnippet[]

  @Test
  void shouldManageWithEntityManager() {

    // tag::adocEntityManager[]
    Publisher publisher = new Publisher();
    publisher.name = "AGoncal Fascicle";

    // Persists an entity with the Panache repository
    publisherRepository.persist(publisher);
    // tag::adocSkip[]
    Long publisherId = publisher.id;
    assertNotNull(publisherId);
    // end::adocSkip[]

    // Finds an entity with the entity manager
    publisher = publisherRepository.getEntityManager().find(Publisher.class, publisherId);
    // tag::adocSkip[]
    assertEquals("AGoncal Fascicle", publisher.name);
    // end::adocSkip[]
    // end::adocEntityManager[]
  }

  // tag::adocInject[]
  // Injects the entity manager
  @Inject
  EntityManager em;

  // end::adocInject[]

  @Test
  void shouldManageWithInjectedEntityManager() {

    // tag::adocInject[]
    Publisher publisher = new Publisher();
    publisher.name = "AGoncal Fascicle";

    // Persists an entity with the Panache repository
    publisherRepository.persist(publisher);
    // tag::adocSkip[]
    Long publisherId = publisher.id;
    assertNotNull(publisherId);
    // end::adocSkip[]

    // Finds an entity with the injected entity manager
    publisher = em.find(Publisher.class, publisherId);
    // tag::adocSkip[]
    assertEquals("AGoncal Fascicle", publisher.name);
    // end::adocSkip[]
    // end::adocInject[]
  }
}
