package org.agoncal.fascicle.quarkus.data.jpa.service;

import org.agoncal.fascicle.quarkus.data.jpa.model.Book;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

@ApplicationScoped
@Transactional(REQUIRED)
public class BookService {

  private static final Logger LOGGER = Logger.getLogger(BookService.class);

  @Inject
  private EntityManager em;

  public Book persistBook(Book book) {
    Book.persist(book);
    return book;
  }

  @Transactional(SUPPORTS)
  public List<Book> findAllBooks() {
    return Book.listAll();
  }

  @Transactional(SUPPORTS)
  public Optional<Book> findBookById(Long id) {
    return Book.findByIdOptional(id);
  }

  public Book updateBook(Book book) {
    Book entity = Book.findById(book.id);
    entity.title = book.title;
    entity.description = book.description;
    entity.unitCost = book.unitCost;
    entity.isbn = book.isbn;
    entity.nbOfPage = book.nbOfPage;
    entity.publicationDate = book.publicationDate;
    entity.language = book.language;
    return entity;
  }

  public void deleteBook(Long id) {
    Book book = Book.findById(id);
    book.delete();
  }

  public List<Book> findEnglishBooks(){
    return Book.findEnglishBooks();
  }

  public long countEnglishBooks(){
    return Book.countEnglishBooks();
  }

  public long countAll() {
    return Book.count();
  }
}
