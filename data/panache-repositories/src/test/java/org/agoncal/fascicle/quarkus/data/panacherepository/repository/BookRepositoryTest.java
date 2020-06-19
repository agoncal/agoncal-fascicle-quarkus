package org.agoncal.fascicle.quarkus.data.panacherepository.repository;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.panache.common.Parameters;
import io.quarkus.test.junit.QuarkusTest;
import org.agoncal.fascicle.quarkus.data.panacherepository.model.Book;
import org.agoncal.fascicle.quarkus.data.panacherepository.model.Language;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

// @formatter:off
@QuarkusTest
@Transactional
class BookRepositoryTest {

  @Inject
  BookRepository repository;

  @Test
  void shouldFind() {

    // tag::adocShouldFind[]
    // Find returns a PanacheQuery
    PanacheQuery<Book> bookQuery = repository.find("nbOfPage > 100 ORDER BY title");
    List<Book> books     = bookQuery.list();
    Long nbBooks         = bookQuery.count();
    Book firstBook       = bookQuery.firstResult();
    Optional<Book> oBook = bookQuery.firstResultOptional();
    // tag::adocSkip[]
    assertEquals(5, books.size());
    assertEquals(5, nbBooks);
    assertEquals("Beginning Java EE 7", firstBook.title);
    assertEquals("Beginning Java EE 7", oBook.get().title);
    // end::adocSkip[]

    // list() is a shortcut to find().list()
    books = repository.find("nbOfPage > 100 ORDER BY title").list();
    // tag::adocSkip[]
    assertEquals(5, books.size());
    // end::adocSkip[]
    books = repository.list("nbOfPage > 100 ORDER BY title");
    // tag::adocSkip[]
    assertEquals(5, books.size());
    // end::adocSkip[]
    // end::adocShouldFind[]
  }

  @Test
  void shouldQuery() {

    List<Book> books;
    // tag::adocShouldQuery[]
    // Full JPQL query
    books = repository.list("SELECT b FROM Book b WHERE b.nbOfPage > 100 ORDER BY b.title");
    // tag::adocSkip[]
    assertEquals(5, books.size());
    // end::adocSkip[]

    // Simplified JPQL query
    books = repository.list("FROM Book b WHERE b.nbOfPage > 100 ORDER BY b.title");
    // tag::adocSkip[]
    assertEquals(5, books.size());
    // end::adocSkip[]

    // Very simplified JPQL query
    books = repository.list("nbOfPage > 100 ORDER BY title");
    // tag::adocSkip[]
    assertEquals(5, books.size());
    // end::adocSkip[]
    // end::adocShouldQuery[]
  }

  @Test
  void shouldQueryWithParameters() {

    float min = 0f;
    float max = 30f;
    List<Book> cheapBooks;

    // tag::adocShouldQueryWithParameters[]
    // Hard coded parameters
    cheapBooks = repository.list("unitCost between 0 and 30");
    // tag::adocSkip[]
    assertEquals(1, cheapBooks.size());
    // end::adocSkip[]

    // Position parameters
    cheapBooks = repository.list("unitCost between ?1 and ?2", min, max);
    // tag::adocSkip[]
    assertEquals(1, cheapBooks.size());
    // end::adocSkip[]

    // Named parameters
    Map<String, Object> params = new HashMap<>();
    params.put("min", min);
    params.put("max", max);
    cheapBooks = repository.list("unitCost between :min and :max", params);
    // tag::adocSkip[]
    assertEquals(1, cheapBooks.size());
    // end::adocSkip[]

    // Using the Parameters class
    cheapBooks = repository.list("unitCost between :min and :max",
      Parameters.with("min", min).and("max", max));
    // tag::adocSkip[]
    assertEquals(1, cheapBooks.size());
    // end::adocSkip[]

    // Passing an enumeration
    List<Book> englishBooks = repository.list("language", Language.ENGLISH);
    // tag::adocSkip[]
    assertEquals(4, englishBooks.size());
    // end::adocSkip[]
    // end::adocShouldQueryWithParameters[]
  }
}
