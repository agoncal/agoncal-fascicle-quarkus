package org.agoncal.fascicle.quarkus.data.panacheentity.model;

import io.quarkus.panache.common.Sort;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.transaction.Transactional;
import java.util.List;

import static io.quarkus.panache.common.Sort.Direction.Descending;
import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
@Transactional
class AuthorTest {

  @Test
  void shouldSort() {

    List<Author> authors;
    // tag::adocShouldSort[]

    // Sorts by first name ascending
    authors = Author.listAll(Sort.by("firstName"));
    // tag::adocSkip[]
    assertEquals(14, authors.size());
    // end::adocSkip[]

    // Sorts by first name descending
    authors = Author.listAll(Sort.by("firstName", Descending));
    // tag::adocSkip[]
    assertEquals(14, authors.size());
    // end::adocSkip[]

    // Sorts by first name ascending and last name descending
    authors = Author.listAll(Sort.by("firstName").and("lastName", Descending));
    // tag::adocSkip[]
    assertEquals(14, authors.size());
    // end::adocSkip[]
    // end::adocShouldSort[]
  }
}
