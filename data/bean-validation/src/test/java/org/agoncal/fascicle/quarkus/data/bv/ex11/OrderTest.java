package org.agoncal.fascicle.quarkus.data.bv.ex11;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
@QuarkusTest
public class OrderTest {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Inject
  Validator validator;

  // ======================================
  // =              Methods               =
  // ======================================

  @Test
  void shouldRaiseNoConstraintsViolation() {

    // tag::shouldRaiseNoConstraintsViolation[]
    Order order = new Order().id(1234L).totalAmount(40.5);
    order.deliveryAddress = new Address().street("Ritherdon Rd").zipcode("SE123").city("London");
    order.add(new OrderLine().item("Help").quantity(1).unitPrice(10.5));
    order.add(new OrderLine().item("Sergeant Pepper").quantity(2).unitPrice(15d));

    Set<ConstraintViolation<Order>> violations = validator.validate(order);

    assertEquals(0, violations.size());
    // end::shouldRaiseNoConstraintsViolation[]
  }

  @Test
  void shouldRaiseConstraintsViolationCauseWrongZipcode() {

    // tag::shouldRaiseConstraintsViolationCauseWrongZipcode[]
    Order order = new Order().id(1234L).totalAmount(40.5);
    order.deliveryAddress = new Address().street("Ritherdon Rd").zipcode("12345678").city("London");
    order.add(new OrderLine().item("Help").quantity(1).unitPrice(10.5));
    order.add(new OrderLine().item("Sergeant Pepper").quantity(2).unitPrice(15d));

    Set<ConstraintViolation<Order>> violations = validator.validate(order);

    assertEquals(1, violations.size());
    // end::shouldRaiseConstraintsViolationCauseWrongZipcode[]
  }

  @Test
  void shouldRaiseConstraintsViolationCauseNullCity() {

    // tag::shouldRaiseConstraintsViolationCauseNullCity[]
    Order order = new Order().id(1234L).totalAmount(40.5);
    order.deliveryAddress = new Address().street("Ritherdon Rd").zipcode("SE123").city(null);
    order.add(new OrderLine().item("Help").quantity(1).unitPrice(10.5));
    order.add(new OrderLine().item("Sergeant Pepper").quantity(2).unitPrice(15d));

    Set<ConstraintViolation<Order>> violations = validator.validate(order);

    assertEquals(1, violations.size());
    // end::shouldRaiseConstraintsViolationCauseNullCity[]
  }

  @Test
  void shouldRaiseConstraintsViolationCauseNullAddress() {

    // tag::shouldRaiseConstraintsViolationCauseNullAddress[]
    Order order = new Order().id(1234L).totalAmount(40.5);
    order.deliveryAddress = null;
    order.add(new OrderLine().item("Help").quantity(1).unitPrice(10.5));
    order.add(new OrderLine().item("Sergeant Pepper").quantity(2).unitPrice(15d));

    Set<ConstraintViolation<Order>> violations = validator.validate(order);

    assertEquals(1, violations.size());
    // end::shouldRaiseConstraintsViolationCauseNullAddress[]
  }

  @Test
  void shouldRaiseConstraintsViolationCauseNullQuantity() {

    // tag::shouldRaiseConstraintsViolationCauseNullQuantity[]
    Order order = new Order().id(1234L).totalAmount(40.5);
    order.deliveryAddress = new Address().street("Ritherdon Rd").zipcode("SE123").city("London");
    order.add(new OrderLine().item("Help").quantity(null).unitPrice(10.5));
    order.add(new OrderLine().item("Sergeant Pepper").quantity(2).unitPrice(15d));

    Set<ConstraintViolation<Order>> violations = validator.validate(order);
    assertEquals(1, violations.size());
    ConstraintViolation<Order> violation = violations.iterator().next();

    assertEquals("orderLines[0].quantity", violation.getPropertyPath().toString());
    assertEquals(Order.class, violation.getRootBean().getClass());
    assertEquals(OrderLine.class, violation.getLeafBean().getClass());
    // end::shouldRaiseConstraintsViolationCauseNullQuantity[]
  }

  @Test
  void shouldRaiseConstraintsViolationCauseNullQuantityNegativePrice() {

    // tag::shouldRaiseConstraintsViolationCauseNullQuantityNegativePrice[]
    Order order = new Order().id(1234L).totalAmount(40.5);
    order.deliveryAddress = new Address().street("Ritherdon Rd").zipcode("SE123").city("London");
    order.add(new OrderLine().item("Help").quantity(null).unitPrice(10.5));
    order.add(new OrderLine().item("Sergeant Pepper").quantity(2).unitPrice(-99d));

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
