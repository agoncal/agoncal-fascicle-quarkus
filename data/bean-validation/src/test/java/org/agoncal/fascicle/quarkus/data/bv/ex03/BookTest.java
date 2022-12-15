package org.agoncal.fascicle.quarkus.data.bv.ex03;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
@QuarkusTest
public class BookTest {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Inject
  Validator validator;

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
