package org.agoncal.fascicle.quarkus.data.jpa.service;

import org.agoncal.fascicle.quarkus.data.jpa.model.Book;
import org.agoncal.fascicle.quarkus.data.jpa.model.Language;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

@ApplicationScoped
@Transactional(SUPPORTS)
public class BookService {

  @Inject
  EntityManager em;

  @Transactional(REQUIRED)
  public Book persist(Book book) {
    em.persist(book);
    return book;
  }

  public List<Book> findAll() {
    return em.createQuery("select b from Book b", Book.class).getResultList();
  }

  public Optional<Book> findByIdOptional(Long id) {
    Book book = em.find(Book.class, id);
    return book != null ? Optional.of(book) : Optional.empty();
  }

  @Transactional(REQUIRED)
  public Book update(Book book) {
    return em.merge(book);
  }

  @Transactional(REQUIRED)
  public void deleteById(Long id) {
    em.remove(em.find(Book.class, id));
  }

  public long count() {
    return em.createQuery("select count(b) from Book b", Long.class).getSingleResult();
  }

  public List<Book> findEnglishBooks() {
    List<Book> books = em.createQuery("SELECT b FROM Book b WHERE b.language = :language", Book.class)
      .setParameter("language", Language.ENGLISH)
      .getResultList();
    return books;
  }

  public long countEnglishBooks() {
    long nbBooks = em.createQuery("SELECT count(b) FROM Book b WHERE b.language = :language", Long.class)
      .setParameter("language", Language.ENGLISH)
      .getSingleResult();
    return nbBooks;
  }
}
