package org.agoncal.fascicle.quarkus.data.panache.service;

import io.quarkus.hibernate.orm.panache.Panache;
import org.agoncal.fascicle.quarkus.data.panache.model.Book;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

@ApplicationScoped
@Transactional(SUPPORTS)
public class BookService {

  @Transactional(REQUIRED)
  public Book persist(Book book) {
    Book.persist(book);
    return book;
  }

  public List<Book> findAll() {
    return Book.listAll();
  }

  public Optional<Book> findByIdOptional(Long id) {
    return Book.findByIdOptional(id);
  }

  @Transactional(REQUIRED)
  public Book update(Book book) {
    return Panache.getEntityManager().merge(book);
  }

  @Transactional(REQUIRED)
  public void deleteById(Long id) {
    Book.deleteById(id);
  }

  public long count() {
    return Book.count();
  }

  public List<Book> findEnglishBooks(){
    return Book.findEnglishBooks();
  }

  public long countEnglishBooks(){
    return Book.countEnglishBooks();
  }
}
