package org.agoncal.fascicle.quarkus.data.jpa.service;

import org.agoncal.fascicle.quarkus.data.jpa.model.Book;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import java.util.List;

// tag::adocSnippet[]
@ApplicationScoped
@Transactional
public class ItemService {

  @Inject
  EntityManager em;

  @Inject
  StatisticsService statistics;

  public List<Book> findBooks() {
    return em.createQuery("SELECT b FROM Book b", Book.class).getResultList();
  }

  public Book createBook(Book book) {
    em.persist(book);
    statistics.addNew(book);
    return book;
  }
}
// end::adocSnippet[]
