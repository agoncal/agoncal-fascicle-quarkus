package org.agoncal.fascicle.quarkus.transactionsorm;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
@ApplicationScoped
@Transactional(SUPPORTS)
public class BookService {

  // Obtains an entity manager
  @PersistenceContext(unitName = "cdbookstorePU")
  private EntityManager em;

  @Transactional(REQUIRED)
  public Book createBook(Book book) {
    em.persist(book);
    return book;
  }

  public Book findBook(Long id) {
    return em.find(Book.class, id);
  }

  public List<Book> findAllBooks() {
    return em.createNamedQuery("findAllBooks", Book.class).getResultList();
  }

  public List<Book> findAllH2G2Books() {
    return em.createNamedQuery("findBookH2G2", Book.class).getResultList();
  }
}
// end::adocSnippet[]
