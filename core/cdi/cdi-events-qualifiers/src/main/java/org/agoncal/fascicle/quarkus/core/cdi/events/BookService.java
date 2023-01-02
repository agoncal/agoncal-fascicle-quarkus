package org.agoncal.fascicle.quarkus.core.cdi.events;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// @formatter:off
// tag::adocSnippet[]
@ApplicationScoped
public class BookService {

  @Inject
  NumberGenerator numberGenerator;

  @Inject @Added
  Event<Book> bookAddedEvent;

  @Inject @Removed
  Event<Book> bookRemovedEvent;

  public Book createBook(String title, Float price, String description) {
    Book book = new Book(title, price, description);
    book.setIsbn(numberGenerator.generateNumber());
    bookAddedEvent.fire(book);
    return book;
  }

  public void deleteBook(Book book) {
    bookRemovedEvent.fire(book);
  }
}
// end::adocSnippet[]
