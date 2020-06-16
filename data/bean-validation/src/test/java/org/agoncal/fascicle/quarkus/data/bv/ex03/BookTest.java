package org.agoncal.fascicle.quarkus.data.bv.ex03;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Antonio Goncalves
 * <p>
 * <p>
 * http://www.antoniogoncalves.org
 * --
 */
public class BookTest {

  // ======================================
  // =             Attributes             =
  // ======================================

  private static ValidatorFactory vf;
  private static Validator validator;

  // ======================================
  // =          Lifecycle Methods         =
  // ======================================

  @BeforeAll
  static void init() {
    vf = Validation.buildDefaultValidatorFactory();
    validator = vf.getValidator();
  }

  @AfterAll
  static void close() {
    vf.close();
  }

  // ======================================
  // =              Methods               =
  // ======================================

  @Test
  void shouldRaiseNoConstraintViolation() {

    Book book = new Book();
    book.setTitle("title");
    book.setPrice(2.99F);
    book.setDescription("description");
    book.setNbOfPages(10);
    book.setAuthorEmail("agoncal.fascicle@gmail.com");

    Set<ConstraintViolation<Book>> violations = validator.validate(book);
    assertEquals(0, violations.size());
  }

  @Test
  void shouldRaiseViolationDueToEmail() {

    Book book = new Book();
    book.setTitle("title");
    book.setPrice(2.99F);
    book.setDescription("description");
    book.setNbOfPages(10);
    book.setAuthorEmail("dummy");

    Set<ConstraintViolation<Book>> violations = validator.validate(book);
    assertEquals(1, violations.size());
  }

  @Test
  void shouldRaiseViolationDueToNbPages() {

    Book book = new Book();
    book.setTitle("title");
    book.setPrice(2.99F);
    book.setDescription("description");
    book.setNbOfPages(-10);
    book.setAuthorEmail("agoncal.fascicle@gmail.com");

    Set<ConstraintViolation<Book>> violations = validator.validate(book);
    assertEquals(1, violations.size());
  }

  @Test
  void shouldRaiseViolationDueToPrice() {

    Book book = new Book();
    book.setTitle("title");
    book.setPrice(2.4444499F);
    book.setDescription("description");
    book.setNbOfPages(10);
    book.setAuthorEmail("agoncal.fascicle@gmail.com");

    Set<ConstraintViolation<Book>> violations = validator.validate(book);
    assertEquals(1, violations.size());
  }

  @Test
  void shouldRaiseViolationDueToPriceNoDigits() {

    Book book = new Book();
    book.setTitle("title");
    book.setPrice(222222222F);
    book.setDescription("description");
    book.setNbOfPages(10);
    book.setAuthorEmail("agoncal.fascicle@gmail.com");

    Set<ConstraintViolation<Book>> violations = validator.validate(book);
    assertEquals(1, violations.size());
  }

  @Test
  void shouldRaiseViolationDueToTitle() {

    Book book = new Book();
    book.setTitle(null);
    book.setPrice(2.99F);
    book.setDescription("description");
    book.setNbOfPages(10);
    book.setAuthorEmail("agoncal.fascicle@gmail.com");

    Set<ConstraintViolation<Book>> violations = validator.validate(book);
    assertEquals(1, violations.size());
  }

  private void displayConstraintViolations(Set<ConstraintViolation<Book>> constraintViolations) {
    for (ConstraintViolation constraintViolation : constraintViolations) {
      System.out.println("### " + constraintViolation.getRootBeanClass().getSimpleName() +
        "." + constraintViolation.getPropertyPath() + " - Invalid Value = " + constraintViolation.getInvalidValue() + " - Error Msg = " + constraintViolation.getMessage());

    }
  }
}
