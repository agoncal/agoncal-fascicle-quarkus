package org.agoncal.fascicle.quarkus.data.panache.repository;

import io.quarkus.hibernate.orm.panache.Panache;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.agoncal.fascicle.quarkus.data.panache.model.Author;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import java.util.Optional;

import static javax.transaction.Transactional.TxType.REQUIRED;

@ApplicationScoped
public class AuthorRepository implements PanacheRepository<Author> {

  @Transactional(REQUIRED)
  public Author update(Author author) {
    return Panache.getEntityManager().merge(author);
  }

  public Optional<Author> findByName(String name) {
    Author author = Panache.getEntityManager().createQuery("SELECT a FROM Author a WHERE a.lastName = :name", Author.class)
      .setParameter("name", name)
      .getSingleResult();
    return author != null ? Optional.of(author) : Optional.empty();
  }
}
