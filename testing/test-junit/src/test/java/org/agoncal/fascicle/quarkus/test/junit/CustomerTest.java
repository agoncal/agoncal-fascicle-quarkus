package org.agoncal.fascicle.quarkus.test.junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocClass[]
public class CustomerTest {

  private Customer customer = new Customer();

// end::adocClass[]

// tag::adocFixture[]
  @BeforeEach
  public void clearCustomer() {
    customer.clear();
  }
// end::adocFixture[]

// tag::ageShouldBeGreaterThanZero[]
  @Test
  public void ageShouldBeGreaterThanZero() {
    customer = new Customer("Rita", "Navalhas", "rnavalhas@gmail.com");
    customer.setDateOfBirth(LocalDate.of(1975, 5, 27));

    customer.calculateAge();

    assertTrue(customer.getAge() >= 0);
  }
// end::ageShouldBeGreaterThanZero[]

// tag::shouldThrowAnExceptionCauseDateOfBirtheIsNull[]
  @Test
  public void shouldThrowAnExceptionCauseDateOfBirtheIsNull() {

    customer = null;
    assertThrows(NullPointerException.class, () -> {
      customer.calculateAge();
    });
  }
// end::shouldThrowAnExceptionCauseDateOfBirtheIsNull[]

// tag::shouldCalculateOldAge[]
  @Test
  @Disabled("Test is not ready yet")
  public void shouldCalculateOldAge() {
    // some work to do
  }
// end::shouldCalculateOldAge[]
}
