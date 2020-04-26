package org.agoncal.fascicle.quarkus.data.jpa.service;

import io.quarkus.test.junit.QuarkusTest;
import org.agoncal.fascicle.quarkus.data.jpa.model.Author;
import org.agoncal.fascicle.quarkus.data.jpa.model.Language;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import javax.inject.Inject;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AuthorServiceTest {

  @Inject
  AuthorService authorService;

  private static final String DEFAULT_FIRST_NAME = "First Name";
  private static final String UPDATED_FIRST_NAME = "First Name (updated)";
  private static final String DEFAULT_LAST_NAME = "Last Name";
  private static final String UPDATED_LAST_NAME = "Last Name (updated)";
  private static final String DEFAULT_BIO = "Bio";
  private static final String UPDATED_BIO = "Bio (updated)";
  private static final LocalDate DEFAULT_DATE_OF_BIRTH = LocalDate.of(1970, Month.FEBRUARY, 1);
  private static final LocalDate UPDATED_DATE_OF_BIRTH = LocalDate.of(1980, Month.APRIL, 2);
  private static final Language DEFAULT_LANGUAGE = Language.ENGLISH;
  private static final Language UPDATED_LANGUAGE = Language.CHINESE;

  private static int nbAuthors;
  private static long authorId;

  @Test
  void shouldNotGetUnknownAuthor() {
    Long randomId = new Random().nextLong();
    Optional<Author> author = authorService.findAuthorById(randomId);
    assertFalse(author.isPresent());
  }

  @Test
  @Order(1)
  void shouldGetInitialAuthors() {
    List<Author> authors = authorService.findAllAuthors();
    assertTrue(authors.size() > 0);
    nbAuthors = authors.size();
  }

  @Test
  @Order(2)
  void shouldAddAnAuthor() {
    // Persists an author
    Author author = new Author();
    author.setFirstName(DEFAULT_FIRST_NAME);
    author.setLastName(DEFAULT_LAST_NAME);
    author.setBio(DEFAULT_BIO);
    author.setDateOfBirth(DEFAULT_DATE_OF_BIRTH);
    author.setPreferredLanguage(DEFAULT_LANGUAGE);

    author = authorService.persistAuthor(author);

    // Checks the author has been created
    assertNotNull(authorId);
    assertEquals(DEFAULT_FIRST_NAME, author.getFirstName());
    assertEquals(DEFAULT_LAST_NAME, author.getLastName());
    assertEquals(DEFAULT_BIO, author.getBio());
    assertEquals(DEFAULT_DATE_OF_BIRTH, author.getDateOfBirth());
    assertEquals(DEFAULT_LANGUAGE, author.getPreferredLanguage());

    // Checks there is an extra author in the database
    assertEquals(nbAuthors + 1, authorService.findAllAuthors().size());

    authorId = author.getId();
  }

  @Test
  @Order(3)
  void shouldUpdateAnAuthor() {
    Author author = new Author();
    author.setId(authorId);
    author.setFirstName( UPDATED_FIRST_NAME);
    author.setLastName( UPDATED_LAST_NAME);
    author.setBio(UPDATED_BIO);
    author.setDateOfBirth( UPDATED_DATE_OF_BIRTH);
    author.setPreferredLanguage( UPDATED_LANGUAGE);

    // Updates the previously created author
    authorService.updateAuthor(author);

    // Checks the author has been updated
    author = authorService.findAuthorById(authorId).get();
    assertEquals(UPDATED_FIRST_NAME, author.getFirstName());
    assertEquals(UPDATED_LAST_NAME, author.getLastName());
    assertEquals(UPDATED_BIO, author.getBio());
    assertEquals(UPDATED_DATE_OF_BIRTH, author.getDateOfBirth());
    assertEquals(UPDATED_LANGUAGE, author.getPreferredLanguage());

    // Checks there is no extra author in the database
    assertEquals(nbAuthors + 1, authorService.findAllAuthors().size());
  }

  @Test
  @Order(4)
  void shouldRemoveAnAuthor() {
    // Deletes the previously created author
    authorService.deleteAuthor(authorId);

    // Checks there is less a author in the database
    assertEquals(nbAuthors, authorService.findAllAuthors().size());
  }
}
