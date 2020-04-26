package org.agoncal.fascicle.quarkus.data.jpa.service;

import org.agoncal.fascicle.quarkus.data.jpa.model.Author;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

@ApplicationScoped
@Transactional(SUPPORTS)
public class AuthorService {

  private static final Logger LOGGER = Logger.getLogger(AuthorService.class);

  @Inject
  EntityManager em;

  @Transactional(REQUIRED)
  public Author persistAuthor(Author author) {
    em.persist(author);
    return author;
  }

  public List<Author> findAllAuthors() {
    return em.createQuery("select a from Author a", Author.class).getResultList();
  }

  public Optional<Author> findAuthorById(Long id) {
    Author author = em.find(Author.class, id);
    return author != null ? Optional.of(author) : Optional.empty();
  }

  @Transactional(REQUIRED)
  public Author updateAuthor(Author author) {
    return em.merge(author);
  }

  @Transactional(REQUIRED)
  public void deleteAuthor(Long id) {
    em.remove(em.find(Author.class, id));
  }

  public Optional<Author> findByName(String name) {
    Author author = em.createQuery("SELECT a FROM Author a WHERE a.lastName = :name", Author.class)
      .setParameter("name", name)
      .getSingleResult();
    return author != null ? Optional.of(author) : Optional.empty();
  }
}
