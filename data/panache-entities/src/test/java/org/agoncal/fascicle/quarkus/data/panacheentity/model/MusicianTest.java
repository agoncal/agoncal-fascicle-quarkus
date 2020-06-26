package org.agoncal.fascicle.quarkus.data.panacheentity.model;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.panache.common.Page;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
@Transactional
class MusicianTest {

  @Test
  void shouldPaginate() {

    // tag::adocSnippet[]
    // Create a query for all musicians
    PanacheQuery<Musician> musicianQuery = Musician.findAll();
    // tag::adocSkip[]
    assertEquals(13, musicianQuery.count());
    // end::adocSkip[]

    // Make it use pages of 5 entries at a time
    musicianQuery.page(Page.ofSize(5));

    // Get the first page
    List<Musician> firstPage = musicianQuery.list();
    // tag::adocSkip[]
    assertEquals(5, firstPage.size());
    // end::adocSkip[]

    // Get the second page
    List<Musician> secondPage = musicianQuery.nextPage().list();
    // tag::adocSkip[]
    assertEquals(5, secondPage.size());
    // end::adocSkip[]

    // Get the third page
    List<Musician> lastPage = musicianQuery.nextPage().list();
    // tag::adocSkip[]
    assertEquals(3, lastPage.size());
    // end::adocSkip[]

    // Get page 3 using index
    List<Musician> page3 = musicianQuery.page(Page.of(2, 5)).list();
    // tag::adocSkip[]
    assertEquals(3, page3.size());
    // end::adocSkip[]

    // Get the number of pages
    int numberOfPages = musicianQuery.pageCount();
    // end::adocSnippet[]
    assertEquals(3, numberOfPages);
  }
}
