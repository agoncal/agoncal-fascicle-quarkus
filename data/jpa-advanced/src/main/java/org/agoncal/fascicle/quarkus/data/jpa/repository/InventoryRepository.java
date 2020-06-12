package org.agoncal.fascicle.quarkus.data.jpa.repository;

import org.agoncal.fascicle.quarkus.data.jpa.model.Book;
import org.agoncal.fascicle.quarkus.data.jpa.service.InventoryException;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class InventoryRepository {
  public void add(Book book) throws InventoryException {
    throw new InventoryException();
  }
}
