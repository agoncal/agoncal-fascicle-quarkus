package org.agoncal.fascicle.quarkus.data.panache.model;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

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
    // creating a publisher
    Publisher publisher = new Publisher();
    publisher.name = "AGoncal Fascicle";

    // persist it
    publisher.persist();
    // tag::adocSkip[]
    Long publisherId = publisher.id;
    assertNotNull(publisherId);
    // end::adocSkip[]

    // getting a list of all Publisher entities
    List<Publisher> allPublishers = Publisher.listAll();
    // tag::adocSkip[]
    assertTrue(allPublishers.size() > 1);
    // end::adocSkip[]

    // finding a specific publisher by ID
    publisher = Publisher.findById(publisherId);
    // tag::adocSkip[]
    assertEquals("AGoncal Fascicle", publisher.name);
    // end::adocSkip[]

    // finding a specific publisher by ID via an Optional
    Optional<Publisher> optional = Publisher.findByIdOptional(publisherId);
    publisher = optional.orElseThrow(() -> new EntityNotFoundException());

    // counting all publishers
    long countAll = Publisher.count();
    // tag::adocSkip[]
    assertTrue(countAll > 1);
    // end::adocSkip[]

    // check if it's persistent
    if (publisher.isPersistent()) {
      // delete it
      publisher.delete();
    }

    // delete by id
    boolean deleted = Publisher.deleteById(publisherId);
    // tag::adocSkip[]
    assertFalse(deleted);
    // end::adocSkip[]

    // delete all publishers
    // tag::adocSkip[]
    assertThrows(PersistenceException.class, () -> {
    // end::adocSkip[]
    Publisher.deleteAll();
    // tag::adocSkip[]
    });
    // end::adocSkip[]
    // end::adocSnippet[]
  }
}
