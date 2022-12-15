package org.agoncal.fascicle.quarkus.http.openapi.advanced;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookService {

  public Book persistBook(Book book) {
    return null;
  }

  public List<Book> findAllBooks() {
    return null;
  }

  public Optional<Book> findBookById(Long id) {
    return Optional.empty();
  }

  public Book findRandomBook() {
    return null;
  }

  public Book updateBook(Book book) {
    return null;
  }

  public void deleteBook(Long id) {
  }
}
