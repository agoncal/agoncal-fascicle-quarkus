package org.agoncal.fascicle.quarkus.data.panache.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.agoncal.fascicle.quarkus.data.panache.model.Author;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import static javax.transaction.Transactional.TxType.REQUIRED;

@ApplicationScoped
@Transactional(REQUIRED)
public class AuthorRepository implements PanacheRepository<Author> {

  private static final Logger LOGGER = Logger.getLogger(AuthorRepository.class);

  public Author updateAuthor(Author author) {
    Author entity = Author.findById(author.id);
    entity.firstName = author.firstName;
    entity.lastName = author.lastName;
    entity.bio = author.bio;
    entity.dateOfBirth = author.dateOfBirth;
    entity.preferredLanguage = author.preferredLanguage;
    return entity;
  }
}
