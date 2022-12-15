package org.agoncal.fascicle.quarkus.core.cdi.injectionpoint;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
@ApplicationScoped
public class DigitalBookService {

  NumberGenerator numberGenerator;

  public DigitalBookService(NumberGenerator numberGenerator) {
    this.numberGenerator = numberGenerator;
  }

  public Book createBook(String title, Float price, String description) {
    Book book = new Book(title, price, description);
    book.setIsbn(numberGenerator.generateNumber());
    return book;
  }

  public NumberGenerator getNumberGenerator() {
    return numberGenerator;
  }

  // tag::adocSnippet[]
  @Inject
  public void setNumberGenerator(NumberGenerator numberGenerator) {
    this.numberGenerator = numberGenerator;
  }
  // end::adocSnippet[]
}
