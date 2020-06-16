package org.agoncal.fascicle.quarkus.data.jpa.repository;

import org.agoncal.fascicle.quarkus.data.jpa.model.Item;
import org.agoncal.fascicle.quarkus.data.jpa.service.InventoryException;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class InventoryRepository {
  public void add(Item item) throws InventoryException {
    throw new InventoryException();
  }

  public void decreaseAvailableStock(Item item) {

  }
}
