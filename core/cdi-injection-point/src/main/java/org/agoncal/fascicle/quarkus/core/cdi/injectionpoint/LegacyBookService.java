package org.agoncal.fascicle.quarkus.core.cdi.injectionpoint;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
@ApplicationScoped
public class LegacyBookService {

  NumberGenerator numberGenerator;

  // tag::adocSnippet[]
  @Inject
  public LegacyBookService(NumberGenerator numberGenerator) {
    this.numberGenerator = numberGenerator;
  }
  // end::adocSnippet[]

  public Book createBook(String title, Float price, String description) {
    Book book = new Book(title, price, description);
    book.setIsbn(numberGenerator.generateNumber());
    return book;
  }
}
