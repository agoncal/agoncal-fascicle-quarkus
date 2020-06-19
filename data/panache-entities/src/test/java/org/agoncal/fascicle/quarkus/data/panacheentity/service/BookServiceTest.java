package org.agoncal.fascicle.quarkus.data.panacheentity.service;

import io.quarkus.test.junit.QuarkusTest;
import org.agoncal.fascicle.quarkus.data.panacheentity.model.Book;
import org.agoncal.fascicle.quarkus.data.panacheentity.model.Language;
import org.agoncal.fascicle.quarkus.data.panacheentity.service.BookService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import javax.inject.Inject;
import java.time.Instant;
import java.util.Optional;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BookServiceTest {

  @Inject
  BookService bookService;

  private static final String DEFAULT_TITLE = "Title";
  private static final String UPDATED_TITLE = "Title (updated)";
  private static final String DEFAULT_DESCRIPTION = "Description";
  private static final String UPDATED_DESCRIPTION = "Description (updated)";
  private static final Float DEFAULT_UNIT_COST = 1f;
  private static final Float UPDATED_UNIT_COST = 9f;
  private static final String DEFAULT_ISBN = "Isbn";
  private static final String UPDATED_ISBN = "Isbn (updated)";
  private static final Integer DEFAULT_NB_OF_PAGES = 1;
  private static final Integer UPDATED_NB_OF_PAGES = 2;
  private static final Instant DEFAULT_PUBLICATION_DATE = Instant.ofEpochSecond(1000);
  private static final Instant UPDATED_PUBLICATION_DATE = Instant.ofEpochSecond(5000);
  private static final Language DEFAULT_LANGUAGE = Language.ENGLISH;
  private static final Language UPDATED_LANGUAGE = Language.ENGLISH;

  private static int nbBooks;
  private static int nbEnglishBooks;
  private static int nbCheapBooks;
  private static long bookId;

  @Test
  void shouldNotGetUnknownBook() {
    Long randomId = new Random().nextLong();
    Optional<Book> book = bookService.findByIdOptional(randomId);
    assertFalse(book.isPresent());
  }

  @Test
  @Order(1)
  void shouldGetInitialBooks() {
    nbBooks = bookService.findAll().size();
    long countBooks = bookService.count();
    assertEquals(nbBooks, countBooks);
    assertTrue(nbBooks > 0);
    assertEquals(0, bookService.findBetweenPrices(0f, 2f).size());
  }

  @Test
  @Order(2)
  void shouldGetEnglishBooks() {
    nbEnglishBooks = bookService.findEnglishBooks().size();
    long countEnglishBooks = bookService.countEnglishBooks();
    assertEquals(nbEnglishBooks, countEnglishBooks);
    assertTrue(nbBooks > nbEnglishBooks);
  }

  @Test
  @Order(3)
  void shouldAddABook() {
    // Persists a book
    Book book = new Book();
    book.title = DEFAULT_TITLE;
    book.description = DEFAULT_DESCRIPTION;
    book.unitCost = DEFAULT_UNIT_COST;
    book.isbn = DEFAULT_ISBN;
    book.nbOfPage = DEFAULT_NB_OF_PAGES;
    book.publicationDate = DEFAULT_PUBLICATION_DATE;
    book.language = DEFAULT_LANGUAGE;

    assertFalse(book.isPersistent());
    book = bookService.persist(book);

    // Checks the book has been created
    assertNotNull(bookId);
    assertEquals(DEFAULT_TITLE, book.title);
    assertEquals(DEFAULT_DESCRIPTION, book.description);
    assertEquals(DEFAULT_UNIT_COST, book.unitCost);
    assertEquals(DEFAULT_ISBN, book.isbn);
    assertEquals(DEFAULT_NB_OF_PAGES, book.nbOfPage);
    assertEquals(DEFAULT_PUBLICATION_DATE, book.publicationDate);
    assertEquals(DEFAULT_LANGUAGE, book.language);

    // Checks there is an extra book in the database
    assertEquals(nbBooks + 1, bookService.findAll().size());
    assertEquals(nbEnglishBooks + 1, bookService.findEnglishBooks().size());
    assertEquals(1, bookService.findBetweenPrices(0f, 2f).size());

    bookId = book.id;
  }

  @Test
  @Order(4)
  void shouldUpdateAnBook() {
    Book book = new Book();
    book.id = bookId;
    book.title = UPDATED_TITLE;
    book.description = UPDATED_DESCRIPTION;
    book.unitCost = UPDATED_UNIT_COST;
    book.isbn = UPDATED_ISBN;
    book.nbOfPage = UPDATED_NB_OF_PAGES;
    book.publicationDate = UPDATED_PUBLICATION_DATE;
    book.language = UPDATED_LANGUAGE;

    // Updates the previously created book
    bookService.update(book);

    // Checks the book has been updated
    book = bookService.findByIdOptional(bookId).get();
    assertTrue(book.isPersistent());
    assertEquals(UPDATED_TITLE, book.title);
    assertEquals(UPDATED_DESCRIPTION, book.description);
    assertEquals(UPDATED_UNIT_COST, book.unitCost);
    assertEquals(UPDATED_ISBN, book.isbn);
    assertEquals(UPDATED_NB_OF_PAGES, book.nbOfPage);
    assertEquals(UPDATED_PUBLICATION_DATE, book.publicationDate);
    assertEquals(UPDATED_LANGUAGE, book.language);

    // Checks there is no extra book in the database
    assertEquals(nbBooks + 1, bookService.findAll().size());
    assertEquals(nbEnglishBooks + 1, bookService.findEnglishBooks().size());
    assertEquals(0, bookService.findBetweenPrices(0f, 2f).size());
  }

  @Test
  @Order(5)
  void shouldRemoveABook() {
    // Deletes the previously created book
    bookService.deleteById(bookId);

    // Checks there is less a book in the database
    assertEquals(nbBooks, bookService.findAll().size());
    assertEquals(nbEnglishBooks, bookService.findEnglishBooks().size());
  }
}
