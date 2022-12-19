package org.agoncal.fascicle.quarkus.core.cdi.events;

import org.jboss.logging.Logger;

import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
@Singleton
public class InventoryService {

  @Inject
  Logger LOGGER;

  List<Book> inventory = new ArrayList<>();

  public void addBook(@Observes @Added Book book) {
    LOGGER.info("Adding book " + book.getTitle() + " to inventory");
    inventory.add(book);
  }

  public void removeBook(@Observes @Removed Book book) {
    LOGGER.info("Removing book " + book.getTitle() + " to inventory");
    inventory.remove(book);
  }
}
// end::adocSnippet[]
