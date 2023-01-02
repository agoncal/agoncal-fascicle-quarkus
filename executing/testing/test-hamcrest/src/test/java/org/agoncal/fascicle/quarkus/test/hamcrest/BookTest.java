package org.agoncal.fascicle.quarkus.test.hamcrest;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

// @formatter:off
// tag::adocSnippet[]
class BookTest {

  @Test
  public void shouldTestEquals() {
    Book oneBook = new Book("H2G2");
    Book anotherBook = new Book("H2G2");
    assertThat(oneBook, equalTo(anotherBook));
  }
}
// end::adocSnippet[]
