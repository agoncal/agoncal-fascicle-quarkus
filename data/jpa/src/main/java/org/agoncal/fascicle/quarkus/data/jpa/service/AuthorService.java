package org.agoncal.fascicle.quarkus.data.jpa.service;

import org.agoncal.fascicle.quarkus.data.jpa.model.Author;

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

  @Inject
  EntityManager em;

  @Transactional(REQUIRED)
  public Author persist(Author author) {
    em.persist(author);
    return author;
  }

  public List<Author> findAll() {
    return em.createQuery("select a from Author a", Author.class).getResultList();
  }

  public Optional<Author> findByIdOptional(Long id) {
    Author author = em.find(Author.class, id);
    return author != null ? Optional.of(author) : Optional.empty();
  }

  @Transactional(REQUIRED)
  public Author update(Author author) {
    return em.merge(author);
  }

  @Transactional(REQUIRED)
  public void deleteById(Long id) {
    em.remove(em.find(Author.class, id));
  }

  public Optional<Author> findByName(String name) {
    Author author = em.createQuery("SELECT a FROM Author a WHERE a.lastName = :name", Author.class)
      .setParameter("name", name)
      .getSingleResult();
    return author != null ? Optional.of(author) : Optional.empty();
  }
}
