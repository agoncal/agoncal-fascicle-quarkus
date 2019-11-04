package org.agoncal.fascicle.quarkus.transactionsorm;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
@Transactional
public class BookService {

  // Obtains an entity manager
  @PersistenceContext(unitName = "cdbookstorePU")
  private EntityManager em;

  public Book createBook(Book book) {
    em.persist(book);
    return book;
  }
}
// end::adocSnippet[]
