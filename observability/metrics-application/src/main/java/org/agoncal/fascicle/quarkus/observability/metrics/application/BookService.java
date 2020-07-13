package org.agoncal.fascicle.quarkus.observability.metrics.application;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@ApplicationScoped
public class BookService {

  public List<Book> findAllBooks() {
    return null;
  }

  public Optional<Book> findBookById(Long id) {
    return Optional.empty();
  }

  public Book findRandomBook() {
    return null;
  }

  public Long countAllBooks() {
    return new Random().nextLong();
  }
}
