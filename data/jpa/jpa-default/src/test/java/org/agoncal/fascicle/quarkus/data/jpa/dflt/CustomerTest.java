package org.agoncal.fascicle.quarkus.data.jpa.dflt;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
@QuarkusTest
@Transactional
public class CustomerTest {

  @Inject
  EntityManager em;

  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test
  public void shouldPersistACustomerWithOneAddressSet() throws Exception {

    // tag::adocPersisting[]
    Customer customer = new Customer("Anthony", "Balla", "aballa@mail.com");
    Address address = new Address("Ritherdon Rd", "London", "8QE", "UK");
    customer.setAddress(address);

    // Persists the object
    em.persist(customer);
    em.persist(address);

    assertNotNull(customer.getId());
    assertNotNull(address.getId());
    // end::adocPersisting[]
  }

  @Test
  public void shouldFindACustomer() throws Exception {

    Customer createdCustomer = new Customer("Anthony", "Balla", "aballa@mail.com");
    Address createdAddress = new Address("Ritherdon Rd", "London", "8QE", "UK");
    createdCustomer.setAddress(createdAddress);

    // Persists the object
    em.persist(createdCustomer);
    em.persist(createdAddress);
    em.flush();

    assertNotNull(createdCustomer.getId());
    assertNotNull(createdAddress.getId());
    Long id = createdCustomer.getId();

    // Clear
    em.clear();

    // tag::adocFinding[]
    Customer customer = em.find(Customer.class, id);
    if (customer != null) {
      // Process the object
    }
    // end::adocFinding[]
    assertNotNull(customer);
  }

  @Test
  public void shouldGetAReferenceToCustomer() throws Exception {

    Customer createdCustomer = new Customer("Anthony", "Balla", "aballa@mail.com");
    Address createdAddress = new Address("Ritherdon Rd", "London", "8QE", "UK");
    createdCustomer.setAddress(createdAddress);

    // Persists the object
    em.persist(createdCustomer);
    em.persist(createdAddress);

    assertNotNull(createdCustomer.getId());
    assertNotNull(createdAddress.getId());
    Long id = createdCustomer.getId();

    // Clear
    em.clear();

    // tag::adocReference[]
    try {
      Customer customer = em.getReference(Customer.class, id);
      // Process the object
      assertNotNull(customer);
    } catch (
      EntityNotFoundException ex) {
      // Entity not found
    }
    // end::adocReference[]
  }

  @Test
  public void shouldRemoveACustomer() throws Exception {

    // tag::adocRemove[]
    Customer customer = new Customer("Anthony", "Balla", "aballa@mail.com");
    Address address = new Address("Ritherdon Rd", "London", "8QE", "UK");
    customer.setAddress(address);

    // Persists the object
    em.persist(customer);
    em.persist(address);

    assertNotNull(customer.getId());
    assertNotNull(address.getId());

    // Removes the object from the database
    em.remove(customer);
    em.remove(address);

    // The entities are not in the database
    assertNull(em.find(Customer.class, customer.getId()));
    assertNull(em.find(Address.class, address.getId()));
    // end::adocRemove[]
  }
}
