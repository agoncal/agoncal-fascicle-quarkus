package org.agoncal.fascicle.quarkus.data.panacherepositories;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
@Disabled
@QuarkusTest
public class BookServiceTest {

  @Inject
  private BookService bookService;

  // ======================================
  // =              Methods               =
  // ======================================

  @Test
  public void shoudInjectBookService() {
    assertNotNull(bookService);
  }

  @Test
  public void shouldCreateABook() throws Exception {

    // tag::shouldCreateABook[]
    Book book = new Book().title("Java EE 7").price(23.5F).isbn("1-84023-742-2").nbOfPages(354);

    book = bookService.createBook(book);
    assertNotNull(book.getId(), "Id should not be null");

    List<Book> allBooks = bookService.findAllBooks();
    assertTrue(allBooks.size() >= 1);
    // end::shouldCreateABook[]
  }

  @Test
  public void shouldCreateABookWithTagsAndChapters() throws Exception {

    // tag::shouldCreateABookWithTagsAndChapters[]
    Book book = new Book().title("Java EE 7").price(23.5F).isbn("1-84023-742-4").nbOfPages(354);
    book.tag("java ee").tag("java").tag("enterprise");
    book.chapter(1, new Chapter("Bean Validation"));
    book.chapter(2, new Chapter("CDI"));
    book.chapter(3, new Chapter("JPA"));
    book.chapter(4, new Chapter("EJB"));

    // Persists the book to the database
    bookService.createBook(book);

    // Checks the book
    Book foundBook = bookService.findBook(book.getId());
    assertEquals(3, foundBook.getTags().size());
    assertEquals(4, foundBook.getChapters().size());
    // end::shouldCreateABookWithTagsAndChapters[]
  }

  @Test
  public void shouldCreateABookWithTwoAuthors() throws Exception {

    // tag::shouldCreateABookWithTwoAuthors[]
    Author deepu = new Author().firstName("Deepu").lastName("Sasidharan");
    Author sendil = new Author().firstName("Sendil").lastName("Kumar");
    Book book = new Book().title("Full Stack Development with JHipster").price(23.5F).isbn("5-84023-742-5").nbOfPages(354).author(deepu).author(sendil);
    deepu.book(book);
    sendil.book(book);

    // Persists the book to the database
    bookService.createBook(book);

    // Checks the book
    Book foundBook = bookService.findBook(book.getId());
    assertEquals(2, foundBook.getAuthors().size());
    // end::shouldCreateABookWithTwoAuthors[]
  }

  @Test
  public void shouldCreateH2G2Book() throws Exception {

    // Creates an instance of book
    Book book = new Book().title("H2G2").price(12.5F).description("The Hitchhiker's Guide to the Galaxy").isbn("1-84023-742-3").nbOfPages(354).illustrations(true);

    // Persists the book to the database
    bookService.createBook( book);
    Assertions.assertNotNull(book.getId(), "Id should not be null");

    // Retrieves all the books from the database
    List<Book> allBooks = bookService.findAllBooks();

    // Retrieves all the H2G2 books from the database
    List<Book> h2g2Books = bookService.findAllH2G2Books();
    assertEquals(1, h2g2Books.size());

    assertTrue(allBooks.size() >= h2g2Books.size());
  }

  @Test
  public void shouldCreateABookWithAnAuthor() throws Exception {

    // Creates an instance of book
    Author author = new Author().firstName("Antonio").lastName("Goncalves");
    Book book = new Book().title("Java EE 7").price(23.5F).isbn("1-84023-742-5").nbOfPages(354).author(author);
    author.book(book);

    // Persists the book to the database
    bookService.createBook(book);
    assertNotNull(book.getId(), "Id should not be null");

    // Checks the book
    Book foundBook = bookService.findBook(book.getId());
    assertEquals(1, foundBook.getAuthors().size());
  }

  @Test
  public void shouldFailCreatingTwoBooksWithSameISBN() throws Exception {

    Book book1 = new Book().title("Java EE 7").price(23.5F).isbn("1111").nbOfPages(354);
    Book book2 = new Book().title("Java EE 8").price(34.25F).isbn("1111").nbOfPages(482);

    // Persists the book to the database
    assertThrows(Exception.class, () -> {
      bookService.createBook(book1);
      bookService.createBook(book2);
    });
  }
}
