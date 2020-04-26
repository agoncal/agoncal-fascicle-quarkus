package org.agoncal.fascicle.quarkus.data.jpa.service;

import io.quarkus.test.junit.QuarkusTest;
import org.agoncal.fascicle.quarkus.data.jpa.model.Book;
import org.agoncal.fascicle.quarkus.data.jpa.model.Language;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import javax.inject.Inject;
import java.time.Instant;
import java.util.List;
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
  private static final Float UPDATED_UNIT_COST = 2f;
  private static final String DEFAULT_ISBN = "Isbn";
  private static final String UPDATED_ISBN = "Isbn (updated)";
  private static final Integer DEFAULT_NB_OF_PAGES = 1;
  private static final Integer UPDATED_NB_OF_PAGES = 2;
  private static final Instant DEFAULT_PUBLICATION_DATE = Instant.ofEpochSecond(1000);
  private static final Instant UPDATED_PUBLICATION_DATE = Instant.ofEpochSecond(5000);
  private static final Language DEFAULT_LANGUAGE = Language.ENGLISH;
  private static final Language UPDATED_LANGUAGE = Language.CHINESE;

  private static int nbBooks;
  private static long bookId;

  @Test
  void shouldNotGetUnknownBook() {
    Long randomId = new Random().nextLong();
    Optional<Book> book = bookService.findBookById(randomId);
    assertFalse(book.isPresent());
  }

  @Test
  @Order(1)
  void shouldGetInitialBooks() {
    List<Book> books = bookService.findAllBooks();
    assertTrue(books.size() > 0);
    nbBooks = books.size();
  }

  @Test
  @Order(2)
  void shouldAddAnBook() {
    // Persists a book
    Book book = new Book();
    book.setTitle( DEFAULT_TITLE);
    book.setDescription( DEFAULT_DESCRIPTION);
    book.setUnitCost( DEFAULT_UNIT_COST);
    book.setIsbn( DEFAULT_ISBN);
    book.setNbOfPage( DEFAULT_NB_OF_PAGES);
    book.setPublicationDate( DEFAULT_PUBLICATION_DATE);
    book.setLanguage( DEFAULT_LANGUAGE);

    book = bookService.persistBook(book);

    // Checks the book has been created
    assertNotNull(bookId);
    assertEquals(DEFAULT_TITLE, book.getTitle());
    assertEquals(DEFAULT_DESCRIPTION, book.getDescription());
    assertEquals(DEFAULT_UNIT_COST, book.getUnitCost());
    assertEquals(DEFAULT_ISBN, book.getIsbn());
    assertEquals(DEFAULT_NB_OF_PAGES, book.getNbOfPage());
    assertEquals(DEFAULT_PUBLICATION_DATE, book.getPublicationDate());
    assertEquals(DEFAULT_LANGUAGE, book.getLanguage());

    // Checks there is an extra book in the database
    assertEquals(nbBooks + 1, bookService.findAllBooks().size());

    bookId = book.getId();
  }

  @Test
  @Order(3)
  void shouldUpdateAnBook() {
    Book book = new Book();
    book.setId( bookId);
    book.setTitle( UPDATED_TITLE);
    book.setDescription( UPDATED_DESCRIPTION);
    book.setUnitCost( UPDATED_UNIT_COST);
    book.setIsbn( UPDATED_ISBN);
    book.setNbOfPage( UPDATED_NB_OF_PAGES);
    book.setPublicationDate( UPDATED_PUBLICATION_DATE);
    book.setLanguage( UPDATED_LANGUAGE);

    // Updates the previously created book
    bookService.updateBook(book);

    // Checks the book has been updated
    book = bookService.findBookById(bookId).get();
    assertEquals(UPDATED_TITLE, book.getTitle());
    assertEquals(UPDATED_DESCRIPTION, book.getDescription());
    assertEquals(UPDATED_UNIT_COST, book.getUnitCost());
    assertEquals(UPDATED_ISBN, book.getIsbn());
    assertEquals(UPDATED_NB_OF_PAGES, book.getNbOfPage());
    assertEquals(UPDATED_PUBLICATION_DATE, book.getPublicationDate());
    assertEquals(UPDATED_LANGUAGE, book.getLanguage());

    // Checks there is no extra book in the database
    assertEquals(nbBooks + 1, bookService.findAllBooks().size());
  }

  @Test
  @Order(4)
  void shouldRemoveAnBook() {
    // Deletes the previously created book
    bookService.deleteBook(bookId);

    // Checks there is less a book in the database
    assertEquals(nbBooks, bookService.findAllBooks().size());
  }

  @Test
  void shouldFindEnglishBooks() {
    assertEquals(bookService.findAllBooks().size(), bookService.countAllBooks());
    assertEquals(bookService.findEnglishBooks().size(), bookService.countEnglishBooks());
    assertTrue(bookService.findAllBooks().size() > bookService.findEnglishBooks().size());
  }
}
