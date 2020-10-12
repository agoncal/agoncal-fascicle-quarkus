package org.agoncal.fascicle.quarkus.data.jpa.query;


import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
@QuarkusTest
@Transactional
public class DynamicQueriesTest {

  @Inject
  EntityManager em;

  // ======================================
  // =              Constants             =
  // ======================================

  private static final int ALL_CUSTOMERS = 7;
  private static Customer customer01;
  private static Customer customer02;
  private static Customer customer03;
  private static Customer customer04;
  private static Customer customer05;
  private static Customer customer06;
  private static Customer customer07;

  //@BeforeEach
  private void initializeData() {
    customer01 = new Customer("Anthony", "Balla", "tballa@mail.com", 14);
    Address address01 = new Address("Procession St", "Paris", "75015");
    Country country01 = new Country("FR");
    address01.setCountry(country01);
    customer01.setAddress(address01);

    customer02 = new Customer("Vincent", "Johnson", "vj@mail.com", 45);
    Address address02 = new Address("Ritherdon Rd", "London", "8QE");
    Country country02 = new Country("UK");
    address02.setCountry(country02);
    customer02.setAddress(address02);

    customer03 = new Customer("Sebastian", "Twenty", "seb@yamail.com", 58);
    Address address03 = new Address("Inacio Alfama", "Lisbon", "A54");
    Country country03 = new Country("PT");
    address03.setCountry(country03);
    customer03.setAddress(address03);

    customer04 = new Customer("Frederic", "Riou", "fred@carmail.com", 41);
    Address address04 = new Address("Jardins", "Sao Paulo", "345678");
    Country country04 = new Country("BR");
    address04.setCountry(country04);
    customer04.setAddress(address04);

    customer05 = new Customer("Vincent", "Dubosc", "vd@yahoo.com", 14);
    Address address05 = new Address("Coffey", "Perth", "654F543");
    Country country05 = new Country("AU");
    address05.setCountry(country05);
    customer05.setAddress(address05);

    customer06 = new Customer("David", "Chene", "dch@yahoo.com", 89);
    Address address06 = new Address("Harbour Bridge", "Sydney", "JHG3");
    address06.setCountry(country05);
    customer06.setAddress(address06);

    customer07 = new Customer("Mike", "Pertus", "pertus@mike.com", 39);
    Address address07 = new Address("Playa de la Concha", "San Sebastian", "45678");
    Country country07 = new Country("ES");
    address07.setCountry(country07);
    customer07.setAddress(address07);

    // Persist the object
    em.persist(customer01);
    em.persist(customer02);
    em.persist(customer03);
    em.persist(customer04);
    em.persist(customer05);
    em.persist(customer06);
    em.persist(customer07);
  }

  //@AfterEach
  private void removeData() {
    // Remove objects
    em.remove(customer01);
    em.remove(customer02);
    em.remove(customer03);
    em.remove(customer04);
    em.remove(customer05);
    em.remove(customer06);
    em.remove(customer07);
  }

  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test
  public void adocQuery() throws Exception {
    initializeData();
    // tag::adocQuery[]
    Query query = em.createQuery("SELECT c FROM Customer c");
    List customers = query.getResultList();

    for (Object customer : customers) {
      System.out.println(((Customer) customer).getFirstName());
    }
    // end::adocQuery[]
    assertEquals(ALL_CUSTOMERS, customers.size());
    removeData();
  }

  @Test
  public void adocOneQuery() throws Exception {
    initializeData();
    // tag::adocOneQuery[]
    Query query = em.createQuery("SELECT c FROM Customer c WHERE c.firstName = 'Mike'");
    Customer customer = (Customer) query.getSingleResult();
    // end::adocOneQuery[]
    assertEquals("Mike", customer.getFirstName());
    removeData();
  }

  @Test
  public void adocTypedQuery() throws Exception {
    initializeData();
    // tag::adocTypedQuery[]
    TypedQuery<Customer> typedQuery = em.createQuery(
      "SELECT c FROM Customer c", Customer.class);
    List<Customer> customers = typedQuery.getResultList();

    for (Customer customer : customers) {
      System.out.println(customer.getFirstName());
    }
    // end::adocTypedQuery[]
    assertEquals(ALL_CUSTOMERS, customers.size());
    removeData();
  }

  @Test
  public void adocTypedOneQuery() throws Exception {
    initializeData();
    // tag::adocTypedOneQuery[]
    TypedQuery<Customer> typedQuery = em.createQuery(
      "SELECT c FROM Customer c WHERE c.firstName = 'Mike'", Customer.class);
    Customer customer = typedQuery.getSingleResult();
    // end::adocTypedOneQuery[]
    assertEquals("Mike", customer.getFirstName());
    removeData();
  }

  @Test
  public void adocTypedQueryStream() throws Exception {
    initializeData();
    // tag::adocTypedQueryStream[]
    TypedQuery<Customer> typedQuery = em.createQuery(
      "SELECT c FROM Customer c", Customer.class);
    Stream<Customer> customers = typedQuery.getResultStream();

    customers.forEach(c -> System.out.println(c.getFirstName()));
    // end::adocTypedQueryStream[]
    removeData();
  }

  @Test
  public void adocQueryLine() throws Exception {
    initializeData();
    boolean someCriteria = true;
    // tag::adocQueryLine[]
    String jpqlQuery = "SELECT c FROM Customer c";
    if (someCriteria)
      jpqlQuery += " WHERE c.firstName = 'Mike'";

    TypedQuery<Customer> typedQuery = em.createQuery(jpqlQuery, Customer.class);
    List<Customer> customers = typedQuery.getResultList();
    // end::adocQueryLine[]
    assertEquals(1, customers.size());
    removeData();
  }

  @Test
  public void adocQueryParam() throws Exception {
    initializeData();
    // tag::adocQueryParam[]
    TypedQuery<Customer> typedQuery = em.createQuery(
      "SELECT c FROM Customer c WHERE c.firstName = :fname", Customer.class);
    typedQuery.setParameter("fname", "Mike");
    List<Customer> customers = typedQuery.getResultList();
    // end::adocQueryParam[]
    assertEquals(1, customers.size());
    removeData();
  }

  @Test
  public void adocQueryParamNum() throws Exception {
    initializeData();
    // tag::adocQueryParamNum[]
    TypedQuery<Customer> typedQuery = em.createQuery(
      "SELECT c FROM Customer c WHERE c.firstName = ?1", Customer.class);
    typedQuery.setParameter(1, "Mike");
    List<Customer> customers = typedQuery.getResultList();
    // end::adocQueryParamNum[]
    assertEquals(1, customers.size());
    removeData();
  }

  @Test
  public void adocQueryAll() throws Exception {
    initializeData();
    TypedQuery<Customer> typedQuery = em.createQuery(
      "SELECT c FROM Customer c", Customer.class);
    List<Customer> customers = typedQuery.getResultList();
    assertEquals(7, customers.size());
    removeData();
  }

  @Test
  public void adocQueryMax() throws Exception {
    initializeData();
    // tag::adocQueryMax[]
    TypedQuery<Customer> typedQuery = em.createQuery(
      "SELECT c FROM Customer c ORDER BY c.age", Customer.class);
    typedQuery.setMaxResults(5);
    List<Customer> customers = typedQuery.getResultList();
    // end::adocQueryMax[]
    assertEquals(5, customers.size());
    removeData();
  }

  @Test
  public void adocQueryFirstResult() throws Exception {
    initializeData();
    // tag::adocQueryFirstResult[]
    TypedQuery<Customer> typedQuery = em.createQuery(
      "SELECT c FROM Customer c ORDER BY c.age", Customer.class);
    typedQuery.setFirstResult(3);
    typedQuery.setMaxResults(10);
    List<Customer> customers = typedQuery.getResultList();
    // end::adocQueryFirstResult[]
    assertEquals(4, customers.size());
    removeData();
  }
}

