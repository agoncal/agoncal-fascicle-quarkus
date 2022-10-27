package org.agoncal.fascicle.quarkus.core.cdi.injectionpoint;

import jakarta.enterprise.context.ApplicationScoped;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
@ApplicationScoped
public class PrestigiousBookService {

  NumberGenerator numberGenerator;

  // tag::adocSnippet[]
  public PrestigiousBookService(NumberGenerator numberGenerator) {
    this.numberGenerator = numberGenerator;
  }
  // end::adocSnippet[]

  public Book createBook(String title, Float price, String description) {
    Book book = new Book(title, price, description);
    book.setIsbn(numberGenerator.generateNumber());
    return book;
  }
}
