package org.agoncal.fascicle.quarkus.data.panacheentities;

import javax.enterprise.context.ApplicationScoped;
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

  @Transactional(REQUIRED)
  public Book createBook(Book book) {
    Book.persist(book);
    return book;
  }

  public Book findBook(Long id) {
    return Book.findById(id);
  }

  public List<Book> findAllBooks() {
    return Book.listAll();
  }

  public List<Book> findAllH2G2Books() {
    return Book.list("title", "H2G2");
  }
}
// end::adocSnippet[]
