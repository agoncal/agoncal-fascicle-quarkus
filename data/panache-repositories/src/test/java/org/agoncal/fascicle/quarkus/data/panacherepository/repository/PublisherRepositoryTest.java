package org.agoncal.fascicle.quarkus.data.panacherepository.repository;

import io.quarkus.test.junit.QuarkusTest;
import org.agoncal.fascicle.quarkus.data.panacherepository.model.Publisher;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
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

  @Inject
  PublisherRepository repository;

  @Test
  void shouldManagePublishers() {

    // tag::adocSnippet[]
    // Creating a publisher
    Publisher publisher = new Publisher();
    publisher.name = "AGoncal Fascicle";

    // Persist it
    repository.persist(publisher);
    // tag::adocSkip[]
    Long publisherId = publisher.id;
    assertNotNull(publisherId);
    // end::adocSkip[]

    // Getting a list of all Publisher entities
    List<Publisher> allPublishers = repository.listAll();
    // tag::adocSkip[]
    assertTrue(allPublishers.size() > 1);
    // end::adocSkip[]

    // Finding a specific publisher by ID
    publisher = repository.findById(publisherId);
    // tag::adocSkip[]
    assertEquals("AGoncal Fascicle", publisher.name);
    // end::adocSkip[]

    // Finding a specific publisher by ID via an Optional
    Optional<Publisher> optional = repository.findByIdOptional(publisherId);
    publisher = optional.orElseThrow(() -> new EntityNotFoundException());

    // Counting all publishers
    long countAll = repository.count();
    // tag::adocSkip[]
    assertTrue(countAll > 1);
    // end::adocSkip[]

    // Check if it's persistent
    if (repository.isPersistent(publisher)) {
      // delete it
      repository.delete(publisher);
    }

    // Delete by id
    boolean deleted = repository.deleteById(publisherId);
    // tag::adocSkip[]
    assertFalse(deleted);
    // end::adocSkip[]

    // Delete all publishers
    // tag::adocSkip[]
    assertThrows(PersistenceException.class, () -> {
    // end::adocSkip[]
    repository.deleteAll();
    // tag::adocSkip[]
    });
    // end::adocSkip[]
    // end::adocSnippet[]
  }
}
