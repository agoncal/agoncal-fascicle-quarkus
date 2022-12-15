package org.agoncal.fascicle.quarkus.observability.metrics.application;

import net.datafaker.Faker;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.Optional;
import java.util.Random;

@ApplicationScoped
public class BookService {

  public Optional<Book> findBookById(Long id) {
    sleep();
    if (new Random().nextBoolean()) {
      return Optional.of(generateBook());
    } else {
      return Optional.empty();
    }
  }

  public Book findRandomBook() {
    sleep();
    return generateBook();
  }

  public Long countAllBooks() {
    return Math.abs(new Random().nextLong());
  }

  private Book generateBook() {
    Faker faker = new Faker();
    Book book = new Book();
    book.title = faker.book().title();
    book.author = faker.book().author();
    book.description = faker.book().genre();
    return book;
  }

  private void sleep() {
    try {
      Thread.sleep((long) (Math.random() * 1000));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
