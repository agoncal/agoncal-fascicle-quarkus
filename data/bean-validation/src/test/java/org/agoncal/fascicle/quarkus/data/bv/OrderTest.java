package org.agoncal.fascicle.quarkus.data.bv;

import io.quarkus.test.junit.QuarkusTest;
import org.agoncal.fascicle.quarkus.data.bv.Address;
import org.agoncal.fascicle.quarkus.data.bv.Customer;
import org.agoncal.fascicle.quarkus.data.bv.Order;
import org.agoncal.fascicle.quarkus.data.bv.OrderLine;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
@QuarkusTest
public class OrderTest {

  @Inject
  private Validator validator;

  // end::adocSnippet[]
  // ======================================
  // =              Methods               =
  // ======================================

  @Test
  void shouldRaiseNoConstraintsViolation() {

    // tag::shouldRaiseNoConstraintsViolation[]
    Order order = new Order().id(1234L).totalAmount(BigDecimal.valueOf(40.5)).creationDate(LocalDate.MIN);
    order.setCustomer(new Customer().firstName("Antonio").lastName("Goncalves").email("agoncal.fascicle@gmail.com"));
    order.setDeliveryAddress(new Address().street1("233 Spring Street").city("New York").state("NY").zipcode("12345").country("USA"));
    order.add(new OrderLine().item("Help").quantity(1).unitPrice(BigDecimal.valueOf(10.5)));
    order.add(new OrderLine().item("Sergeant Pepper").quantity(2).unitPrice(BigDecimal.valueOf(15d)));

    Set<ConstraintViolation<Order>> violations = validator.validate(order);
    assertEquals(0, violations.size());
    // end::shouldRaiseNoConstraintsViolation[]
  }

  @Test
  void shouldRaiseNoConstraintsViolationEvenWithNoAddress() {

    // tag::shouldRaiseNoConstraintsViolationEvenWithNoAddress[]
    Order order = new Order().id(1234L).totalAmount(BigDecimal.valueOf((40.5))).creationDate(LocalDate.MIN);
    order.setCustomer(new Customer().firstName("Antonio").lastName("Goncalves").email("agoncal.fascicle@gmail.com"));
    order.setDeliveryAddress(null);
    order.add(new OrderLine().item("Help").quantity(1).unitPrice(BigDecimal.valueOf(10.5)));
    order.add(new OrderLine().item("Sergeant Pepper").quantity(2).unitPrice(BigDecimal.valueOf(15d)));

    Set<ConstraintViolation<Order>> violations = validator.validate(order);
    assertEquals(0, violations.size());
    // end::shouldRaiseNoConstraintsViolationEvenWithNoAddress[]
  }

  @Test
  void shouldRaiseConstraintsViolationCauseInvalidCustomer() {

    // tag::shouldRaiseConstraintsViolationCauseInvalidCustomer[]
    Order order = new Order().id(1234L).totalAmount(BigDecimal.valueOf((40.5))).creationDate(LocalDate.MIN);
    order.setCustomer(new Customer().firstName(null).lastName("Goncalves").email("wrongEmail"));
    order.setDeliveryAddress(null);
    order.add(new OrderLine().item("Help").quantity(1).unitPrice(BigDecimal.valueOf(10.5)));
    order.add(new OrderLine().item("Sergeant Pepper").quantity(2).unitPrice(BigDecimal.valueOf(15d)));

    Set<ConstraintViolation<Order>> violations = validator.validate(order);
    assertEquals(2, violations.size());
    // end::shouldRaiseConstraintsViolationCauseInvalidCustomer[]
  }

  @Test
  void shouldRaiseConstraintsViolationCauseNullCustomer() {

    // tag::shouldRaiseConstraintsViolationCauseNullCustomer[]
    Order order = new Order().id(1234L).totalAmount(BigDecimal.valueOf(40.5)).creationDate(LocalDate.MIN);
    order.setCustomer(null);
    order.add(new OrderLine().item("Help").quantity(1).unitPrice(BigDecimal.valueOf(10.5)));
    order.add(new OrderLine().item("Sergeant Pepper").quantity(2).unitPrice(BigDecimal.valueOf(15d)));

    Set<ConstraintViolation<Order>> violations = validator.validate(order);
    assertEquals(1, violations.size());

    for (ConstraintViolation constraintViolation : violations) {
      System.out.println("### " + constraintViolation.getRootBeanClass().getSimpleName() +
        "." + constraintViolation.getPropertyPath() + " - Invalid Value = " + constraintViolation.getInvalidValue() + " - Error Msg = " + constraintViolation.getMessage());
    }
    // end::shouldRaiseConstraintsViolationCauseNullCustomer[]
  }

  @Test
  void shouldRaiseConstraintsViolationCauseNullQuantity() {

    // tag::shouldRaiseConstraintsViolationCauseNullQuantity[]
    Order order = new Order().id(1234L).totalAmount(BigDecimal.valueOf(40.5));
    order.setCustomer(new Customer().firstName("Antonio").lastName("Goncalves").email("agoncal.fascicle@gmail.com"));
    order.setDeliveryAddress(new Address().street1("233 Spring Street").city("New York").state("NY").zipcode("12345").country("USA"));
    order.add(new OrderLine().item("Help").quantity(null).unitPrice(BigDecimal.valueOf(10.5)));
    order.add(new OrderLine().item("Sergeant Pepper").quantity(2).unitPrice(BigDecimal.valueOf(15d)));

    Set<ConstraintViolation<Order>> violations = validator.validate(order);
    assertEquals(1, violations.size());
    // end::shouldRaiseConstraintsViolationCauseNullQuantity[]
  }

  @Test
  void shouldRaiseConstraintsViolationCauseNullQuantityNegativePrice() {

    // tag::shouldRaiseConstraintsViolationCauseNullQuantityNegativePrice[]
    Order order = new Order().id(1234L).totalAmount(BigDecimal.valueOf(40.5));
    order.setCustomer(new Customer().firstName("Antonio").lastName("Goncalves").email("agoncal.fascicle@gmail.com"));
    order.setDeliveryAddress(new Address().street1("233 Spring Street").city("New York").state("NY").zipcode("12345").country("USA"));
    order.add(new OrderLine().item("Help").quantity(null).unitPrice(BigDecimal.valueOf(10.5)));
    order.add(new OrderLine().item("Sergeant Pepper").quantity(2).unitPrice(BigDecimal.valueOf(-99d)));

    Set<ConstraintViolation<Order>> violations = validator.validate(order);
    assertEquals(2, violations.size());
    // end::shouldRaiseConstraintsViolationCauseNullQuantityNegativePrice[]
  }

  private void displayConstraintViolations(Set<ConstraintViolation<Order>> constraintViolations) {
    for (ConstraintViolation constraintViolation : constraintViolations) {
      System.out.println("### " + constraintViolation.getRootBeanClass().getSimpleName() +
        "." + constraintViolation.getPropertyPath() + " - Invalid Value = " + constraintViolation.getInvalidValue() + " - Error Msg = " + constraintViolation.getMessage());

    }
  }
}
