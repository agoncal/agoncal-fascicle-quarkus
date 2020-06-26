package org.agoncal.fascicle.quarkus.data.panacherepository.repository;

import io.quarkus.hibernate.orm.panache.Panache;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import org.agoncal.fascicle.quarkus.data.panacherepository.model.Book;
import org.agoncal.fascicle.quarkus.data.panacherepository.model.Language;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

import static javax.transaction.Transactional.TxType.REQUIRED;

@ApplicationScoped
public class BookRepository implements PanacheRepository<Book> {

  public Book update(Book book) {
    return Panache.getEntityManager().merge(book);
  }

  public List<Book> findEnglishBooks() {
    List<Book> books = list("language", Language.ENGLISH);
    return books;
  }

  public long countEnglishBooks() {
    long nbBooks = count("language", Language.ENGLISH);
    return nbBooks;
  }

  public List<Book> findBetweenPrices(Float min, Float max) {
    List<Book> books = list("unitCost between :min and :max",
      Parameters.with("min", min).and("max", max));
    return books;
  }
}
