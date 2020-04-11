package org.agoncal.fascicle.quarkus.core.cdi.events;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
@ApplicationScoped
public class BookService {

  @Inject
  NumberGenerator numberGenerator;

  @Inject
  Event<Book> bookAddedEvent;

  public Book createBook(String title, Float price, String description) {
    Book book = new Book(title, price, description);
    book.setIsbn(numberGenerator.generateNumber());
    bookAddedEvent.fire(book);
    return book;
  }
}
// end::adocSnippet[]
