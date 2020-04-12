package org.agoncal.fascicle.quarkus.http.jaxrs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
public class Books extends ArrayList<Book> {

  // ======================================
  // =            Constructors            =
  // ======================================

  public Books() {
    super();
  }

  public Books(Collection<? extends Book> c) {
    super(c);
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public List<Book> getBooks() {
    return this;
  }

  public void setBooks(List<Book> books) {
    this.addAll(books);
  }
}
