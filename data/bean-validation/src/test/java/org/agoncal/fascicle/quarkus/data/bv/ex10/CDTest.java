package org.agoncal.fascicle.quarkus.data.bv.ex10;

import io.quarkus.test.junit.QuarkusTest;
import org.hibernate.validator.HibernateValidator;
import org.junit.jupiter.api.Test;

import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.executable.ExecutableValidator;
import java.lang.reflect.Method;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
@QuarkusTest
public class CDTest {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Inject
  Validator validator;

  // ======================================
  // =              Methods               =
  // ======================================

  @Test
  void shouldRaiseNoConstraintViolationWithDefault() {
    // tag::shouldRaiseNoConstraintViolationWithDefault[]
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();
    // end::shouldRaiseNoConstraintViolationWithDefault[]

    CD cd = new CD().title("Kind of Blue").price(12.5f);

    Set<ConstraintViolation<CD>> violations = validator.validate(cd);
    assertEquals(0, violations.size());

    // tag::close[]
    factory.close();
    // end::close[]
  }

  @Test
  void shouldRaiseNoConstraintViolationWithNonDefault() {
    // @formatter:off
    // tag::shouldRaiseNoConstraintViolationWithNonDefault[]
    ValidatorFactory factory =
      Validation.byProvider(HibernateValidator.class)
                .configure()
                .buildValidatorFactory();
    Validator validator = factory.getValidator();
    // end::shouldRaiseNoConstraintViolationWithNonDefault[]
    // @formatter:on

    CD cd = new CD().title("Kind of Blue").price(12.5f);

    Set<ConstraintViolation<CD>> violations = validator.validate(cd);
    assertEquals(0, violations.size());

    factory.close();
  }

  @Test
  void shouldRaiseNoConstraintViolation() {

    // tag::shouldRaiseNoConstraintViolation[]
    CD cd = new CD().title("Kind of Blue").price(12.5f);

    Set<ConstraintViolation<CD>> violations = validator.validate(cd);
    assertEquals(0, violations.size());
    // end::shouldRaiseNoConstraintViolation[]
  }

  @Test
  void shouldRaiseConstraintViolationCauseTitleAndPriceAreNull() {

    // tag::shouldRaiseConstraintViolationCauseTitleAndPriceAreNull[]
    CD cd = new CD();

    Set<ConstraintViolation<CD>> violations = validator.validate(cd);
    assertEquals(2, violations.size());
    // end::shouldRaiseConstraintViolationCauseTitleAndPriceAreNull[]
  }

  @Test
  void shouldRaiseConstraintViolationCausePriceIsNegative() {

    // tag::shouldRaiseConstraintViolationCausePriceIsNegative[]
    CD cd = new CD().title("Kind of Blue").price(-10f);

    Set<ConstraintViolation<CD>> violations = validator.validate(cd);
    assertEquals(1, violations.size());
    ConstraintViolation<CD> violation = violations.iterator().next();

    assertEquals("must be greater than 0", violation.getMessage());
    assertEquals("{jakarta.validation.constraints.Positive.message}", violation.getMessageTemplate());
    assertEquals(-10f, violation.getInvalidValue());
    assertEquals("price", violation.getPropertyPath().toString());
    assertEquals(CD.class, violation.getRootBeanClass());
    assertTrue(violation.getConstraintDescriptor().getAnnotation() instanceof jakarta.validation.constraints.Positive);
    assertEquals("Kind of Blue", violation.getRootBean().title);
    // end::shouldRaiseConstraintViolationCausePriceIsNegative[]
  }

  @Test
  void shouldRaiseNoConstraintViolationValidatingNumberOfCDsProperty() {

    // tag::shouldRaiseNoConstraintViolationValidatingNumberOfCDsProperty[]
    CD cd = new CD().numberOfCDs(2);

    Set<ConstraintViolation<CD>> violations = validator.validateProperty(cd, "numberOfCDs");
    assertEquals(0, violations.size());
    // end::shouldRaiseNoConstraintViolationValidatingNumberOfCDsProperty[]
  }

  @Test
    //@Ignore("Make sure your local is EN, if not use the following JVM parameters : -Duser.language=en -Duser.country=EN")
  void shouldRaiseConstraintViolationValidatingNumberOfCDsProperty() {

    // tag::shouldRaiseConstraintViolationValidatingNumberOfCDsProperty[]
    CD cd = new CD().numberOfCDs(7);

    Set<ConstraintViolation<CD>> violations = validator.validateProperty(cd, "numberOfCDs");

    assertEquals(1, violations.size());
    ConstraintViolation<CD> violation = violations.iterator().next();

    assertEquals("must be less than or equal to 5", violation.getMessage());
    assertEquals(7, violation.getInvalidValue());
    assertEquals("{jakarta.validation.constraints.Max.message}", violation.getMessageTemplate());
    // end::shouldRaiseConstraintViolationValidatingNumberOfCDsProperty[]
  }

  @Test
  void shouldRaiseNoConstraintViolationValidatingNumberOfCDsPropertyValue() {

    Set<ConstraintViolation<CD>> violations;
    // tag::shouldRaiseNoConstraintViolationValidatingNumberOfCDsPropertyValue[]
    violations = validator.validateValue(CD.class, "numberOfCDs", 2);
    assertEquals(0, violations.size());

    violations = validator.validateValue(CD.class, "numberOfCDs", 7);
    assertEquals(1, violations.size());
    // end::shouldRaiseNoConstraintViolationValidatingNumberOfCDsPropertyValue[]
  }

  @Test
  void shouldRaiseNoMethodParameterConstraintViolation() throws NoSuchMethodException {

    // tag::shouldRaiseNoMethodParameterConstraintViolation[]
    CD cd = new CD().title("Kind of Blue").price(12.5f);

    ExecutableValidator methodValidator = validator.forExecutables();
    Method method = CD.class.getMethod("calculatePrice", Float.class);
    Set<ConstraintViolation<CD>> violations = methodValidator.validateParameters(cd, method, new Object[]{(float) 1.2});
    assertEquals(1, violations.size());
    // end::shouldRaiseNoMethodParameterConstraintViolation[]
  }

  @Test
    //@Ignore("Make sure your local is EN, if not use the following JVM parameters : -Duser.language=en -Duser.country=EN")
  void shouldRaiseMethodParameterConstraintViolationCauseRateIsLow() throws NoSuchMethodException {

    CD cd = new CD().title("Kind of Blue").price(12.5f);

    ExecutableValidator methodValidator = validator.forExecutables();
    Method method = CD.class.getMethod("calculatePrice", Float.class);
    Set<ConstraintViolation<CD>> violations = methodValidator.validateParameters(cd, method, new Object[]{(float) 1.2});
    displayConstraintViolations(violations);
    assertEquals(1, violations.size());
    assertEquals("must be greater than or equal to 1.4", violations.iterator().next().getMessage());
    assertEquals((float) 1.2, violations.iterator().next().getInvalidValue());
    assertEquals("{jakarta.validation.constraints.DecimalMin.message}", violations.iterator().next().getMessageTemplate());
  }

  private void displayConstraintViolations(Set<ConstraintViolation<CD>> constraintViolations) {
    for (ConstraintViolation constraintViolation : constraintViolations) {
      System.out.println("### " + constraintViolation.getRootBeanClass().getSimpleName() +
        "." + constraintViolation.getPropertyPath() + " - Invalid Value = " + constraintViolation.getInvalidValue() + " - Error Msg = " + constraintViolation.getMessage());

    }
  }
}
