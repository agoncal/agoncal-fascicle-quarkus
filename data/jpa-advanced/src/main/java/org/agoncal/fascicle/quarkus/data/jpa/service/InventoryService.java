package org.agoncal.fascicle.quarkus.data.jpa.service;

import org.agoncal.fascicle.quarkus.data.jpa.model.Book;
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

  public void addToStock(Book book) throws Exception {
    try {
      tx.begin();
      repository.add(book);
      tx.commit();
    } catch (InventoryException e) {
      tx.rollback();
    }
  }
}
// end::adocSnippet[]
