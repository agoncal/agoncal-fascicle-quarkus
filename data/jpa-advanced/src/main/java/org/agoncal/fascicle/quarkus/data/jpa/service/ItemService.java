package org.agoncal.fascicle.quarkus.data.jpa.service;

import org.agoncal.fascicle.quarkus.data.jpa.model.Book;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
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
