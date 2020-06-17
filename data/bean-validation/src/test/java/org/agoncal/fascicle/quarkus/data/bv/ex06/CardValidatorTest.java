package org.agoncal.fascicle.quarkus.data.bv.ex06;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.executable.ExecutableValidator;
import java.lang.reflect.Method;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
@QuarkusTest
public class CardValidatorTest {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Inject
  Validator validator;

  // ======================================
  // =              Methods               =
  // ======================================

  @Test
  void shouldRaiseNoConstraintViolation() throws NoSuchMethodException {

    CreditCard creditCard = new CreditCard("12341234", "10/10", 1234, "VISA");
    CardValidator cardValidator = new CardValidator();

    ExecutableValidator methodValidator = validator.forExecutables();
    Method method = CardValidator.class.getMethod("validate", CreditCard.class);
    Set<ConstraintViolation<CardValidator>> violations = methodValidator.validateParameters(cardValidator, method, new Object[]{creditCard});
    assertEquals(0, violations.size());

    violations = methodValidator.validateReturnValue(cardValidator, method, Boolean.TRUE);
    assertEquals(0, violations.size());
  }

  @Test
  void shouldRaiseConstraintViolationCauseCreditCardIsNull() throws NoSuchMethodException {

    CardValidator cardValidator = new CardValidator();

    ExecutableValidator methodValidator = validator.forExecutables();
    Method method = CardValidator.class.getMethod("validate", CreditCard.class);
    Set<ConstraintViolation<CardValidator>> violations = methodValidator.validateParameters(cardValidator, method, new Object[]{null});
    displayConstraintViolations(violations);
    assertEquals(1, violations.size());
  }

  private void displayConstraintViolations(Set<ConstraintViolation<CardValidator>> constraintViolations) {
    for (ConstraintViolation constraintViolation : constraintViolations) {
      System.out.println("### " + constraintViolation.getRootBeanClass().getSimpleName() +
        "." + constraintViolation.getPropertyPath() + " - Invalid Value = " + constraintViolation.getInvalidValue() + " - Error Msg = " + constraintViolation.getMessage());

    }
  }
}
