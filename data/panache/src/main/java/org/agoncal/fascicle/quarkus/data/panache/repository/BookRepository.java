package org.agoncal.fascicle.quarkus.data.panache.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.agoncal.fascicle.quarkus.data.panache.model.Book;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

import static javax.transaction.Transactional.TxType.REQUIRED;

@ApplicationScoped
@Transactional(REQUIRED)
public class BookRepository implements PanacheRepository<Book> {

  private static final Logger LOGGER = Logger.getLogger(BookRepository.class);

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
