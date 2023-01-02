package org.agoncal.fascicle.quarkus.core.cdi.qualifiers;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
@ApplicationScoped
// tag::adocSnippet[]
public class LegacyBookService {

  // tag::adocSkip[]
  @Inject
  // end::adocSkip[]
  @EightDigits
  NumberGenerator numberGenerator;

  public Book createBook(String title, Float price, String description) {
    Book book = new Book(title, price, description);
    book.setIsbn(numberGenerator.generateNumber());
    return book;
  }
}
// end::adocSnippet[]
