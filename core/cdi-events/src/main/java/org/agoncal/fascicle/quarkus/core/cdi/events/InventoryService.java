package org.agoncal.fascicle.quarkus.core.cdi.events;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
// tag::adocSnippet[]
@ApplicationScoped
public class InventoryService {

  @Inject
  Logger logger;

  List<Book> inventory = new ArrayList<>();

  public void addBook(@Observes Book book) {
    logger.info("Adding book " + book.getTitle() + " to inventory");
    inventory.add(book);
  }
}
// end::adocSnippet[]
