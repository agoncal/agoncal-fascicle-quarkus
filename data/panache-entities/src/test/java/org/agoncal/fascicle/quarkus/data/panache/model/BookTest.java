package org.agoncal.fascicle.quarkus.data.panache.model;

import io.quarkus.panache.common.Parameters;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    float min = 0f;
    float max = 30f;

    // tag::adocShouldQueryWithParameters[]
    // Hard coded parameters
    List<Book> cheapBooks = Book.list("unitCost between 0 and 30");
    // tag::adocSkip[]
    assertEquals(1, cheapBooks.size());
    // end::adocSkip[]

    // Position parameters
    cheapBooks = Book.list("unitCost between ?1 and ?2", min, max);
    // tag::adocSkip[]
    assertEquals(1, cheapBooks.size());
    // end::adocSkip[]

    // Named parameters
    Map<String, Object> params = new HashMap<>();
    params.put("min", min);
    params.put("max", max);
    cheapBooks = Book.list("unitCost between :min and :max", params);
    // tag::adocSkip[]
    assertEquals(1, cheapBooks.size());
    // end::adocSkip[]

    // Using the Parameters class
    cheapBooks = Book.list("unitCost between :min and :max",
      Parameters.with("min", min).and("max", max));
    // tag::adocSkip[]
    assertEquals(1, cheapBooks.size());
    // end::adocShouldQueryWithParameters[]

    // Passing an enumeration
    List<Book> englishBooks = Book.list("language", Language.ENGLISH);
    // tag::adocSkip[]
    assertEquals(4, englishBooks.size());
    // end::adocSkip[]
    // end::adocShouldQueryWithParameters[]
  }
}
