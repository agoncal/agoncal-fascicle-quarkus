package org.agoncal.fascicle.quarkus.core.cdi.injectionpoint;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
@ApplicationScoped
public class BookService {

  // tag::adocSnippet[]
  @Inject
  NumberGenerator numberGenerator;
  // end::adocSnippet[]

  public Book createBook(String title, Float price, String description) {
    Book book = new Book(title, price, description);
    book.setIsbn(numberGenerator.generateNumber());
    return book;
  }
}
