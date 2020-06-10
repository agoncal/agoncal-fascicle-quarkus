package org.agoncal.fascicle.quarkus.core.cdi.injection;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
@ApplicationScoped
public class BookService {

  // ======================================
  // =             Attributes             =
  // ======================================

  // tag::adocSnippet[]
  @Inject
  NumberGenerator numberGenerator;
  // end::adocSnippet[]

  // ======================================
  // =          Business methods          =
  // ======================================

  public Book createBook(String title, Float price, String description) {
    Book book = new Book(title, price, description);
    book.setIsbn(numberGenerator.generateNumber());
    return book;
  }
}
