package org.agoncal.fascicle.quarkus.data.panache.service;

import org.agoncal.fascicle.quarkus.data.panache.model.Author;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

@ApplicationScoped
@Transactional(REQUIRED)
public class AuthorService {

  private static final Logger LOGGER = Logger.getLogger(AuthorService.class);

  public Author persistAuthor(Author author) {
    Author.persist(author);
    return author;
  }

  @Transactional(SUPPORTS)
  public List<Author> findAllAuthors() {
    return Author.listAll();
  }

  @Transactional(SUPPORTS)
  public Optional<Author> findAuthorById(Long id) {
    return Author.findByIdOptional(id);
  }

  public Author updateAuthor(Author author) {
    Author entity = Author.findById(author.id);
    entity.firstName = author.firstName;
    entity.lastName = author.lastName;
    entity.bio = author.bio;
    entity.dateOfBirth = author.dateOfBirth;
    entity.preferredLanguage = author.preferredLanguage;
    return entity;
  }

  public void deleteAuthor(Long id) {
    Author author = Author.findById(id);
    author.delete();
  }
}
