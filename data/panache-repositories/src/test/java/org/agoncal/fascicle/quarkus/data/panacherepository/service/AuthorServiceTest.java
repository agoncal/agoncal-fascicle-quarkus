package org.agoncal.fascicle.quarkus.data.panacherepository.service;

import io.quarkus.test.junit.QuarkusTest;
import org.agoncal.fascicle.quarkus.data.panacherepository.model.Author;
import org.agoncal.fascicle.quarkus.data.panacherepository.model.Language;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import javax.inject.Inject;
import java.time.LocalDate;
import java.time.Month;
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
    Optional<Author> author = authorService.findByIdOptional(randomId);
    assertFalse(author.isPresent());
  }

  @Test
  @Order(1)
  void shouldGetInitialAuthors() {
    nbAuthors = authorService.findAll().size();
    assertEquals(nbAuthors, authorService.findAllOrderByName().size());
    assertTrue(nbAuthors > 0);
  }

  @Test
  @Order(2)
  void shouldAddAnAuthor() {
    // Persists an author
    Author author = new Author();
    author.firstName = DEFAULT_FIRST_NAME;
    author.lastName = DEFAULT_LAST_NAME;
    author.bio = DEFAULT_BIO;
    author.dateOfBirth = DEFAULT_DATE_OF_BIRTH;
    author.preferredLanguage = DEFAULT_LANGUAGE;

    assertFalse(author.isPersistent());
    author = authorService.persist(author);

    // Checks the author has been created
    assertNotNull(authorId);
    assertEquals(DEFAULT_FIRST_NAME, author.firstName);
    assertEquals(DEFAULT_LAST_NAME, author.lastName);
    assertEquals(DEFAULT_BIO, author.bio);
    assertEquals(DEFAULT_DATE_OF_BIRTH, author.dateOfBirth);
    assertEquals(DEFAULT_LANGUAGE, author.preferredLanguage);
    assertTrue(author.age > 45);

    // Checks there is an extra author in the database
    assertEquals(nbAuthors + 1, authorService.findAll().size());

    authorId = author.id;
  }

  @Test
  @Order(3)
  void shouldFindTheAuthorByName() {
    Author author = authorService.findByName(DEFAULT_LAST_NAME).get();

    // Checks the author has been created
    assertNotNull(authorId);
    assertEquals(DEFAULT_FIRST_NAME, author.firstName);
    assertEquals(DEFAULT_LAST_NAME, author.lastName);
    assertEquals(DEFAULT_BIO, author.bio);
    assertEquals(DEFAULT_DATE_OF_BIRTH, author.dateOfBirth);
    assertEquals(DEFAULT_LANGUAGE, author.preferredLanguage);
    assertTrue(author.age > 45);
  }

  @Test
  @Order(4)
  void shouldUpdateAnAuthor() {
    Author author = new Author();
    author.id = authorId;
    author.firstName = UPDATED_FIRST_NAME;
    author.lastName = UPDATED_LAST_NAME;
    author.bio = UPDATED_BIO;
    author.dateOfBirth = UPDATED_DATE_OF_BIRTH;
    author.preferredLanguage = UPDATED_LANGUAGE;

    // Updates the previously created author
    authorService.update(author);

    // Checks the author has been updated
    author = authorService.findByIdOptional(authorId).get();
    assertTrue(author.isPersistent());
    assertEquals(UPDATED_FIRST_NAME, author.firstName);
    assertEquals(UPDATED_LAST_NAME, author.lastName);
    assertEquals(UPDATED_BIO, author.bio);
    assertEquals(UPDATED_DATE_OF_BIRTH, author.dateOfBirth);
    assertEquals(UPDATED_LANGUAGE, author.preferredLanguage);
    assertTrue(author.age < 45);

    // Checks there is no extra author in the database
    assertEquals(nbAuthors + 1, authorService.findAll().size());
  }

  @Test
  @Order(5)
  void shouldRemoveAnAuthor() {
    // Deletes the previously created author
    authorService.deleteById(authorId);

    // Checks there is less an author in the database
    assertEquals(nbAuthors, authorService.findAll().size());
  }
}
