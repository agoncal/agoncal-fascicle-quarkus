package org.agoncal.fascicle.quarkus.core.cdi.events;

import javax.enterprise.event.Observes;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
// tag::adocSnippet[]
@Singleton
public class InventoryService {

  List<Book> inventory = new ArrayList<>();

  public void addBook(@Observes Book book) {
    inventory.add(book);
  }
}
// end::adocSnippet[]
