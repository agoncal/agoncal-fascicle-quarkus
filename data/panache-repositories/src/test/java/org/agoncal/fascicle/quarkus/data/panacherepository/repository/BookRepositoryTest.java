package org.agoncal.fascicle.quarkus.data.panacherepository.repository;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.panache.common.Parameters;
import io.quarkus.test.junit.QuarkusTest;
import org.agoncal.fascicle.quarkus.data.panacherepository.model.Book;
import org.agoncal.fascicle.quarkus.data.panacherepository.model.Language;
import org.junit.jupiter.api.Test;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
@Transactional
class BookRepositoryTest {

  @Inject
  BookRepository repository;

  @Test
  void shouldFind() {

    // Find returns a PanacheQuery
    PanacheQuery<Book> bookQuery = repository.find("nbOfPage > 100 ORDER BY title");
    List<Book> books = bookQuery.list();
    Long nbBooks = bookQuery.count();
    Book firstBook = bookQuery.firstResult();
    Optional<Book> oBook = bookQuery.firstResultOptional();

    assertEquals(5, books.size());
    assertEquals(5, nbBooks);
    assertEquals("Beginning Java EE 7", firstBook.title);
    assertEquals("Beginning Java EE 7", oBook.get().title);

    // list() is a shortcut to find().list()
    books = repository.find("nbOfPage > 100 ORDER BY title").list();
    assertEquals(5, books.size());
    // tag::adocSimpleQuery[]
    // Simplified JPQL query
    books = repository.list("nbOfPage > 100 ORDER BY title");

    // end::adocSimpleQuery[]
    assertEquals(5, books.size());
  }

  @Test
  void shouldQuery() {

    List<Book> books;
    // Full JPQL query
    books = repository.list("SELECT b FROM Book b WHERE b.nbOfPage > 100 ORDER BY b.title");
    assertEquals(5, books.size());

    // Simplified JPQL query
    books = repository.list("FROM Book b WHERE b.nbOfPage > 100 ORDER BY b.title");
    assertEquals(5, books.size());

    // Very simplified JPQL query
    books = repository.list("nbOfPage > 100 ORDER BY title");
    assertEquals(5, books.size());
  }

  @Test
  void shouldQueryWithParameters() {

    float min = 0f;
    float max = 30f;
    List<Book> cheapBooks;

    // Hard coded parameters
    cheapBooks = repository.list("unitCost between 0 and 30");
    assertEquals(1, cheapBooks.size());

    // tag::adocParam[]
    // Positional parameters
    cheapBooks = repository.list("unitCost between ?1 and ?2", min, max);

    // end::adocParam[]
    assertEquals(1, cheapBooks.size());

    // Named parameters
    Map<String, Object> params = Map.of("min", min, "max", max);
    cheapBooks = repository.list("unitCost between :min and :max", params);
    assertEquals(1, cheapBooks.size());

    // tag::adocParameters[]
    // Using the Parameters class
    cheapBooks = repository.list("unitCost between :min and :max",
                 Parameters.with("min", min).and("max", max));

    // end::adocParameters[]
    assertEquals(1, cheapBooks.size());

    // Passing an enumeration
    List<Book> englishBooks = repository.list("language", Language.ENGLISH);
    assertEquals(4, englishBooks.size());
  }
}
