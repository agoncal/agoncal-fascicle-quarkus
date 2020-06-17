package org.agoncal.fascicle.quarkus.data.jpa.service;

import org.agoncal.fascicle.quarkus.data.jpa.model.Item;
import org.agoncal.fascicle.quarkus.data.jpa.repository.InventoryRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.UserTransaction;

// tag::adocSnippet[]
@ApplicationScoped
public class InventoryService {

  @Inject
  UserTransaction tx;

  @Inject
  InventoryRepository repository;

  public void oneItemSold(Item item) throws Exception {
    try {
      tx.begin();
      repository.add(item);
      repository.decreaseAvailableStock(item);
      sendShippingMessage();

      if (inventoryLevel(item) == 0)
        tx.rollback();
      else
        tx.commit();
    } catch (InventoryException e) {
      tx.rollback();
    }
  }
  // tag::adocSkip[]

  private void sendShippingMessage() {
  }

  private int inventoryLevel(Item item) {
    return 0;
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
