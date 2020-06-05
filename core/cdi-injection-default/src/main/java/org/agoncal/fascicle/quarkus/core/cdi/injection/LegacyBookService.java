package org.agoncal.fascicle.quarkus.core.cdi.injection;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// @formatter:off
@ApplicationScoped
public class LegacyBookService {

  // ======================================
  // =             Attributes             =
  // ======================================

  // tag::adocSnippet[]
  @Inject @Default
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
