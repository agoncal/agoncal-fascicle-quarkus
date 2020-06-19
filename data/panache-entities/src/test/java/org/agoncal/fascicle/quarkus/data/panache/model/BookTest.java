package org.agoncal.fascicle.quarkus.data.panache.model;

import io.quarkus.panache.common.Parameters;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
@Transactional
class BookTest {

  @Test
  void shouldQuery() {

    // tag::adocShouldQuery[]
    // Full JPQL query
    List<Book> books = Book.list("SELECT b FROM Book b WHERE b.nbOfPage > 100 ORDER BY b.title");
    // tag::adocSkip[]
    assertEquals(5, books.size());
    // end::adocSkip[]

    // Simplified JPQL query
    books = Book.list("FROM Book b WHERE b.nbOfPage > 100 ORDER BY b.title");
    // tag::adocSkip[]
    assertEquals(5, books.size());
    // end::adocSkip[]

    // Very simplified JPQL query
    books = Book.list("nbOfPage > 100 ORDER BY title");
    // tag::adocSkip[]
    assertEquals(5, books.size());
    // end::adocSkip[]

    // Counting
    Long nbBooks = Book.count("nbOfPage > 100");
    // tag::adocSkip[]
    assertEquals(5, nbBooks);
    // end::adocSkip[]
    // end::adocShouldQuery[]
  }

  @Test
  void shouldQueryWithParameters() {

    List<Book> books;
    // tag::adocShouldQueryWithParameters[]
    // Full JPQL query
    books = Book.list("SELECT b FROM Book b WHERE b.nbOfPage > 100 ORDER BY b.title");
    // tag::adocSkip[]
    assertEquals(5, books.size());
    // end::adocSkip[]

    // Simplified JPQL query
    books = Book.list("FROM Book b WHERE b.nbOfPage > 100 ORDER BY b.title");
    // tag::adocSkip[]
    assertEquals(5, books.size());
    // end::adocSkip[]

    // Very simplified JPQL query
    books = Book.list("nbOfPage > 100 ORDER BY title");
    // tag::adocSkip[]
    assertEquals(5, books.size());
    // end::adocSkip[]

    List<Book> englishBooks = Book.list("language", Language.ENGLISH);
    // tag::adocSkip[]
    assertEquals(4, englishBooks.size());
    // end::adocSkip[]

    long nbEnglishBooks = Book.count("language", Language.ENGLISH);
    // tag::adocSkip[]
    assertEquals(4, nbEnglishBooks);

    float min = 0;
    float max = 30;
    List<Book> cheapBooks;
    // end::adocSkip[]

    cheapBooks = Book.list("unitCost between :min and :max",
      Parameters.with("min", min).and("max", max));
    // tag::adocSkip[]
    assertEquals(1, cheapBooks.size());
    // end::adocShouldQueryWithParameters[]
  }
}
