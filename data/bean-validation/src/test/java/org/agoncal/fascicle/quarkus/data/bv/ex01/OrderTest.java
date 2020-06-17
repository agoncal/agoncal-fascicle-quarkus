package org.agoncal.fascicle.quarkus.data.bv.ex01;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
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

  private static Instant creationDate = Instant.MIN;
  private static LocalDate deliveryDate = LocalDate.MAX;


  // ======================================
  // =              Methods               =
  // ======================================

  @Test
  void shouldRaiseNoConstraintViolation() {

    Order order = new Order(creationDate);
    order.setOrderId("C45678");
    order.setTotalAmount(BigDecimal.valueOf(1234.5));
    order.setDeliveryDate(deliveryDate);
    order.addOrderLine(new OrderLine("item", 12d, 2));

    Set<ConstraintViolation<Order>> violations = validator.validate(order);
    assertEquals(0, violations.size());
  }

  @Test
  void shouldRaiseNoConstraintViolationGoodPattern() {

    Order order = new Order(creationDate);
    order.setOrderId("D45678");
    order.setTotalAmount(BigDecimal.valueOf(1234.5));
    order.setDeliveryDate(deliveryDate);
    order.addOrderLine(new OrderLine("item", 12d, 2));

    Set<ConstraintViolation<Order>> violations = validator.validate(order);
    assertEquals(0, violations.size());
  }

  @Test
  void shouldRaiseViolationDueToWrongPattern() {

    Order order = new Order(creationDate);
    order.setOrderId("CDM45678");
    order.setTotalAmount(BigDecimal.valueOf(1234.5));
    order.setDeliveryDate(deliveryDate);
    order.addOrderLine(new OrderLine("item", 12d, 2));

    Set<ConstraintViolation<Order>> violations = validator.validate(order);
    assertEquals(1, violations.size());
  }

  @Test
  void shouldRaiseViolationDueToWrongPattern2() {

    Order order = new Order(creationDate);
    order.setOrderId("Z45678");
    order.setTotalAmount(BigDecimal.valueOf(1234.5));
    order.setDeliveryDate(deliveryDate);
    order.addOrderLine(new OrderLine("item", 12d, 2));

    Set<ConstraintViolation<Order>> violations = validator.validate(order);
    assertEquals(1, violations.size());
  }

  @Test
  void shouldRaiseViolationDueToNullAmount() {

    Order order = new Order(creationDate);
    order.setOrderId("C45678");
    order.setTotalAmount(null);
    order.setDeliveryDate(deliveryDate);
    order.addOrderLine(new OrderLine("item", 12d, 2));

    Set<ConstraintViolation<Order>> violations = validator.validate(order);
    assertEquals(1, violations.size());
  }

  @Test
  void shouldRaiseViolationDueToMinAmount() {

    Order order = new Order(creationDate);
    order.setOrderId("C45678");
    order.setTotalAmount(BigDecimal.valueOf(0.5d));
    order.setDeliveryDate(deliveryDate);
    order.addOrderLine(new OrderLine("item", 12d, 2));

    Set<ConstraintViolation<Order>> violations = validator.validate(order);
    assertEquals(1, violations.size());
  }

  @Test
  void shouldRaiseViolationDueToEmptyLines() {

    Order order = new Order(creationDate);
    order.setOrderId("C45678");
    order.setTotalAmount(BigDecimal.valueOf(1234.5));
    order.setDeliveryDate(deliveryDate);

    Set<ConstraintViolation<Order>> violations = validator.validate(order);
    assertEquals(1, violations.size());
  }

  private void displayConstraintViolations(Set<ConstraintViolation<Order>> constraintViolations) {
    for (ConstraintViolation constraintViolation : constraintViolations) {
      System.out.println("### " + constraintViolation.getRootBeanClass().getSimpleName() +
        "." + constraintViolation.getPropertyPath() + " - Invalid Value = " + constraintViolation.getInvalidValue() + " - Error Msg = " + constraintViolation.getMessage());

    }
  }
}
