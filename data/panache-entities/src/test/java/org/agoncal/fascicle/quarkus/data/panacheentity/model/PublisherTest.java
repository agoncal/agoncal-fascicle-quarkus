package org.agoncal.fascicle.quarkus.data.panacheentity.model;

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
    // Creating a publisher
    org.agoncal.fascicle.quarkus.data.panacheentity.model.Publisher publisher = new org.agoncal.fascicle.quarkus.data.panacheentity.model.Publisher();
    publisher.name = "AGoncal Fascicle";

    // Persist it
    publisher.persist();
    // tag::adocSkip[]
    Long publisherId = publisher.id;
    assertNotNull(publisherId);
    // end::adocSkip[]

    // Getting a list of all Publisher entities
    List<org.agoncal.fascicle.quarkus.data.panacheentity.model.Publisher> allPublishers = org.agoncal.fascicle.quarkus.data.panacheentity.model.Publisher.listAll();
    // tag::adocSkip[]
    assertTrue(allPublishers.size() > 1);
    // end::adocSkip[]

    // Finding a specific publisher by ID
    publisher = org.agoncal.fascicle.quarkus.data.panacheentity.model.Publisher.findById(publisherId);
    // tag::adocSkip[]
    assertEquals("AGoncal Fascicle", publisher.name);
    // end::adocSkip[]

    // Finding a specific publisher by ID via an Optional
    Optional<org.agoncal.fascicle.quarkus.data.panacheentity.model.Publisher> optional = org.agoncal.fascicle.quarkus.data.panacheentity.model.Publisher.findByIdOptional(publisherId);
    publisher = optional.orElseThrow(() -> new EntityNotFoundException());

    // Counting all publishers
    long countAll = org.agoncal.fascicle.quarkus.data.panacheentity.model.Publisher.count();
    // tag::adocSkip[]
    assertTrue(countAll > 1);
    // end::adocSkip[]

    // Check if it's persistent
    if (publisher.isPersistent()) {
      // delete it
      publisher.delete();
    }

    // Delete by id
    boolean deleted = org.agoncal.fascicle.quarkus.data.panacheentity.model.Publisher.deleteById(publisherId);
    // tag::adocSkip[]
    assertFalse(deleted);
    // end::adocSkip[]

    // Delete all publishers
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
