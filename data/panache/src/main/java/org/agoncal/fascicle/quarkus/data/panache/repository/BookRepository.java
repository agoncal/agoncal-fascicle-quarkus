package org.agoncal.fascicle.quarkus.data.panache.repository;

import io.quarkus.hibernate.orm.panache.Panache;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.agoncal.fascicle.quarkus.data.panache.model.Book;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

import static javax.transaction.Transactional.TxType.REQUIRED;

@ApplicationScoped
public class BookRepository implements PanacheRepository<Book> {

  @Transactional(REQUIRED)
  public Book update(Book book) {
    return Panache.getEntityManager().merge(book);
  }

  public List<Book> findEnglishBooks(){
    return Book.findEnglishBooks();
  }

  public long countEnglishBooks(){
    return Book.countEnglishBooks();
  }
}
