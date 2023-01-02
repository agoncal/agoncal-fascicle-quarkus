package org.agoncal.fascicle.quarkus.test.hamcrest;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;

class BookAssertionsTest {

  @Test
  public void shouldAssertThat() {
    Book book = new Book("H2G2", 1979, 250);
    Book anotherBook = new Book("H2G2", 1979, 250);
    // tag::adocAssertThat[]
    assertThat(book.getTitle(), equalTo("H2G2"));
    assertThat(book.getYearOfPublication(), equalTo(1979));
    assertThat(book, equalTo(anotherBook));
    // end::adocAssertThat[]
  }

  @Test
  public void shouldAssertThatIs() {
    Book book = new Book("H2G2", 1979, 250);
    Book anotherBook = new Book("H2G2", 1979, 250);
    // tag::adocAssertThatIs[]
    assertThat(book.getTitle(), is(equalTo("H2G2")));
    assertThat(book.getYearOfPublication(), is(equalTo(1979)));
    assertThat(book, is(anotherBook));
    assertThat(book.getTitle(), is(not(nullValue())));
    assertThat(book.getIsbn10(), is(nullValue()));
    assertThat(book.getNbOfPages(), is(greaterThan(100)));
    // end::adocAssertThatIs[]
  }
}
