package org.agoncal.fascicle.quarkus.core.cdi.events;

import org.jboss.logging.Logger;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
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

  // tag::adocSkip[]
  @Inject
  Logger LOGGER;

  // end::adocSkip[]
  List<Book> inventory = new ArrayList<>();

  public void addBook(@Observes Book book) {
    // tag::adocSkip[]
    LOGGER.info("Adding book " + book.getTitle() + " to inventory");
    // end::adocSkip[]
    inventory.add(book);
  }
}
// end::adocSnippet[]
