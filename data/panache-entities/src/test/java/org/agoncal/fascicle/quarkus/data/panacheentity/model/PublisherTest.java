package org.agoncal.fascicle.quarkus.data.panacheentity.model;

import io.quarkus.test.junit.QuarkusTest;
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
class PublisherTest {

  @Test
  void shouldManagePublishers() {

    // tag::adocSnippet[]
    // Creates a publisher
    Publisher publisher = new Publisher();
    publisher.name = "AGoncal Fascicle";

    // Persists it
    publisher.persist();
    // tag::adocSkip[]
    Long publisherId = publisher.id;
    assertNotNull(publisherId);
    // end::adocSkip[]

    // Gets a list of all publisher entities
    List<Publisher> allPublishers = Publisher.listAll();
    // tag::adocSkip[]
    assertTrue(allPublishers.size() > 1);
    // end::adocSkip[]

    // Finds a specific publisher by ID
    publisher = Publisher.findById(publisherId);
    // tag::adocSkip[]
    assertEquals("AGoncal Fascicle", publisher.name);
    // end::adocSkip[]

    // Finds a specific publisher by ID via an Optional
    Optional<Publisher> optional = Publisher.findByIdOptional(publisherId);
    publisher = optional.orElseThrow(EntityNotFoundException::new);

    // Counts all publishers
    long countAll = Publisher.count();
    // tag::adocSkip[]
    assertTrue(countAll > 1);
    // end::adocSkip[]

    // Checks if it's persistent
    if (publisher.isPersistent()) {
      // Deletes it
      publisher.delete();
    }

    // Deletes by id
    boolean deleted = Publisher.deleteById(publisherId);
    // tag::adocSkip[]
    assertFalse(deleted);
    // end::adocSkip[]

    // Deletes all publishers
    // tag::adocSkip[]
    assertThrows(PersistenceException.class, () -> {
    // end::adocSkip[]
    Publisher.deleteAll();
    // tag::adocSkip[]
    });
    // end::adocSkip[]
    // end::adocSnippet[]
  }

  @Test
  void shouldManageWithEntityManager() {

    // tag::adocEntityManager[]
    Publisher publisher = new Publisher();
    publisher.name = "AGoncal Fascicle";

    // Persists an entity with Panache
    publisher.persist();
    // tag::adocSkip[]
    Long publisherId = publisher.id;
    assertNotNull(publisherId);
    // end::adocSkip[]

    // Finds an entity with the entity manager
    publisher = Publisher.getEntityManager().find(Publisher.class, publisherId);
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

    // Persists an entity with Panache
    publisher.persist();
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
