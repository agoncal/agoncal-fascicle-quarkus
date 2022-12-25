package org.agoncal.fascicle.quarkus.data.panacherepository.service;

import io.quarkus.hibernate.orm.panache.Panache;
import org.agoncal.fascicle.quarkus.data.panacherepository.model.Book;
import org.agoncal.fascicle.quarkus.data.panacherepository.repository.BookRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static jakarta.transaction.Transactional.TxType.REQUIRED;
import static jakarta.transaction.Transactional.TxType.SUPPORTS;

@ApplicationScoped
@Transactional(SUPPORTS)
public class BookService {

  @Inject
  BookRepository repository;

  @Transactional(REQUIRED)
  public Book persist(Book book) {
    repository.persist(book);
    return book;
  }

  public List<Book> findAll() {
    return repository.listAll();
  }

  public Optional<Book> findByIdOptional(Long id) {
    return repository.findByIdOptional(id);
  }

  @Transactional(REQUIRED)
  public Book update(Book book) {
    return Panache.getEntityManager().merge(book);
  }

  @Transactional(REQUIRED)
  public void deleteById(Long id) {
    repository.deleteById(id);
  }

  public long count() {
    return repository.count();
  }

  public List<Book> findEnglishBooks(){
    return repository.findEnglishBooks();
  }

  public long countEnglishBooks(){
    return repository.countEnglishBooks();
  }

  public List<Book> findBetweenPrices(Float min, Float max) {
    return repository.findBetweenPrices(min, max);
  }
}
